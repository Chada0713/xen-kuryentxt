package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.*;
import com.xenenergy.projects.services.interfaces.CRUDService;
import com.xenenergy.projects.services.interfaces.AccountService;
import com.xenenergy.projects.services.interfaces.PropertyService;
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
import java.util.List;
import java.util.Optional;

/**
 * Created by xesi on 16/05/2017.
 */
@Controller
@SessionAttributes("caller")
@RequestMapping("/seniorcitizen")
public class SeniorCitizenController {
    private PaginationProperty property = new PaginationProperty();

    @Autowired
    private CRUDService<SeniorCitizen> seniorCitizenService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private PropertyService propertyService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showPersonsPage(@RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("seniorcitizen/index");
        // Evaluate page size. If requested parameter is null, return initial
        // page size
        int evalPageSize = pageSize.orElse(property.INITIAL_PAGE_SIZE);
        // Evaluate page. If requested parameter is null or less than 0 (to
        // prevent exception), return initial size. Otherwise, return value of
        // param. decreased by 1.
        int evalPage = (page.orElse(0) < 1) ? property.INITIAL_PAGE : page.get() - 1;

        /*Page<SeniorCitizen> seniorCitizen = seniorCitizenService.findAllPageable(new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(seniorCitizen.getTotalPages(), seniorCitizen.getNumber(), property.BUTTONS_TO_SHOW);*/

        List<Property> seniorCitizen = propertyService.getAllScProperty();

        modelAndView.addObject("seniorCitizenLists", seniorCitizen);
        modelAndView.addObject("countOfSenior", accountService.findCountOfSenior());
        modelAndView.addObject("countOfId", accountService.findCountOfId());
        /*modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", property.PAGE_SIZES);
        modelAndView.addObject("pager", pager);*/
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

    /*@GetMapping("/{operation}/{id}")
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
    }*/

    @GetMapping("/edit")
    public String editForm(Model model){
        PropertyWrapper duProperty = new PropertyWrapper();
        duProperty.setProperties(propertyService.getAllScProperty());
        model.addAttribute("seniorCitizenLists", duProperty);
        return "seniorcitizen/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("seniorCitizenLists") PropertyWrapper seniorCitizen,
                         final RedirectAttributes redirectAttributes){
        for(Property property : seniorCitizen.getProperties()){
            if(propertyService.update(property) != null){
                redirectAttributes.addFlashAttribute("edit", "success");
            }else{
                redirectAttributes.addFlashAttribute("edit", "unsuccess");
            }
        }

        return "redirect:/seniorcitizen";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
