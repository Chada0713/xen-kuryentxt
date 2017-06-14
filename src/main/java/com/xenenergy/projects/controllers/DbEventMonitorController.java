package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.DbEventMonitor;
import com.xenenergy.projects.entities.Pager;
import com.xenenergy.projects.entities.PaginationProperty;
import com.xenenergy.projects.services.interfaces.CRUDService;
import com.xenenergy.projects.services.interfaces.DbEventMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**
 * Created by xesi on 13/06/2017.
 */
@Controller
@SessionAttributes("caller")
@RequestMapping("dbeventmonitor")
public class DbEventMonitorController {
    private PaginationProperty property = new PaginationProperty();

    @Autowired
    private DbEventMonitorService dbEventMonitorService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showPersonsPage(@RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("dbeventmonitor/index");
        int evalPageSize = pageSize.orElse(property.INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? property.INITIAL_PAGE : page.get() - 1;

        Page<DbEventMonitor> dbEventMonitorList = dbEventMonitorService.findAllPageable(new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(dbEventMonitorList.getTotalPages(), dbEventMonitorList.getNumber(), property.BUTTONS_TO_SHOW);

        modelAndView.addObject("dbeventmonitorlists", dbEventMonitorList);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", property.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }
}
