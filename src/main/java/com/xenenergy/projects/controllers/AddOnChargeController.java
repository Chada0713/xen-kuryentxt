package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.AddOnCharge;
import com.xenenergy.projects.entities.Pager;
import com.xenenergy.projects.entities.PaginationProperty;
import com.xenenergy.projects.services.interfaces.AddOnChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**
 * Created by xesi on 16/05/2017.
 */
@Controller
@SessionAttributes("caller")
@RequestMapping("/addoncharge")
public class AddOnChargeController {
    private PaginationProperty property = new PaginationProperty();

    @Autowired
    private AddOnChargeService addOnChargeService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showPersonsPage(@RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("addoncharge/index");
        int evalPageSize = pageSize.orElse(property.INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? property.INITIAL_PAGE : page.get() - 1;

        Page<AddOnCharge> addOnCharges = addOnChargeService.findAllPageable(new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(addOnCharges.getTotalPages(), addOnCharges.getNumber(), property.BUTTONS_TO_SHOW);

        modelAndView.addObject("addOnChargeLists", addOnCharges);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", property.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }
}
