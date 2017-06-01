package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.Pager;
import com.xenenergy.projects.entities.PaginationProperty;
import com.xenenergy.projects.entities.Route;
import com.xenenergy.projects.services.interfaces.DuAreaService;
import com.xenenergy.projects.services.interfaces.RoutesService;
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
 * Created by xesi on 26/05/2017.
 */
@Controller
@RequestMapping("/du-area")
public class RoutesController {
    private PaginationProperty property = new PaginationProperty();

    @Autowired
    private RoutesService routesService;

    @Autowired
    DuAreaService duAreaService;

    @RequestMapping(value="/{cid}/routes", method = RequestMethod.GET)
    public ModelAndView showPersonsPage(@PathVariable("cid") long cid, @RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("routes/index");
        int evalPageSize = pageSize.orElse(property.INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? property.INITIAL_PAGE : page.get() - 1;

        Page<Route> routes = routesService.findByIdArea(cid, new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(routes.getTotalPages(), routes.getNumber(), property.BUTTONS_TO_SHOW);

        modelAndView.addObject("routelists", routes);
        modelAndView.addObject("duarea", duAreaService.getById(cid));
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", property.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }

    @GetMapping("/{cid}/routes/add")
    public String addForm(Model model, @PathVariable("cid") long cid){
        model.addAttribute("duarea", duAreaService.getById(cid));
        model.addAttribute("route", new Route());
        return "routes/add";
    }

    @PostMapping("/{cid}/routes/create")
    public String save(@PathVariable("cid") long cid, Route route, RedirectAttributes redirectAttributes){
        if(routesService.insert(route) != null){
            redirectAttributes.addFlashAttribute("save", "success");
        }else{
            redirectAttributes.addFlashAttribute("save", "unsuccess");
        }
        return "redirect:/du-area/"+cid+"/routes";
    }

    @GetMapping("/{cid}/routes/{operation}/{id}")
    public String editDeleteForm(@PathVariable("cid") long cid, @PathVariable("id") long id,
                                 @PathVariable("operation") String operation, Model model, RedirectAttributes redirectAttributes){
        if(operation.equals("delete")){
            if(routesService.deleteById(id)){
                redirectAttributes.addFlashAttribute("delete", "success");
            }else{
                redirectAttributes.addFlashAttribute("delete", "unsuccess");
            }
        }else if(operation.equals("edit")){
            if(routesService.getById(id)!=null){
                model.addAttribute("duarea", duAreaService.getById(cid));
                model.addAttribute("route", routesService.getById(id));
                return "routes/edit";
            }else{
                redirectAttributes.addFlashAttribute("status", "notfound");
            }
        }
        return "redirect:/du-area/"+cid+"/routes";
    }
}
