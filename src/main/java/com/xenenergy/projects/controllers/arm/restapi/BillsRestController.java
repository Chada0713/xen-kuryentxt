package com.xenenergy.projects.controllers.arm.restapi;

import com.xenenergy.projects.entities.arm.Bills;
import com.xenenergy.projects.services.interfaces.arm.BillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xesi on 17/05/2017.
 */
@RestController
@RequestMapping("/api/bills")
public class BillsRestController {

    @Autowired
    private BillsService billsService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Bills> getAllBills() {
        return billsService.getAllBills();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Bills getById(@PathVariable("id") long id) {
        return billsService.getById(id);
    }
}
