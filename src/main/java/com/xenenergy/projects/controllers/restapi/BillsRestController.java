package com.xenenergy.projects.controllers.restapi;

import com.xenenergy.projects.entities.Bills;
import com.xenenergy.projects.services.impl.BillsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xesi on 17/05/2017.
 */
@RestController
@RequestMapping("api/bills")
public class BillsRestController {

    @Autowired
    private BillsServiceImpl billsService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Bills> getAllBills(){
        return billsService.getAllBills();
    }
}
