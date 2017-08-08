package com.xenenergy.projects.controllers.restapi;

import com.xenenergy.projects.entities.Bills;
import com.xenenergy.projects.services.interfaces.BillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by xesi on 17/05/2017.
 */
@CrossOrigin(maxAge = 3600)
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

    @CrossOrigin(origins = "http://116.93.120.117:85") //IP Address to change
    @RequestMapping(value = "/ercgetbills", method = RequestMethod.GET)
    public List<Bills> retrieveAllBills() {
        return billsService.getAllBills();
    }

    @CrossOrigin(origins = "http://116.93.120.117:85") //IP Address to change - http://localhost:85
    @RequestMapping(value = "/ercgetbills/{accountNo}", method = RequestMethod.GET)
    public List<Bills> retrieveAllBillsByAccountNumber(@PathVariable("accountNo") String accountNo) {
        return billsService.findByOldAcctNoErc(accountNo);
    }
}
