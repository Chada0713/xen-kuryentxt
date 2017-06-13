package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.DeviceUploadMaster;
import com.xenenergy.projects.entities.Pager;
import com.xenenergy.projects.entities.PaginationProperty;
import com.xenenergy.projects.services.interfaces.DeviceUploadMasterService;
import com.xenenergy.projects.services.interfaces.MeterReaderService;
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
 * Created by xesi on 31/05/2017.
 */
@Controller
@SessionAttributes("caller")
@RequestMapping("/devicemaster")
public class DeviceUploadMasterController {
    private PaginationProperty property = new PaginationProperty();

    @Autowired
    private DeviceUploadMasterService deviceUploadMasterService;

    @Autowired
    private MeterReaderService meterReaderService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showPersonsPage(@RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("devicemaster/index");
        int evalPageSize = pageSize.orElse(property.INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? property.INITIAL_PAGE : page.get() - 1;

        Page<DeviceUploadMaster> dum = deviceUploadMasterService.findAllByOrderByIdDesc(new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(dum.getTotalPages(), dum.getNumber(), property.BUTTONS_TO_SHOW);
        /*Page<Rdm> rdmsearch = definitionService.findByRdmNameAndIdContaining()*/

        modelAndView.addObject("dumLists", dum);
        modelAndView.addObject("meterReader", meterReaderService.findAll());
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", property.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }
}
