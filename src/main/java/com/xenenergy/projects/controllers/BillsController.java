package com.xenenergy.projects.controllers;

import com.xenenergy.projects.services.impl.BillsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.Column;
import javax.xml.ws.soap.Addressing;

/**
 * Created by xesi on 17/05/2017.
 */
@Controller
@RequestMapping("/bills")
public class BillsController {
    @Autowired
    private BillsServiceImpl billsService;

    @RequestMapping(method = RequestMethod.GET)
    public String getBills(){
        return "bills/index";
    }
}
