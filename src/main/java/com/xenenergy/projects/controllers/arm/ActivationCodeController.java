package com.xenenergy.projects.controllers.arm;

import com.xenenergy.projects.entities.arm.ActivationCode;
import com.xenenergy.projects.entities.arm.Pager;
import com.xenenergy.projects.entities.arm.PaginationProperty;
import com.xenenergy.projects.services.RdmService;
import com.xenenergy.projects.services.ReadersService;
import com.xenenergy.projects.services.interfaces.arm.ActivationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/activation-code")
public class ActivationCodeController {

    private PaginationProperty property = new PaginationProperty();


    @Autowired
    private ActivationCodeService activationCodeService;
    @Autowired
    private RdmService rdmService;
    @Autowired
    private ReadersService readersService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showPersonsPage(@RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("activation/index");
        int evalPageSize = pageSize.orElse(property.INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? property.INITIAL_PAGE : page.get() - 1;

        Page<ActivationCode> activationCodes = activationCodeService.findAllPageable(new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(activationCodes.getTotalPages(), activationCodes.getNumber(), property.BUTTONS_TO_SHOW);

        modelAndView.addObject("activationCodelists", activationCodes);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", property.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("activationCodeObj", new ActivationCode());
        model.addAttribute("rdmlists", rdmService.getAll());
        model.addAttribute("readerslist", readersService.getAll());
        return "activation/add";
    }

    @PostMapping("/create")
    public String save(@Valid @ModelAttribute("activationCodeObj") ActivationCode activationCodeObj,
                       BindingResult bindingResult,
                       final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            System.out.println("Has errors="+bindingResult.hasErrors());
            for (FieldError err:bindingResult.getFieldErrors()){
                System.out.println(err.getDefaultMessage()); // Output: must be greater than or equal to 10
            }
            return "redirect:add";
        } else {
            if (activationCodeService.findActivationCode(activationCodeObj.getActivationCode()) != null) {
                redirectAttributes.addFlashAttribute("save", "unsuccess");
                return "redirect:add";
            } else {
                if (activationCodeService.insert(activationCodeObj) != null) {
                    redirectAttributes.addFlashAttribute("save", "success");
                } else {
                    redirectAttributes.addFlashAttribute("save", "unsuccess");
                }
                return "redirect:/activation-code";
            }
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
