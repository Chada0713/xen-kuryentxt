package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.CutoffMaster;
import com.xenenergy.projects.entities.Pager;
import com.xenenergy.projects.entities.PaginationProperty;
import com.xenenergy.projects.services.impl.CutoffMasterServiceImpl;
import com.xenenergy.projects.services.interfaces.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("cut-off")
public class CutoffMasterController {
    private PaginationProperty property = new PaginationProperty();

    @Autowired
    CutoffMasterServiceImpl cutoffMasterService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showPersonsPage(@RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("cutoff/index");
        int evalPageSize = pageSize.orElse(property.INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? property.INITIAL_PAGE : page.get() - 1;

        Page<CutoffMaster> cutoffMasterList = cutoffMasterService.findAllPageable(new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(cutoffMasterList.getTotalPages(), cutoffMasterList.getNumber(), property.BUTTONS_TO_SHOW);

        modelAndView.addObject("cutoffmasterlist", cutoffMasterList);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", property.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("cutoff", new CutoffMaster());
        model.addAttribute("days", cutoffMasterService.getDays());
        return "cutoff/add";
    }

    @PostMapping("/create")
    public String save(CutoffMaster cutoffMaster, final RedirectAttributes redirectAttributes) {
        if (cutoffMasterService.insert(cutoffMaster) != null) {
            redirectAttributes.addFlashAttribute("save", "success");
        } else {
            redirectAttributes.addFlashAttribute("save", "unsuccess");
        }
        return "redirect:/cut-off";
    }

    @GetMapping("/{operation}/{id}")
    public String editDeleteForm(@PathVariable("id") long id, @PathVariable("operation") String operation,
                                 Model model, final RedirectAttributes redirectAttributes) {
        if (operation.equals("delete")) {
            if (cutoffMasterService.deleteById(id)) {
                redirectAttributes.addFlashAttribute("delete", "success");
            } else {
                redirectAttributes.addFlashAttribute("delete", "unsuccess");
            }
        } else if (operation.equals("edit")) {
            //CutoffMaster cutoffMaster = (CutoffMaster) cutoffMasterService.getById(id);
            if (cutoffMasterService.getById(id) != null) {
                model.addAttribute("cutoffMaster", cutoffMasterService.getById(id));
                model.addAttribute("days", cutoffMasterService.getDays());
                return "cutoff/edit";
            } else {
                redirectAttributes.addFlashAttribute("status", "notfound");
            }
        }

        return "redirect:/cut-off";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("cutoffMaster") CutoffMaster cutoffMaster,
                         final RedirectAttributes redirectAttributes) {
        if (cutoffMasterService.update(cutoffMaster) != null) {
            redirectAttributes.addFlashAttribute("edit", "success");
        } else {
            redirectAttributes.addFlashAttribute("edit", "unsuccess");
        }

        return "redirect:/cut-off";
    }
}
