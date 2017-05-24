package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.*;
import com.xenenergy.projects.services.RouteService;
import com.xenenergy.projects.services.impl.DuAreaServiceImpl;
import com.xenenergy.projects.services.impl.RdmDetailServiceImpl;
import com.xenenergy.projects.services.impl.RouteDefinitionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by xesi on 22/05/2017.
 */
@Controller
@RequestMapping("/rdm")
public class RdmDetailController {

    private PaginationProperty property = new PaginationProperty();

    @Autowired
    private RdmDetailServiceImpl rdmDetailService;

    @Autowired
    private RouteDefinitionServiceImpl routeDefinitionService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private DuAreaServiceImpl duAreaService;

    @RequestMapping(value = "/{cid}/rdmdetails", method = RequestMethod.GET)
    public ModelAndView showPersonsPage(@PathVariable("cid") long cid, @RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("rdmdetails/index");
        int evalPageSize = pageSize.orElse(property.INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? property.INITIAL_PAGE : page.get() - 1;

        Page<RdmDetail> rdmDetailList = rdmDetailService.findAllByIdRdm(cid,
                new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(rdmDetailList.getTotalPages(), rdmDetailList.getNumber(), property.BUTTONS_TO_SHOW);

        modelAndView.addObject("rdmDetailLists", rdmDetailList);
        modelAndView.addObject("rdm", routeDefinitionService.getById(cid));
        modelAndView.addObject("route", routeService.getAll());
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", property.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }

    @GetMapping("/{cid}/rdmdetails/add")
    public String addForm(@PathVariable("cid") long cid, Model model){
        model.addAttribute("rdm", routeDefinitionService.getById(cid));
        model.addAttribute("rdmdetailsLists", new RdmDetail());
        /*model.addAttribute("routeList", routeService.getAll());*/
        model.addAttribute("areaList", duAreaService.getAll());
        return "rdmdetails/add";
    }

    @PostMapping("{cid}/rdmdetails/create")
    public String save(@PathVariable("cid") long cid, @Valid @ModelAttribute("rdmdetailsLists") RdmDetail rdmDetail,
                       BindingResult bindingResult, final RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            for(FieldError err:bindingResult.getFieldErrors()){
                System.out.println(err.getDefaultMessage());
            }
            return "redirect:add";
        }else{
            if(rdmDetailService.insert(rdmDetail) != null){
                redirectAttributes.addFlashAttribute("save", "success");
            }else{
                redirectAttributes.addFlashAttribute("save", "unsuccess");
            }
        }
        return "redirect:/rdm/"+cid+"/rdmdetails";
    }

    @GetMapping("/{cid}/rdmdetails/{operation}/{id}")
    public String editDeleteForm(@PathVariable("cid") long cid, @PathVariable("operation") String operation,
                                 @PathVariable("id") long id, Model model, RedirectAttributes redirectAttributes){

        if(operation.equals("delete")){
            if(rdmDetailService.deleteById(id)){
                redirectAttributes.addFlashAttribute("delete", "success");
            }else{
                redirectAttributes.addFlashAttribute("delete", "unsuccess");
            }
        }else if(operation.equals("edit")){
            if(rdmDetailService.getById(id) != null){
                model.addAttribute("rdm", routeDefinitionService.getById(cid));
                model.addAttribute("rdmdetailsLists", rdmDetailService.getById(id));
                model.addAttribute("routeList", routeService.getAll());
                return "rdmdetails/edit";
            }else{
                redirectAttributes.addFlashAttribute("status", "notfound");
            }
        }
        return "redirect:/rdm/"+cid+"/rdmdetails";
    }

    @PostMapping("/{cid}/rdmdetails/update")
    public String update(@PathVariable("cid") long cid, @ModelAttribute("rdmdetailsLists") RdmDetail rdmDetail,
                         final RedirectAttributes redirectAttributes){
        if(rdmDetailService.update(rdmDetail) != null){
            redirectAttributes.addFlashAttribute("edit", "success");
        }else{
            redirectAttributes.addFlashAttribute("edit", "unsuccess");
        }
        return "redirect:/rdm/"+cid+"/rdmdetails";
    }
}
