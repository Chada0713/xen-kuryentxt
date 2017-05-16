package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.Pager;
import com.xenenergy.projects.entities.Remarks;
import com.xenenergy.projects.services.impl.RemarksServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

/**
 * Created by Daryll on 5/10/2017.
 */
@Controller
@RequestMapping("/remarks")
public class RemarksController {
    private static final int BUTTONS_TO_SHOW = 5;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 10;
    private static final int[] PAGE_SIZES = {10, 20, 50, 100};

    @Autowired
    RemarksServiceImpl remarksService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showPersonsPage(@RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("remarks/index");
        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

        Page<Remarks> remarkslist = remarksService.findAllPageable(new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(remarkslist.getTotalPages(), remarkslist.getNumber(), BUTTONS_TO_SHOW);

        modelAndView.addObject("remarkslists", remarkslist);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("remark", new Remarks());
        return "remarks/add";
    }

    @PostMapping("/create")
    public String save(Remarks remarks, final RedirectAttributes redirectAttributes) {
        if (remarksService.insert(remarks) != null) {
            redirectAttributes.addFlashAttribute("save", "success");
        } else {
            redirectAttributes.addFlashAttribute("save", "unsuccess");
        }
        return "redirect:/remarks";
    }

    @GetMapping("/{operation}/{id}")
    public String editDeleteForm(@PathVariable("id") long id, @PathVariable("operation") String operation,
                                 Model model, final RedirectAttributes redirectAttributes) {
        if (operation.equals("delete")) {
            if (remarksService.deleteById(id)) {
                redirectAttributes.addFlashAttribute("delete", "success");
            } else {
                redirectAttributes.addFlashAttribute("delete", "unsuccess");
            }
        } else if (operation.equals("edit")) {
            if (remarksService.getById(id) != null) {
                model.addAttribute("remarks", remarksService.getById(id));
                return "remarks/edit";
            } else {
                redirectAttributes.addFlashAttribute("status", "notfound");
            }
        }

        return "redirect:/remarks";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("remarks") Remarks remarks,
                         final RedirectAttributes redirectAttributes) {
        if (remarksService.update(remarks) != null) {
            redirectAttributes.addFlashAttribute("edit", "success");
        } else {
            redirectAttributes.addFlashAttribute("edit", "unsuccess");
        }

        return "redirect:/remarks";
    }
}
