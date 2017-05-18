package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.Pager;
import com.xenenergy.projects.entities.PaginationProperty;
import com.xenenergy.projects.entities.PerKwChargeMaster;
import com.xenenergy.projects.services.impl.PerKwChargeMasterServiceImpl;
import com.xenenergy.projects.services.impl.RateMasterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**
 * Created by xenuser on 5/18/2017.
 */
@Controller
@RequestMapping("/ratemaster")
public class PerKwChargeMasterController {

    private PaginationProperty property = new PaginationProperty();

    @Autowired
    private PerKwChargeMasterServiceImpl perKwChargeMasterService;

    @Autowired
    private RateMasterServiceImpl rateMasterService;

    @RequestMapping(value = "/{cid}/per-kw-charge-master", method = RequestMethod.GET)
    public ModelAndView showPersonsPage(@PathVariable("cid") long cid, @RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("perkwchargemaster/index");
        int evalPageSize = pageSize.orElse(property.INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? property.INITIAL_PAGE : page.get() - 1;

        Page<PerKwChargeMaster> perKwChargeMasterLists = perKwChargeMasterService.findAllByIdRateMaster(cid,
                new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(perKwChargeMasterLists.getTotalPages(), perKwChargeMasterLists.getNumber(), property.BUTTONS_TO_SHOW);

        modelAndView.addObject("perKwChargeMasterLists", perKwChargeMasterLists);
        modelAndView.addObject("rateMaster", rateMasterService.getById(cid));
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", property.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }
}
