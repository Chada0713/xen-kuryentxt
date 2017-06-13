package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.Pager;
import com.xenenergy.projects.entities.PaginationProperty;
import com.xenenergy.projects.entities.Rdm;
import com.xenenergy.projects.services.ReadersService;
import com.xenenergy.projects.services.interfaces.MeterReaderService;
import com.xenenergy.projects.services.interfaces.RouteDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
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
@SessionAttributes("caller")
@RequestMapping("/rdm")
public class RouteDefinitionController {
    private PaginationProperty property = new PaginationProperty();

    @Autowired
    private RouteDefinitionService definitionService;

    @Autowired
    private ReadersService readersService;

    @Autowired
    private MeterReaderService meterReaderService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showPersonsPage(@RequestParam(value = "searchStr") Optional<String> searchStr,
                                        @RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page) {
        String search = "";
        if(searchStr.isPresent()){
            search = searchStr.get();
        }
        ModelAndView modelAndView = new ModelAndView("rdm/index");
        int evalPageSize = pageSize.orElse(property.INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? property.INITIAL_PAGE : page.get() - 1;

        Page<Rdm> rdms = definitionService.findByRdmNameOrIdContaining(search, new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(rdms.getTotalPages(), rdms.getNumber(), property.BUTTONS_TO_SHOW);
        /*Page<Rdm> rdmsearch = definitionService.findByRdmNameAndIdContaining()*/

        modelAndView.addObject("rdmlists", rdms);
        modelAndView.addObject("rdm", new Rdm());
        modelAndView.addObject("meterReader", meterReaderService.findAll());
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", property.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }


    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("rdm", new Rdm());
        model.addAttribute("readers", readersService.getAll());
        return "rdm/add";
    }

    @PostMapping("/create")
    public String save(Rdm rdm, final RedirectAttributes redirectAttributes) {
        if (definitionService.insert(rdm) != null) {
            redirectAttributes.addFlashAttribute("save", "success");
        } else {
            redirectAttributes.addFlashAttribute("save", "unsuccess");
        }
        return "redirect:/rdm";
    }

    @GetMapping("/{operation}/{id}")
    public String editDeleteForm(@PathVariable("id") long id, @PathVariable("operation") String operation,
                                 Model model, final RedirectAttributes redirectAttributes) {
        if (operation.equals("delete")) {
            if (definitionService.deleteById(id)) {
                redirectAttributes.addFlashAttribute("delete", "success");
            } else {
                redirectAttributes.addFlashAttribute("delete", "unsuccess");
            }
        } else if (operation.equals("edit")) {
            if (definitionService.getById(id) != null) {
                model.addAttribute("rdm", definitionService.getById(id));
                model.addAttribute("readers", readersService.getAll());
                return "rdm/edit";
            } else {
                redirectAttributes.addFlashAttribute("status", "notfound");
            }
        }

        return "redirect:/rdm";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("duArea") Rdm rdm,
                         final RedirectAttributes redirectAttributes) {
        if (definitionService.update(rdm) != null) {
            redirectAttributes.addFlashAttribute("edit", "success");
        } else {
            redirectAttributes.addFlashAttribute("edit", "unsuccess");
        }
        return "redirect:/rdm";
    }

}
