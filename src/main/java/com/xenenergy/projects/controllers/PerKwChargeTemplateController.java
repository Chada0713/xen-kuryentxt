package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.Pager;
import com.xenenergy.projects.entities.PaginationProperty;
import com.xenenergy.projects.entities.PerKwChargeTemplate;
import com.xenenergy.projects.services.interfaces.PerKwChargeTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by xesi on 23/06/2017.
 */
@Controller
@SessionAttributes("caller")
@RequestMapping("/perkwchargetemplate")
public class PerKwChargeTemplateController {

    private PaginationProperty property = new PaginationProperty();

    @Autowired
    private PerKwChargeTemplateService perKwChargeTemplateService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showPersonsPage(@RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("perkwchargetemplate/index");
        int evalPageSize = pageSize.orElse(property.INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? property.INITIAL_PAGE : page.get() - 1;

        Page<PerKwChargeTemplate> perKwChargeTemplateLists = perKwChargeTemplateService.findAllPageable(new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(perKwChargeTemplateLists.getTotalPages(), perKwChargeTemplateLists.getNumber(), property.BUTTONS_TO_SHOW);

        modelAndView.addObject("perKwChargeTemplateLists", perKwChargeTemplateLists);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", property.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }

    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("perKwChargeTemplateLists", new PerKwChargeTemplate());
        model.addAttribute("printOrder", perKwChargeTemplateService.findTopByPrintOrderOrderByPrintOrderDesc());
        return "perkwchargetemplate/add";
    }

    @PostMapping("/create")
    public String save(PerKwChargeTemplate perKwChargeTemplate, Model model,
                       final RedirectAttributes redirectAttributes){
        if(perKwChargeTemplateService.insert(perKwChargeTemplate) != null){
            redirectAttributes.addFlashAttribute("save", "success");
        }else{
            redirectAttributes.addFlashAttribute("save", "unsuccess");
        }
        return "redirect:/perkwchargetemplate";
    }

    @GetMapping("/{operation}/{id}")
    public String editDeleteForm(@PathVariable("operation") String operation, @PathVariable("id") long id,
                                 Model model, final RedirectAttributes redirectAttributes){
        if(operation.equals("delete")){
            if(perKwChargeTemplateService.deleteById(id)){
                redirectAttributes.addFlashAttribute("delete", "success");
            }else{
                redirectAttributes.addFlashAttribute("delete", "unsuccess");
            }
        }else if(operation.equals("edit")){
            if(perKwChargeTemplateService.getById(id) != null){
                model.addAttribute("perKwChargeTemplateLists", perKwChargeTemplateService.getById(id));
                return "perkwchargetemplate/edit";
            }else{
                redirectAttributes.addFlashAttribute("status", "notfound");
            }
        }
        return "redirect:/perkwchargetemplate";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("perKwChargeTemplateLists") PerKwChargeTemplate perKwChargeTemplate,
                         final RedirectAttributes redirectAttributes){
        if(perKwChargeTemplateService.update(perKwChargeTemplate) != null){
            redirectAttributes.addFlashAttribute("edit", "success");
        }else{
            redirectAttributes.addFlashAttribute("edit", "unsuccess");
        }
        return "redirect:/perkwchargetemplate";
    }
}
