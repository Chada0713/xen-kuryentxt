package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.Meter;
import com.xenenergy.projects.entities.Pager;
import com.xenenergy.projects.entities.PaginationProperty;
import com.xenenergy.projects.services.RdmService;
import com.xenenergy.projects.services.interfaces.MeterService;
import com.xenenergy.projects.services.interfaces.RoutesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**
 * Created by xesi on 27/07/2017.
 */
@Controller
@SessionAttributes("caller")
@RequestMapping("/rdm")
public class MeterController {
    private PaginationProperty property = new PaginationProperty();

    @Autowired
    private MeterService meterService;

    @Autowired
    private RdmService rdmService;

    @Autowired
    private RoutesService routesService;

    @RequestMapping(value = "/{cid}/rdmdetails/{id}", method = RequestMethod.GET)
    public ModelAndView showPersonsPage(@PathVariable("cid") long cid, @PathVariable("id") long id,
                                        @RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("meter/index");
        int evalPageSize = pageSize.orElse(property.INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? property.INITIAL_PAGE : page.get() - 1;

        Page<Meter> meterList = meterService.findByIdRoute(id, new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(meterList.getTotalPages(), meterList.getNumber(), property.BUTTONS_TO_SHOW);

        String rmdName = rdmService.getById(cid).getRdmName();
        String routeName = routesService.getById(id).getRouteName();
        String header = "RDM: " + cid + " ROUTE: " + id + " (" + routeName + ") ";

        modelAndView.addObject("meterLists", meterList);
        modelAndView.addObject("rdm", cid);
        modelAndView.addObject("routeId", id);
        modelAndView.addObject("prevPageUrl", "/Kuryentxt/rdm/" + Long.toString(cid) + "/rdmdetails");
        modelAndView.addObject("header", header);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", property.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }
}
