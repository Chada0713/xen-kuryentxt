package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.LogMsg;
import com.xenenergy.projects.entities.Pager;
import com.xenenergy.projects.entities.PaginationProperty;
import com.xenenergy.projects.services.interfaces.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**
 * Created by Daryll Sabate on 10/25/2017.
 */
@Controller
@SessionAttributes("caller")
@RequestMapping("/logs")
public class LogController {
    private PaginationProperty property = new PaginationProperty();

    @Autowired
    private LogService logService;

    @GetMapping
    public ModelAndView showLogs(@RequestParam("pageSize") Optional<Integer> pageSize,
                                 @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("logs/index");
        int evalPageSize = pageSize.orElse(property.INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? property.INITIAL_PAGE : page.get() - 1;
        Page<LogMsg> logMsgs = logService.findAllPageable(new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(logMsgs.getTotalPages(), logMsgs.getNumber(), property.BUTTONS_TO_SHOW);
        modelAndView.addObject("logsLists", logMsgs);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", property.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }

}
