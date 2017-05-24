package com.xenenergy.projects.controllers.restapi;

import com.xenenergy.projects.entities.Route;
import com.xenenergy.projects.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by xesi on 24/05/2017.
 */
@RestController
@RequestMapping("/api/route")
public class RouteRestController {

    @Autowired
    private RouteService routeService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Route> getByIdArea(@RequestParam("idarea") long idarea){
        return routeService.findByIdArea(idarea);
    }
}
