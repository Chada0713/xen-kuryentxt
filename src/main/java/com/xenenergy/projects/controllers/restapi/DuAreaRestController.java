package com.xenenergy.projects.controllers.restapi;

import com.xenenergy.projects.entities.DuArea;
import com.xenenergy.projects.services.interfaces.DuAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by xesi on 27/06/2017.
 */
@RestController
@RequestMapping("/api")
public class DuAreaRestController {
    @Autowired
    private DuAreaService duAreaService;

    @RequestMapping(value = "/du-area", method = RequestMethod.GET)
    public Collection<DuArea> getDuAreas(){
        return duAreaService.getAll();
    }
}
