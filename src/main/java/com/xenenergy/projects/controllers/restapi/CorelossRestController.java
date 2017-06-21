package com.xenenergy.projects.controllers.restapi;

import com.xenenergy.projects.entities.Coreloss;
import com.xenenergy.projects.services.impl.CorelossServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xesi on 21/06/2017.
 */
@RestController
@RequestMapping("api")
public class CorelossRestController {

    @Autowired
    private CorelossServiceImpl corelossService;

    @RequestMapping(value = "/coreloss", method = RequestMethod.GET)
    public List<Coreloss> getAllAccounts() {
        return corelossService.getAllRecords();
    }
}
