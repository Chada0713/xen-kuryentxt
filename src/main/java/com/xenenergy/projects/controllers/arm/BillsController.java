package com.xenenergy.projects.controllers.arm;

import com.xenenergy.projects.entities.arm.Bills;
import com.xenenergy.projects.services.impl.arm.BillsServiceImpl;
import com.xenenergy.projects.services.interfaces.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by xesi on 17/05/2017.
 */
@Controller
@RequestMapping("/bills")
public class BillsController {
    @Autowired
    private CRUDService<Bills> billsService;

    @RequestMapping(method = RequestMethod.GET)
    public String getBills(){
        return "bills/index";
    }
}
