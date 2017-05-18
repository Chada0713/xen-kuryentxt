package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.LifeLine;
import com.xenenergy.projects.entities.Pager;
import com.xenenergy.projects.services.impl.LifeLineServiceImpl;
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
@RequestMapping("/lifeline")
public class LifeLineController {
    private static final int BUTTONS_TO_SHOW = 5;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 10;
    private static final int[] PAGE_SIZES = {10, 20, 50, 100};

    @Autowired
    LifeLineServiceImpl lifeLineService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showPersonsPage(@RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("lifeline/index");
        // Evaluate page size. If requested parameter is null, return initial
        // page size
        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        // Evaluate page. If requested parameter is null or less than 0 (to
        // prevent exception), return initial size. Otherwise, return value of
        // param. decreased by 1.
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

        Page<LifeLine> lifeLines = lifeLineService.findAllPageable(new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(lifeLines.getTotalPages(), lifeLines.getNumber(), BUTTONS_TO_SHOW);

        modelAndView.addObject("lifeLineLists", lifeLines);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }

    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("lifeLine", new LifeLine());
        return "lifeline/add";
    }

    @PostMapping("/create")
    public String save(LifeLine lifeLine, RedirectAttributes redirectAttributes){
        if(lifeLineService.insert(lifeLine) != null){
            redirectAttributes.addFlashAttribute("save", "success");
        }else{
            redirectAttributes.addFlashAttribute("save", "unsuccess");
        }
        return "redirect:/lifeline";
    }

    @GetMapping("/{operation}/{id}")
    public String editDeleteForm(@PathVariable("operation") String operation, @PathVariable("id") int id,
                                 Model model, final RedirectAttributes redirectAttributes){
        if(operation.equals("delete")){
            if (lifeLineService.deleteById(id)){
                redirectAttributes.addFlashAttribute("delete", "success");
            }else{
                redirectAttributes.addFlashAttribute("delete", "unsuccess");
            }
        }else if(operation.equals("edit")){
            if(lifeLineService.getById(id) != null ){
                model.addAttribute("lifeLine", lifeLineService.getById(id));
                return "lifeline/edit";
            }else{
                redirectAttributes.addFlashAttribute("status", "notfound");
            }
        }
        return "redirect:/lifeline";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("lifeLine") LifeLine lifeLine, final RedirectAttributes redirectAttributes){
        if(lifeLineService.update(lifeLine) != null){
            redirectAttributes.addFlashAttribute("edit", "success");
        }else{
            redirectAttributes.addFlashAttribute("edit", "unsuccess");
        }
        return "redirect:/lifeline";
    }
}