package com.xenenergy.projects.controllers.cum;

import com.xenenergy.projects.entities.arm.Pager;
import com.xenenergy.projects.entities.arm.PaginationProperty;
import com.xenenergy.projects.entities.cum.DistUtil;
import com.xenenergy.projects.services.impl.cum.DistUtilServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**
 * Created by Daryll Sabate on 5/29/2017.
 */
@Controller
@RequestMapping("/du")
public class DistUtilController {

    private PaginationProperty property;
    @Autowired
    private DistUtilServiceImpl distUtilService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showPersonsPage(@RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("du/index");
        int evalPageSize = pageSize.orElse(property.INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? property.INITIAL_PAGE : page.get() - 1;

        Page<DistUtil> dulist = distUtilService.findAllPageable(new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(dulist.getTotalPages(), dulist.getNumber(), property.BUTTONS_TO_SHOW);

        modelAndView.addObject("dulists", dulist);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", property.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }
}
