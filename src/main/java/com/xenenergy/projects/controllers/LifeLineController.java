package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.LifeLine;
import com.xenenergy.projects.entities.Pager;
import com.xenenergy.projects.entities.PaginationProperty;
import com.xenenergy.projects.services.interfaces.LifelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Controller
@SessionAttributes("caller")
@RequestMapping("/lifeline")
public class LifeLineController {
    private PaginationProperty property = new PaginationProperty();

    @Autowired
    private LifelineService lifeLineService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showPersonsPage(@RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("lifeline/index");
        // Evaluate page size. If requested parameter is null, return initial
        // page size
        int evalPageSize = pageSize.orElse(property.INITIAL_PAGE_SIZE);
        // Evaluate page. If requested parameter is null or less than 0 (to
        // prevent exception), return initial size. Otherwise, return value of
        // param. decreased by 1.
        int evalPage = (page.orElse(0) < 1) ? property.INITIAL_PAGE : page.get() - 1;

        Page<LifeLine> lifeLines = lifeLineService.findAllPageable(new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(lifeLines.getTotalPages(), lifeLines.getNumber(), property.BUTTONS_TO_SHOW);

        modelAndView.addObject("lifeLineLists", lifeLines);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", property.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("lifeLine", new LifeLine());
        return "lifeline/add";
    }

    /*public String save(@Valid LifeLine lifeLine, BindingResult bindingResult, RedirectAttributes redirectAttributes){*/
    @PostMapping("/create")
    public String save(LifeLine lifeLine, RedirectAttributes redirectAttributes) {
        if (lifeLineService.insert(lifeLine) != null) {
            redirectAttributes.addFlashAttribute("save", "success");
        } else {
            redirectAttributes.addFlashAttribute("save", "unsuccess");
        }
        return "redirect:/lifeline";
    }

    @GetMapping("/{operation}/{id}")
    public String editDeleteForm(@PathVariable("operation") String operation, @PathVariable("id") int id,
                                 Model model, final RedirectAttributes redirectAttributes) {
        if (operation.equals("delete")) {
            if (lifeLineService.deleteById(id)) {
                redirectAttributes.addFlashAttribute("delete", "success");
            } else {
                redirectAttributes.addFlashAttribute("delete", "unsuccess");
            }
        } else if (operation.equals("edit")) {
            if (lifeLineService.getById(id) != null) {
                model.addAttribute("lifeLine", lifeLineService.getById(id));
                return "lifeline/edit";
            } else {
                redirectAttributes.addFlashAttribute("status", "notfound");
            }
        }
        return "redirect:/lifeline";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("lifeLine") LifeLine lifeLine, final RedirectAttributes redirectAttributes) {
        if (lifeLineService.update(lifeLine) != null) {
            redirectAttributes.addFlashAttribute("edit", "success");
        } else {
            redirectAttributes.addFlashAttribute("edit", "unsuccess");
        }
        return "redirect:/lifeline";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
