package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.FixedChargeTemplate;
import com.xenenergy.projects.entities.Pager;
import com.xenenergy.projects.entities.PaginationProperty;
import com.xenenergy.projects.services.interfaces.FixedChargeTemplateService;
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
 * Created by xesi on 23/06/2017.
 */
@Controller
@SessionAttributes("caller")
@RequestMapping("/fixedchargetemplate")
public class FixedChargeTemplateController {
    private PaginationProperty property = new PaginationProperty();

    @Autowired
    private FixedChargeTemplateService fixedChargeTemplateService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showPersonsPage(@RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("fixedchargetemplate/index");
        int evalPageSize = pageSize.orElse(property.INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? property.INITIAL_PAGE : page.get() - 1;

        Page<FixedChargeTemplate> fixedChargeTemplateList = fixedChargeTemplateService.findAllPageable(new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(fixedChargeTemplateList.getTotalPages(), fixedChargeTemplateList.getNumber(), property.BUTTONS_TO_SHOW);

        modelAndView.addObject("fixedChargeTemplateLists", fixedChargeTemplateList);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", property.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }

    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("fixedChargeTemplateLists", new FixedChargeTemplate());
        model.addAttribute("printOrder", fixedChargeTemplateService.findTopByPrintOrderOrderByPrintOrderDesc());
        return "fixedchargetemplate/add";
    }

    @PostMapping("/create")
    public String save(FixedChargeTemplate fixedChargeTemplate, Model model,
                       final RedirectAttributes redirectAttributes){
        if(fixedChargeTemplateService.insert(fixedChargeTemplate) != null){
            redirectAttributes.addFlashAttribute("save", "success");
        }else{
            redirectAttributes.addFlashAttribute("save", "unsuccess");
        }
        return "redirect:/fixedchargetemplate";
    }

    @GetMapping("/{operation}/{id}")
    public String editDeleteForm(@PathVariable("operation") String operation, @PathVariable("id") long id,
                                 Model model, final RedirectAttributes redirectAttributes){
        if(operation.equals("delete")){
            if(fixedChargeTemplateService.deleteById(id)){
                redirectAttributes.addFlashAttribute("delete", "success");
            }else{
                redirectAttributes.addFlashAttribute("delete", "unsuccess");
            }
        }else if(operation.equals("edit")){
            if(fixedChargeTemplateService.getById(id) != null){
                model.addAttribute("fixedChargeTemplateLists", fixedChargeTemplateService.getById(id));
                return "fixedchargetemplate/edit";
            }else{
                model.addAttribute("status", "notfound");
            }
        }
        return "redirect:/fixedchargetemplate";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("fixedChargeTemplateLists") FixedChargeTemplate fixedChargeTemplate,
                         final RedirectAttributes redirectAttributes){
        if(fixedChargeTemplateService.update(fixedChargeTemplate) != null){
            redirectAttributes.addFlashAttribute("edit", "success");
        }else{
            redirectAttributes.addFlashAttribute("edit", "unsuccess");
        }
        return "redirect:/fixedchargetemplate";
    }
}
