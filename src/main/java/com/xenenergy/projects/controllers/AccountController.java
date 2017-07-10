package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.Bills;
import com.xenenergy.projects.entities.RdmDetail;
import com.xenenergy.projects.entities.Route;
import com.xenenergy.projects.services.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by xenuser on 5/9/2017.
 */
@Controller
@SessionAttributes("caller")
@RequestMapping("")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private BillsService billsService;

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private RdmDetailService rdmDetailService;

    @Autowired
    private RoutesService routesService;

    @Autowired
    private DuAreaService duAreaService;

    @Autowired
    private RateMasterService rateMasterService;

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public String getAccounts(){
        return "accounts/index";
    }

    @RequestMapping(value = "/accounts/account/{accountno}", method = RequestMethod.GET)
    public String showAccount(Model model, @PathVariable("accountno") String accountno){
        //System.out.println("Old Account No >>> " + accountService.getByAccountNo(accountno).getOldAccountNo());
        List<Bills> billsList = billsService.findByOldAcctNo(accountService.getByAccountNo(accountno).getOldAccountNo());

        String[] du = new String[7];
        if(propertyService.findByPropertyName("DU_CODE") != null){
            du[0] = propertyService.findByPropertyName("DU_CODE").getPropertyValue();
        }
        if(propertyService.findByPropertyName("DU_NAME") != null){
            du[1] = propertyService.findByPropertyName("DU_NAME").getPropertyValue();
        }
        if(propertyService.findByPropertyName("DU_ADDRESSLN1") != null){
            du[2] = propertyService.findByPropertyName("DU_ADDRESSLN1").getPropertyValue();
        }else{
            du[2] = "";
        }
        if(propertyService.findByPropertyName("DU_ADDRESSLN2") != null){
            du[3] = propertyService.findByPropertyName("DU_ADDRESSLN2").getPropertyValue();
        }else{
            du[3] = "";
        }
        if(propertyService.findByPropertyName("DU_CONTACT_NO") != null){
            du[4] = propertyService.findByPropertyName("DU_CONTACT_NO").getPropertyValue();
        }

        model.addAttribute("account", accountService.getByAccountNo(accountno));
        model.addAttribute("bills", billsList);
        model.addAttribute("du", du);
        model.addAttribute("area", duAreaService.getAll());
        model.addAttribute("rateMasterService", rateMasterService.findAllByOrderById());
        return "accounts/account";
    }

    @RequestMapping(value = "/accounts/oldaccountno/{oldAccountno}/{cid}/{id}/{rid}", method = RequestMethod.GET)
    public String showAccountByOldAcctNo(Model model, @PathVariable("oldAccountno") String oldaccountno,
                                         @PathVariable("cid") long cid, @PathVariable("id") long id,
                                         @PathVariable("rid") long rid){
        //System.out.println("Old Account No >>> " + accountService.getByAccountNo(accountno).getOldAccountNo());
        List<Bills> billsList = billsService.findByOldAcctNo(oldaccountno);

        //System.out.println("cid >> " + cid + ", id >> " + id + ", rid >> " + rid);
        String[] du = new String[7];
        if(propertyService.findByPropertyName("DU_CODE") != null){
            du[0] = propertyService.findByPropertyName("DU_CODE").getPropertyValue();
        }
        if(propertyService.findByPropertyName("DU_NAME") != null){
            du[1] = propertyService.findByPropertyName("DU_NAME").getPropertyValue();
        }
        if(propertyService.findByPropertyName("DU_ADDRESSLN1") != null){
            du[2] = propertyService.findByPropertyName("DU_ADDRESSLN1").getPropertyValue();
        }else{
            du[2] = "";
        }
        if(propertyService.findByPropertyName("DU_ADDRESSLN2") != null){
            du[3] = propertyService.findByPropertyName("DU_ADDRESSLN2").getPropertyValue();
        }else{
            du[3] = "";
        }
        if(propertyService.findByPropertyName("DU_CONTACT_NO") != null){
            du[4] = propertyService.findByPropertyName("DU_CONTACT_NO").getPropertyValue();
        }

        RdmDetail rdmDetail = rdmDetailService.getById(id);

        model.addAttribute("account", accountService.getByOldAccountNo(oldaccountno));
        model.addAttribute("bills", billsList);
        model.addAttribute("du", du);
        model.addAttribute("area", duAreaService.getAll());
        model.addAttribute("rateMasterService", rateMasterService.findAllByOrderById());
        model.addAttribute("prevPageUrl", "/Kuryentxt/rdm/" + Long.toString(cid) + "/rdmdetails/" + Long.toString(id) +
                "/route/" + Long.toString(rid) + "/startseq/" + Integer.toString(rdmDetail.getStartSequence()) + "/endseq/" + Integer.toString(rdmDetail.getEndSequence()));
        return "accounts/account";
    }

    @RequestMapping(value = "/accounts/oldaccountno/{oldAccountno}/{cid}/{rid}", method = RequestMethod.GET)
    public String showAccountByOldAcctNoArea(Model model, @PathVariable("oldAccountno") String oldaccountno,
                                         @PathVariable("cid") long cid, @PathVariable("rid") long rid){
        //System.out.println("Old Account No >>> " + accountService.getByAccountNo(accountno).getOldAccountNo());
        List<Bills> billsList = billsService.findByOldAcctNo(oldaccountno);

        //System.out.println("cid >> " + cid + ", id >> " + id + ", rid >> " + rid);
        String[] du = new String[7];
        if(propertyService.findByPropertyName("DU_CODE") != null){
            du[0] = propertyService.findByPropertyName("DU_CODE").getPropertyValue();
        }
        if(propertyService.findByPropertyName("DU_NAME") != null){
            du[1] = propertyService.findByPropertyName("DU_NAME").getPropertyValue();
        }
        if(propertyService.findByPropertyName("DU_ADDRESSLN1") != null){
            du[2] = propertyService.findByPropertyName("DU_ADDRESSLN1").getPropertyValue();
        }else{
            du[2] = "";
        }
        if(propertyService.findByPropertyName("DU_ADDRESSLN2") != null){
            du[3] = propertyService.findByPropertyName("DU_ADDRESSLN2").getPropertyValue();
        }else{
            du[3] = "";
        }
        if(propertyService.findByPropertyName("DU_CONTACT_NO") != null){
            du[4] = propertyService.findByPropertyName("DU_CONTACT_NO").getPropertyValue();
        }

        Route route = routesService.getById(rid);

        model.addAttribute("account", accountService.getByOldAccountNo(oldaccountno));
        model.addAttribute("bills", billsList);
        model.addAttribute("du", du);
        model.addAttribute("area", duAreaService.getAll());
        model.addAttribute("rateMasterService", rateMasterService.findAllByOrderById());
        model.addAttribute("prevPageUrl", "/Kuryentxt/du-area/"+cid+"/routes/" + route.getId() + "/startseq/" +
                route.getStartSequence() + "/endseq/" + route.getEndSequence());
        return "accounts/account";
    }
}
