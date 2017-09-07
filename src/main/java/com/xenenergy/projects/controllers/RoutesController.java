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
@SessionAttributes("caller")
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
        modelAndView.addObject("codesort", "nosorted");
        modelAndView.addObject("namesort", "nosorted");
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

    /*=== Sort Code Desc ===*/
    @RequestMapping(value="/{cid}/routes/sortcodedesc", method = RequestMethod.GET)
    public ModelAndView sortCodeDesc(@PathVariable("cid") long cid, @RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("routes/index");
        int evalPageSize = pageSize.orElse(property.INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? property.INITIAL_PAGE : page.get() - 1;

        Page<Route> routes = routesService.findByIdAreaOrderByRouteCode(cid, new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(routes.getTotalPages(), routes.getNumber(), property.BUTTONS_TO_SHOW);

        modelAndView.addObject("routelists", routes);
        modelAndView.addObject("duarea", duAreaService.getById(cid));
        modelAndView.addObject("codesort", "sorted");
        modelAndView.addObject("namesort", "nosorted");
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", property.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }

    /*=== Sort Code Asc ===*/
    @RequestMapping(value="/{cid}/routes/sortcodeasc", method = RequestMethod.GET)
    public ModelAndView sortCodeAsc(@PathVariable("cid") long cid, @RequestParam("pageSize") Optional<Integer> pageSize,
                                     @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("routes/index");
        int evalPageSize = pageSize.orElse(property.INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? property.INITIAL_PAGE : page.get() - 1;

        Page<Route> routes = routesService.findByIdAreaOrderByRouteCodeDesc(cid, new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(routes.getTotalPages(), routes.getNumber(), property.BUTTONS_TO_SHOW);

        modelAndView.addObject("routelists", routes);
        modelAndView.addObject("duarea", duAreaService.getById(cid));
        modelAndView.addObject("codesort", "unsorted");
        modelAndView.addObject("namesort", "nosorted");
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", property.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }

    /*=== Sort Name Desc ===*/
    @RequestMapping(value="/{cid}/routes/sortnamedesc", method = RequestMethod.GET)
    public ModelAndView sortNameDesc(@PathVariable("cid") long cid, @RequestParam("pageSize") Optional<Integer> pageSize,
                                     @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("routes/index");
        int evalPageSize = pageSize.orElse(property.INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? property.INITIAL_PAGE : page.get() - 1;

        Page<Route> routes = routesService.findByIdAreaOrderByRouteName(cid, new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(routes.getTotalPages(), routes.getNumber(), property.BUTTONS_TO_SHOW);

        modelAndView.addObject("routelists", routes);
        modelAndView.addObject("duarea", duAreaService.getById(cid));
        modelAndView.addObject("namesort", "sorted");
        modelAndView.addObject("codesort", "nosorted");
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", property.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }

    /*=== Sort Name Asc ===*/
    @RequestMapping(value="/{cid}/routes/sortnameasc", method = RequestMethod.GET)
    public ModelAndView sortNameAsc(@PathVariable("cid") long cid, @RequestParam("pageSize") Optional<Integer> pageSize,
                                    @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("routes/index");
        int evalPageSize = pageSize.orElse(property.INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? property.INITIAL_PAGE : page.get() - 1;

        Page<Route> routes = routesService.findByIdAreaOrderByRouteNameDesc(cid, new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(routes.getTotalPages(), routes.getNumber(), property.BUTTONS_TO_SHOW);

        modelAndView.addObject("routelists", routes);
        modelAndView.addObject("duarea", duAreaService.getById(cid));
        modelAndView.addObject("namesort", "unsorted");
        modelAndView.addObject("codesort", "nosorted");
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", property.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }

    @RequestMapping(value = "/route/{id}/routename", method = RequestMethod.GET)
    public String routeName(@PathVariable("id") long id){
        return routesService.findRouteName(id);
    }
}
