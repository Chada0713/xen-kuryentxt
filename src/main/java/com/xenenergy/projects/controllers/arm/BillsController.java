package com.xenenergy.projects.controllers.arm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by xesi on 17/05/2017.
 */
@Controller
@RequestMapping("/bills")
public class BillsController {

    @RequestMapping(method = RequestMethod.GET)
    public String getBills(){
        return "bills/index";
    }
}
