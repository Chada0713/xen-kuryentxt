package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.Account;
import com.xenenergy.projects.entities.Pager;
import com.xenenergy.projects.entities.PaginationProperty;
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
@RequestMapping("/rdm")
public class ViewAccountsController {

    private PaginationProperty property = new PaginationProperty();

    @Autowired
    private AccountService accountService;

    @Autowired
    private RdmDetailService rdmDetailService;

    @Autowired
    private RoutesService routesService;

    @RequestMapping(value = "/{cid}/rdmdetails/{id}/route/{rid}/startseq/{sseq}/endseq/{eseq}", method = RequestMethod.GET)
    public ModelAndView showPersonsPage(@PathVariable("cid") long cid, @PathVariable("id") long id,
                                  @PathVariable("rid") long rid,
                                  @PathVariable("sseq") int sseq, @PathVariable("eseq") int eseq,
                                  @RequestParam(value = "searchStr") Optional<String> searchStr,
                                  @RequestParam("pageSize") Optional<Integer> pageSize,
                                  @RequestParam("page") Optional<Integer> page) {
        String search = "";
        if(searchStr.isPresent()){
            search = searchStr.get().toString();
        }
        ModelAndView modelAndView = new ModelAndView("viewaccounts/index");
        int evalPageSize = pageSize.orElse(property.INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? property.INITIAL_PAGE : page.get() - 1;

        Page<Account> accountList = accountService.findByRouteCodeSeqNo(rid, sseq, eseq, search,
                new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(accountList.getTotalPages(), accountList.getNumber(), property.BUTTONS_TO_SHOW);

        modelAndView.addObject("accountLists", accountList);
        modelAndView.addObject("account", new Account());
        modelAndView.addObject("route", routesService.getById(rid));
        modelAndView.addObject("rdmDeltail", rdmDetailService.getById(id));
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", property.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }
}
