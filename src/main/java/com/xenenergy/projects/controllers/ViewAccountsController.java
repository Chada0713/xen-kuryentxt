package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.*;
import com.xenenergy.projects.services.RdmService;
import com.xenenergy.projects.services.interfaces.AccountService;
import com.xenenergy.projects.services.interfaces.RdmDetailService;
import com.xenenergy.projects.services.interfaces.RoutesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**
 * Created by xesi on 31/05/2017.
 */
@Controller
@SessionAttributes("caller")
@RequestMapping
public class ViewAccountsController {

    private PaginationProperty property = new PaginationProperty();

    @Autowired
    private AccountService accountService;

    @Autowired
    private RdmDetailService rdmDetailService;

    @Autowired
    private RoutesService routesService;

    @RequestMapping(value = "/rdm/{cid}/rdmdetails/{id}/route/{rid}/startseq/{sseq}/endseq/{eseq}", method = RequestMethod.GET)
    public ModelAndView showPersonsPage(@PathVariable("cid") long cid, @PathVariable("id") long id,
                                        @PathVariable("rid") long rid,
                                        @PathVariable("sseq") int sseq, @PathVariable("eseq") int eseq,
                                        @RequestParam(value = "searchStr") Optional<String> searchStr,
                                        @RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page) {
        String search = "";
        if (searchStr.isPresent()) {
            search = searchStr.get().toString();
        }
        ModelAndView modelAndView = new ModelAndView("viewaccounts/index");
        int evalPageSize = pageSize.orElse(property.INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? property.INITIAL_PAGE : page.get() - 1;

        Page<Account> accountList = accountService.findByRouteCodeSeqNo(rid, sseq, eseq, search,
                new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(accountList.getTotalPages(), accountList.getNumber(), property.BUTTONS_TO_SHOW);

        Route route = routesService.getById(rid);
        RdmDetail rdmDetail = rdmDetailService.getById(id);
        int totalCount = accountService.countByIdRoute(rid);
        modelAndView.addObject("cid", cid);
        modelAndView.addObject("id", id);
        modelAndView.addObject("rid", rid);
        modelAndView.addObject("accountsTotal", totalCount);
        modelAndView.addObject("accountLists", accountList);
        modelAndView.addObject("account", new Account());
        modelAndView.addObject("route", route);
        modelAndView.addObject("rdmDeltail", rdmDetail);
        modelAndView.addObject("prevPageUrl", "/Kuryentxt/rdm/" + Long.toString(cid) + "/rdmdetails");
        modelAndView.addObject("headerDetail", "RDM: " + cid + " | " + route.getRouteName() + " (Total : " + totalCount + ")");
        modelAndView.addObject("forSearchUrl", "/Kuryentxt/rdm/" + Long.toString(cid) + "/rdmdetails/" + Long.toString(rdmDetail.getId()) + "/route/" + Long.toString(rdmDetail.getIdRoute()) + "/startseq/" +
                Integer.toString(rdmDetail.getStartSequence()) + "/endseq/" + Integer.toString(rdmDetail.getEndSequence()));
        modelAndView.addObject("whatView", "rdm");
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", property.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }

    @RequestMapping(value = "/du-area/{cid}/routes/{id}/startseq/{sseq}/endseq/{eseq}", method = RequestMethod.GET)
    public ModelAndView showPerRoute(@PathVariable("cid") long cid, @PathVariable("id") long id,
                                     @PathVariable("sseq") int sseq, @PathVariable("eseq") int eseq,
                                     @RequestParam(value = "searchStr") Optional<String> searchStr,
                                     @RequestParam("pageSize") Optional<Integer> pageSize,
                                     @RequestParam("page") Optional<Integer> page) {
        String search = "";
        if (searchStr.isPresent()) {
            search = searchStr.get().toString();
        }
        ModelAndView modelAndView = new ModelAndView("viewaccounts/index");
        int evalPageSize = pageSize.orElse(property.INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? property.INITIAL_PAGE : page.get() - 1;

        Page<Account> accountList = accountService.findByRouteCodeSeqNo(id, sseq, eseq, search,
                new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(accountList.getTotalPages(), accountList.getNumber(), property.BUTTONS_TO_SHOW);

        Route route = routesService.getById(id);

        modelAndView.addObject("cid", cid);
        modelAndView.addObject("rid", id);
        modelAndView.addObject("accountLists", accountList);
        modelAndView.addObject("account", new Account());
        modelAndView.addObject("route", route);
        modelAndView.addObject("prevPageUrl", "/Kuryentxt/du-area/" + cid + "/routes");
        modelAndView.addObject("headerDetail", "RDM: " + cid + " ROUTE: " + route.getRouteCode() +
                " START SEQ: " + route.getStartSequence() + " END SEQ: " + route.getEndSequence() + " (" + route.getRouteName() + ")");
        modelAndView.addObject("forSearchUrl", "/Kuryentxt/du-area/" + cid + "/routes/" + route.getId() + "/startseq/" +
                route.getStartSequence() + "/endseq/" + route.getEndSequence());
        modelAndView.addObject("whatView", "area");
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", property.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }
}
