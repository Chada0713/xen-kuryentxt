package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.Pager;
import com.xenenergy.projects.entities.PaginationProperty;
import com.xenenergy.projects.entities.Property;
import com.xenenergy.projects.services.interfaces.CRUDService;
import com.xenenergy.projects.services.interfaces.PropertyService;
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
@SessionAttributes("caller")
@RequestMapping("/properties")
public class PropertyController {

   private PaginationProperty property = new PaginationProperty();

    @Autowired
    private PropertyService propertyService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showPersonsPage(@RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("properties/index");
        int evalPageSize = pageSize.orElse(property.INITIAL_PAGE_SIZE);
        // Evaluate page. If requested parameter is null or less than 0 (to
        // prevent exception), return initial size. Otherwise, return value of
        // param. decreased by 1.
        int evalPage = (page.orElse(0) < 1) ? property.INITIAL_PAGE : page.get() - 1;

        Page<Property> properties = propertyService.findAllPageable(new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(properties.getTotalPages(), properties.getNumber(), property.BUTTONS_TO_SHOW);

        modelAndView.addObject("propertylists", properties);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", property.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("property", new Property());
        return "properties/add";
    }

    @PostMapping("/create")
    public String save(Property property, final RedirectAttributes redirectAttributes) {
        if (propertyService.insert(property) != null) {
            redirectAttributes.addFlashAttribute("save", "success");
        } else {
            redirectAttributes.addFlashAttribute("save", "unsuccess");
        }
        return "redirect:/properties";
    }

    @GetMapping("/{operation}/{id}")
    public String editDeleteForm(@PathVariable("id") int id, @PathVariable("operation") String operation,
                                 Model model, final RedirectAttributes redirectAttributes) {
        if (operation.equals("delete")) {
            if (propertyService.deleteById(id)) {
                redirectAttributes.addFlashAttribute("delete", "success");
            } else {
                redirectAttributes.addFlashAttribute("delete", "unsuccess");
            }
        } else if (operation.equals("edit")) {
            Property entity = propertyService.getById(id);
            if (entity != null) {
                model.addAttribute("property", entity);
                return "properties/edit";
            } else {
                redirectAttributes.addFlashAttribute("status", "notfound");
            }
        }

        return "redirect:/properties";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("property") Property property,
                         final RedirectAttributes redirectAttributes) {
        if (propertyService.update(property) != null) {
            redirectAttributes.addFlashAttribute("edit", "success");
        } else {
            redirectAttributes.addFlashAttribute("edit", "unsuccess");
        }

        return "redirect:/properties";
    }
}
