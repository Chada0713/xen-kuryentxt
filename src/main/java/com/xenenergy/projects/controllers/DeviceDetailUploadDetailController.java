package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.DeviceUploadDetail;
import com.xenenergy.projects.entities.Pager;
import com.xenenergy.projects.entities.PaginationProperty;
import com.xenenergy.projects.services.interfaces.DeviceUploadDetailService;
import com.xenenergy.projects.services.interfaces.DeviceUploadMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**
 * Created by xesi on 02/06/2017.
 */
@Controller
@SessionAttributes("caller")
@RequestMapping("/devicemaster")
public class DeviceDetailUploadDetailController {
    private PaginationProperty property = new PaginationProperty();

    @Autowired
    private DeviceUploadDetailService deviceUploadDetailService;

    @Autowired
    private DeviceUploadMasterService deviceUploadMasterService;

    @RequestMapping(value = "/{cid}/details", method = RequestMethod.GET)
    public ModelAndView showPersonsPage(@PathVariable("cid") long cid, @RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("devicedetail/index");
        int evalPageSize = pageSize.orElse(property.INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? property.INITIAL_PAGE : page.get() - 1;

        Page<DeviceUploadDetail> dud = deviceUploadDetailService.findAllByIdMasterOrderByIdDesc(cid, new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(dud.getTotalPages(), dud.getNumber(), property.BUTTONS_TO_SHOW);

        modelAndView.addObject("dudLists", dud);
        modelAndView.addObject("dum", deviceUploadMasterService.getById(cid));
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", property.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }
}
