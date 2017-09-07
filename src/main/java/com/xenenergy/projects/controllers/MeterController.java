package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.*;
import com.xenenergy.projects.services.RdmService;
import com.xenenergy.projects.services.interfaces.DuAreaService;
import com.xenenergy.projects.services.interfaces.MeterService;
import com.xenenergy.projects.services.interfaces.RoutesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;
/**
 * Created by xesi on 27/07/2017.
 */
@Controller
@SessionAttributes("caller")
@RequestMapping("/newmeter")
public class MeterController {
    private PaginationProperty property = new PaginationProperty();

    @Autowired
    private MeterService meterService;

    @Autowired
    private RoutesService routesService;

    @Autowired
    private DuAreaService areaService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showPersonsPage(@RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("meter/index");
        /*int evalPageSize = pageSize.orElse(property.INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? property.INITIAL_PAGE : page.get() - 1;

        Page<Meter> meterList = meterService.findAllPageable(new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(meterList.getTotalPages(), meterList.getNumber(), property.BUTTONS_TO_SHOW);

        List<Route> routeList = routesService.findAllByOrderById();*/

        Collection<DuArea> areaList = areaService.getAll();

        /*modelAndView.addObject("meterLists", meterList);
        modelAndView.addObject("routeLists", routeList);*/
        modelAndView.addObject("areaLists", areaList);
        /*modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", property.PAGE_SIZES);
        modelAndView.addObject("pager", pager);*/
        return modelAndView;
    }

   /* @RequestMapping(value = "/{areaid}", method = RequestMethod.GET)
    public ModelAndView showPageByArea(@PathVariable("areaid") long areaid, @RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("meter/index");
        int evalPageSize = pageSize.orElse(property.INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? property.INITIAL_PAGE : page.get() - 1;

        Page<Meter> meterList = meterService.findAllByAreaId(new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(meterList.getTotalPages(), meterList.getNumber(), property.BUTTONS_TO_SHOW);

        List<Route> routeList = routesService.findAllByOrderById();

        Collection<DuArea> areaList = areaService.getAll();

        modelAndView.addObject("meterLists", meterList);
        modelAndView.addObject("routeLists", routeList);
        modelAndView.addObject("areaLists", areaList);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", property.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }*/

    @RequestMapping(value = "/downloadCSV", method = RequestMethod.GET)
    public void downloadcsv(@RequestParam(value = "areaIdRef") long areaid, HttpServletResponse response){
        String csvFilename = "New_Meter.csv";

        response.setContentType("text/csv");

        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", csvFilename);
        response.setHeader(headerKey, headerValue);

        //System.out.println("area id: " + areaid);

        List<Meter> meterList = new ArrayList<>();

        if(areaid != 0){
            meterList = meterService.findAllByAreaId(areaid);
        }else{
            meterList = meterService.findAllByOrderById();
        }

        try{
            ICsvBeanWriter csvBeanWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
            String[] header = { "id", "ts", "idRoute", "msn", "dateRead", "timeRead", "reading" };
            csvBeanWriter.writeHeader(header);

            for(Meter m : meterList){
                csvBeanWriter.write(m, header);
            }
            csvBeanWriter.close();
        }catch (Exception e){
            System.out.println("Error!");
            e.printStackTrace();
        }
    }
}
