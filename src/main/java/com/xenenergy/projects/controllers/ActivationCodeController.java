package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.ActivationCode;
import com.xenenergy.projects.entities.Pager;
import com.xenenergy.projects.services.RdmService;
import com.xenenergy.projects.services.ReadersService;
import com.xenenergy.projects.services.impl.ActivationCodeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/activation-code")
public class ActivationCodeController {

    private static final int BUTTONS_TO_SHOW = 5;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 10;
    private static final int[] PAGE_SIZES = {10, 20, 50, 100};


    @Autowired
    private ActivationCodeServiceImpl activationCodeService;
    @Autowired
    private RdmService rdmService;
    @Autowired
    private ReadersService readersService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showPersonsPage(@RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("activation/index");
        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

        Page<ActivationCode> activationCodes = activationCodeService.findAllPageable(new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(activationCodes.getTotalPages(), activationCodes.getNumber(), BUTTONS_TO_SHOW);

        modelAndView.addObject("activationCodelists", activationCodes);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("activationCode", new ActivationCode());
        model.addAttribute("rdmlists", rdmService.getAll());
        model.addAttribute("readerslist", readersService.getAll());
        return "activation/add";
    }

    @PostMapping("/create")
    public String save(ActivationCode activationCode, final RedirectAttributes redirectAttributes) {
        if (activationCodeService.findActivationCode(activationCode.getActivationCode()) != null) {
            redirectAttributes.addFlashAttribute("save", "unsuccess");
            return "redirect:add";
        } else {
            if (activationCodeService.insert(activationCode) != null) {
                redirectAttributes.addFlashAttribute("save", "success");
            } else {
                redirectAttributes.addFlashAttribute("save", "unsuccess");
            }
            return "redirect:/activation-code";
        }
    }

    @GetMapping("/{operation}/{id}")
    public String editDeleteForm(@PathVariable("id") int id, @PathVariable("operation") String operation,
                                 Model model, final RedirectAttributes redirectAttributes) {
        if (operation.equals("delete")) {
            if (activationCodeService.deleteById(id)) {
                redirectAttributes.addFlashAttribute("delete", "success");
            } else {
                redirectAttributes.addFlashAttribute("delete", "unsuccess");
            }
        } else if (operation.equals("edit")) {
            ActivationCode activationCode = activationCodeService.getById(id);
            if (activationCode != null) {
                model.addAttribute("activationCode", activationCode);
                model.addAttribute("rdmlists", rdmService.getAll());
                model.addAttribute("readerslist", readersService.getAll());
                return "activation/edit";
            } else {
                redirectAttributes.addFlashAttribute("status", "notfound");
            }
        }

        return "redirect:/activation-code";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("activationCode") ActivationCode activationCode,
                         final RedirectAttributes redirectAttributes) {
        if (activationCodeService.update(activationCode) != null) {
            redirectAttributes.addFlashAttribute("edit", "success");
        } else {
            redirectAttributes.addFlashAttribute("edit", "unsuccess");
        }

        return "redirect:/activation-code";
    }

}
