package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.DuArea;
import com.xenenergy.projects.entities.Pager;
import com.xenenergy.projects.entities.PaginationProperty;
import com.xenenergy.projects.services.impl.DuAreaServiceImpl;
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
 * Created by xenuser on 5/10/2017.
 */
@Controller
@RequestMapping("/du-area")
public class DuAreaController {
    private PaginationProperty property = new PaginationProperty();


    @Autowired
    DuAreaServiceImpl duAreaService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showPersonsPage(@RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("duarea/index");
        int evalPageSize = pageSize.orElse(property.INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? property.INITIAL_PAGE : page.get() - 1;

        Page<DuArea> areas = duAreaService.findAllPageable(new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(areas.getTotalPages(), areas.getNumber(), property.BUTTONS_TO_SHOW);

        modelAndView.addObject("arealists", areas);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", property.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("duArea", new DuArea());
        return "duarea/add";
    }

    @PostMapping("/create")
    public String save(DuArea duArea, final RedirectAttributes redirectAttributes) {
        if (duAreaService.insert(duArea) != null) {
            redirectAttributes.addFlashAttribute("save", "success");
        } else {
            redirectAttributes.addFlashAttribute("save", "unsuccess");
        }
        return "redirect:/du-area";
    }

    @GetMapping("/{operation}/{id}")
    public String editDeleteForm(@PathVariable("id") long id, @PathVariable("operation") String operation,
                                 Model model, final RedirectAttributes redirectAttributes) {
        if (operation.equals("delete")) {
            if (duAreaService.deleteById(id)) {
                redirectAttributes.addFlashAttribute("delete", "success");
            } else {
                redirectAttributes.addFlashAttribute("delete", "unsuccess");
            }
        } else if (operation.equals("edit")) {
            if (duAreaService.getById(id) != null) {
                model.addAttribute("duArea", duAreaService.getById(id));
                return "duarea/edit";
            } else {
                redirectAttributes.addFlashAttribute("status", "notfound");
            }
        }

        return "redirect:/du-area";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("duArea") DuArea duArea,
                         final RedirectAttributes redirectAttributes) {
        if (duAreaService.update(duArea) != null) {
            redirectAttributes.addFlashAttribute("edit", "success");
        } else {
            redirectAttributes.addFlashAttribute("edit", "unsuccess");
        }

        return "redirect:/du-area";
    }
}
