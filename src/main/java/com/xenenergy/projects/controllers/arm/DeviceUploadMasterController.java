package com.xenenergy.projects.controllers.arm;

import com.xenenergy.projects.entities.arm.DeviceUploadMaster;
import com.xenenergy.projects.entities.arm.Pager;
import com.xenenergy.projects.entities.arm.PaginationProperty;
import com.xenenergy.projects.services.interfaces.CRUDService;
import com.xenenergy.projects.services.interfaces.arm.DeviceUploadMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**
 * Created by xesi on 31/05/2017.
 */
@Controller
@RequestMapping("/devicemaster")
public class DeviceUploadMasterController {
    private PaginationProperty property = new PaginationProperty();

    @Autowired
    private DeviceUploadMasterService deviceUploadMasterService;

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
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", property.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }
}
