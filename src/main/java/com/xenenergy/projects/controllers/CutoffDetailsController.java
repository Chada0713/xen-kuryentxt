package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.CutoffDetails;
import com.xenenergy.projects.entities.CutoffMaster;
import com.xenenergy.projects.entities.Pager;
import com.xenenergy.projects.entities.PaginationProperty;
import com.xenenergy.projects.services.interfaces.CutoffDetailsService;
import com.xenenergy.projects.services.interfaces.CutoffMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

/**
 * Created by xesi on 29/08/2017.
 */
@Controller
@SessionAttributes("caller")
@RequestMapping("/cut-off")
public class CutoffDetailsController {
    private PaginationProperty property = new PaginationProperty();

    @Autowired
    CutoffDetailsService cutoffDetailsService;

    @Autowired
    CutoffMasterService cutoffMasterService;

    @RequestMapping(value = "/{id}/details", method = RequestMethod.GET)
    public ModelAndView showPersonsPage(@PathVariable("id") long id, @RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("cutoffdetails/index");
        int evalPageSize = pageSize.orElse(property.INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? property.INITIAL_PAGE : page.get() - 1;

        Page<CutoffDetails> cutoffDetailsList = cutoffDetailsService.findAllByIdCutOffMasterOrderByIdDesc(id,
                new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(cutoffDetailsList.getTotalPages(), cutoffDetailsList.getNumber(), property.BUTTONS_TO_SHOW);

        modelAndView.addObject("cutoffmasterlist", cutoffDetailsList);
        modelAndView.addObject("idCutOffMaster", id);
        modelAndView.addObject("cutOffMasterList", cutoffMasterService.findAllByIdOrderByIdDesc(id));
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", property.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }

    @GetMapping("/{idCutOffMaster}/details/add")
    public String addForm(@PathVariable("idCutOffMaster") long idCutOffMaster, Model model){
        model.addAttribute("cutoffdetails", new CutoffDetails());
        model.addAttribute("idCutOffMaster", idCutOffMaster);
        return "cutoffdetails/add";
    }

    @PostMapping("/{idCutOffMaster}/details/create")
    public String save(@PathVariable("idCutOffMaster") long idCutOffMaster, CutoffDetails cutoffDetails, final RedirectAttributes redirectAttributes){
        if(cutoffDetailsService.insert(cutoffDetails) != null){
            redirectAttributes.addFlashAttribute("save", "success");
        }else{
            redirectAttributes.addFlashAttribute("save", "unsuccess");
        }
        return "redirect:/cut-off/"+idCutOffMaster+"/details";
    }

    @GetMapping("/{idCutOffMaster}/details/{operation}/{did}")
    public String editDeleteForm(@PathVariable("idCutOffMaster") long idCutOffMaster, @PathVariable("did") long did,
                                 @PathVariable("operation") String operation, Model model,
                                 final RedirectAttributes redirectAttributes){
        if(operation.equals("delete")){
            if(cutoffDetailsService.deleteById(did)){
                redirectAttributes.addFlashAttribute("delete", "success");
            }else{
                redirectAttributes.addFlashAttribute("delete", "unsuccess");
            }
        }else if(operation.equals("edit")){
            if(cutoffDetailsService.getById(did) != null){
                model.addAttribute("cutoffdetails", cutoffDetailsService.getById(did));
                model.addAttribute("idCutOffMaster", idCutOffMaster);
                return "cutoffdetails/edit";
            }else{
                redirectAttributes.addFlashAttribute("status", "notfound");
            }
        }
        return "redirect:/cut-off/"+idCutOffMaster+"/details";
    }

    @PostMapping("/{idCutOffMaster}/details/update")
    public String update(@PathVariable("idCutOffMaster") long idCutOffMaster, CutoffDetails cutoffDetails, final RedirectAttributes redirectAttributes){
        if(cutoffDetailsService.insert(cutoffDetails) != null){
            redirectAttributes.addFlashAttribute("edit", "success");
        }else{
            redirectAttributes.addFlashAttribute("edit", "unsuccess");
        }
        return "redirect:/cut-off/"+idCutOffMaster+"/details";
    }
}
