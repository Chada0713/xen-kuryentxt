package com.xenenergy.projects.controllers.arm;

import com.xenenergy.projects.entities.arm.Account;
import com.xenenergy.projects.entities.arm.Pager;
import com.xenenergy.projects.entities.arm.PaginationProperty;
import com.xenenergy.projects.services.RdmService;
import com.xenenergy.projects.services.interfaces.arm.AccountService;
import com.xenenergy.projects.services.interfaces.arm.RdmDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**
 * Created by xesi on 31/05/2017.
 */
@Controller
@RequestMapping("/rdm")
public class ViewAccountsController {

    private PaginationProperty property = new PaginationProperty();

    @Autowired
    private AccountService accountService;

    @Autowired
    private RdmDetailService rdmDetailService;

    @Autowired
    private RdmService rdmService;

    @RequestMapping(value = "/{cid}/rdmdetails/{id}/route/{rid}", method = RequestMethod.GET)
    public ModelAndView showPersonsPage(@PathVariable("cid") long cid, @PathVariable("id") long id,
                                  @PathVariable("rid") long rid,@RequestParam("pageSize") Optional<Integer> pageSize,
                                  @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("viewaccounts/index");

        int evalPageSize = pageSize.orElse(property.INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? property.INITIAL_PAGE : page.get() - 1;

        Page<Account> accountList = accountService.findByIdRoute(rid,
                new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(accountList.getTotalPages(), accountList.getNumber(), property.BUTTONS_TO_SHOW);

        modelAndView.addObject("accountLists", accountList);
        modelAndView.addObject("rdmDeltail", rdmDetailService.getById(id));
        modelAndView.addObject("rdm", rdmDetailService.getById(id));
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", property.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }
}
