package com.xenenergy.projects.controllers.restapi;

import com.xenenergy.projects.entities.Meter;
import com.xenenergy.projects.services.interfaces.MeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xesi on 06/09/2017.
 */
@RestController
@RequestMapping("api")
public class MeterRestController {

    @Autowired
    private MeterService meterService;

    @RequestMapping(value = "/newmeter", method = RequestMethod.GET)
    public List<Meter> getAllNewMeter(){
        return meterService.findAllByOrderById();
    }

    @RequestMapping(value = "/newmeter/{idarea}", method = RequestMethod.GET)
    public List<Meter> getAllNewMeter(@PathVariable("idarea") long idarea){
        return meterService.findAllByAreaId(idarea);
    }
}
