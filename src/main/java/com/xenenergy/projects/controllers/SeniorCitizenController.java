package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.Pager;
import com.xenenergy.projects.entities.SeniorCitizen;
import com.xenenergy.projects.services.impl.SeniorCitizenServiceImpl;
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
 * Created by xesi on 16/05/2017.
 */
@Controller
@RequestMapping("/seniorcitizen")
public class SeniorCitizenController {
    private static final int BUTTONS_TO_SHOW = 5;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 10;
    private static final int[] PAGE_SIZES = {10, 20, 50, 100};

    @Autowired
    SeniorCitizenServiceImpl seniorCitizenService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showPersonsPage(@RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("seniorcitizen/index");
        // Evaluate page size. If requested parameter is null, return initial
        // page size
        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        // Evaluate page. If requested parameter is null or less than 0 (to
        // prevent exception), return initial size. Otherwise, return value of
        // param. decreased by 1.
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

        Page<SeniorCitizen> seniorCitizen = seniorCitizenService.findAllPageable(new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(seniorCitizen.getTotalPages(), seniorCitizen.getNumber(), BUTTONS_TO_SHOW);

        modelAndView.addObject("seniorCitizenLists", seniorCitizen);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }

    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("seniorCitizen", new SeniorCitizen());
        return "seniorcitizen/add";
    }

    @PostMapping("/create")
    public String save(SeniorCitizen seniorCitizen, RedirectAttributes redirectAttributes){
        if(seniorCitizenService.insert(seniorCitizen) != null){
            redirectAttributes.addFlashAttribute("save", "success");
        }else{
            redirectAttributes.addFlashAttribute("save", "unsuccess");
        }
        return "redirect:/seniorcitizen";
    }

    @GetMapping("/{operation}/{id}")
    public String editDeleteForm(@PathVariable("operation") String operation, @PathVariable int id,
                                 Model model, final RedirectAttributes redirectAttributes){
        if(operation.equals("delete")){
            if(seniorCitizenService.deleteById(id)){
                redirectAttributes.addFlashAttribute("delete", "success");
            }else{
                redirectAttributes.addFlashAttribute("delete", "unsuccess");
            }
        }else if(operation.equals("edit")){
            if(seniorCitizenService.getById(id) != null){
                model.addAttribute("seniorCitizen", seniorCitizenService.getById(id));
                return "seniorcitizen/edit";
            }else{
                redirectAttributes.addFlashAttribute("status", "notfound");
            }
        }
        return "redirect:/seniorcitizen";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("seniorCitizen") SeniorCitizen seniorCitizen, final RedirectAttributes redirectAttributes){
        if(seniorCitizenService.insert(seniorCitizen) != null){
            redirectAttributes.addFlashAttribute("edit", "success");
        }else{
            redirectAttributes.addFlashAttribute("edit", "unsuccess");
        }
        return "redirect:/seniorcitizen";
    }
}
