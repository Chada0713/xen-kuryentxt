package com.xenenergy.projects.controllers.arm;

import com.xenenergy.projects.entities.arm.Pager;
import com.xenenergy.projects.entities.arm.PaginationProperty;
import com.xenenergy.projects.entities.arm.RateMaster;
import com.xenenergy.projects.services.impl.arm.RateMasterServiceImpl;
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
 * Created by xesi on 15/05/2017.
 */
@Controller
@RequestMapping("/ratemaster")

public class RateMasterController {
    private PaginationProperty property = new PaginationProperty();

    @Autowired
    RateMasterServiceImpl rateMasterService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showPersonsPage(@RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("ratemaster/index");
        // Evaluate page size. If requested parameter is null, return initial
        // page size
        int evalPageSize = pageSize.orElse(property.INITIAL_PAGE_SIZE);
        // Evaluate page. If requested parameter is null or less than 0 (to
        // prevent exception), return initial size. Otherwise, return value of
        // param. decreased by 1.
        int evalPage = (page.orElse(0) < 1) ? property.INITIAL_PAGE : page.get() - 1;

        Page<RateMaster> rateMasters = rateMasterService.findAllPageable(new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(rateMasters.getTotalPages(), rateMasters.getNumber(), property.BUTTONS_TO_SHOW);

        modelAndView.addObject("rateMasterLists", rateMasters);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", property.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }

    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("rateMaster", new RateMaster());
        return "ratemaster/add";
    }

    @PostMapping("/create")
    public String save(RateMaster rateMaster, RedirectAttributes redirectAttributes){
        if(rateMasterService.insert(rateMaster) != null ){
            redirectAttributes.addFlashAttribute("save", "success");
        }else{
            redirectAttributes.addFlashAttribute("save", "unsuccess");
        }
        return "redirect:/ratemaster";
    }

    @GetMapping("/{operation}/{id}")
    public String editDeleteForm(@PathVariable("operation") String operation, @PathVariable("id") int id,
                                 Model model, final RedirectAttributes redirectAttributes){
        if(operation.equals("delete")){
            if(rateMasterService.deleteById(id)){
                redirectAttributes.addFlashAttribute("delete", "success");
            }else{
                redirectAttributes.addFlashAttribute("delete", "unsuccess");
            }
        }else if(operation.equals("edit")){
            if(rateMasterService.getById(id) != null){
                model.addAttribute("rateMaster", rateMasterService.getById(id));
                return "ratemaster/edit";
            }else{
                redirectAttributes.addFlashAttribute("status", "notfound");
            }
        }
        return "redirect:/ratemaster";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("rateMaster") RateMaster rateMaster, final RedirectAttributes redirectAttributes){
        if(rateMasterService.update(rateMaster) != null){
            redirectAttributes.addFlashAttribute("edit", "success");
        }else{
            redirectAttributes.addFlashAttribute("edit", "unsuccess");
        }
        return "redirect:/ratemaster";
    }
}
