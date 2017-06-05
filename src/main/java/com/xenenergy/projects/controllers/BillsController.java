package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.*;
import com.xenenergy.projects.services.impl.DuServiceImpl;
import com.xenenergy.projects.services.interfaces.*;
import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xesi on 17/05/2017.
 */
@Controller
@SessionAttributes("caller")
@RequestMapping("/bills")
public class BillsController {

    @Autowired
    private BillsService billsService;

    @Autowired
    private BillChargeGroupService billChargeGroupService;

    @Autowired
    private BillChargeDetailService billChargeDetailService;

    @Autowired
    private DuService duService;

    @Autowired
    private AccountService accountService;

    @RequestMapping(method = RequestMethod.GET)
    public String getBills(){
        return "bills/index";
    }

    @GetMapping("/viewbill")
    public String showbillForm(@RequestParam("billno") String billno, Model model){
        /*Bill Header*/
        model.addAttribute("bill", billsService.findByBillNo(billno));

        List<ChargeGroupDetails> chargeGroupDetailsList = new ArrayList<>();
        for(BillChargeGroup billChargeGroupList : billChargeGroupService.findByBillNo(billno)){
            ChargeGroupDetails chargeGroup = new ChargeGroupDetails();
            chargeGroup.setChargeGroupName(billChargeGroupList.getChargeGroupName());
            chargeGroupDetailsList.add(chargeGroup);
            for(BillChargeDetail billChargeDetailList : billChargeDetailService.findByPrintOrderMasterAndBillNo((int)billChargeGroupList.getPrintOrder(), billno)){
                ChargeGroupDetails chargeDetails = new ChargeGroupDetails();
                chargeDetails.setChargeName(billChargeDetailList.getChargeName());
                chargeDetails.setChargeAmount(billChargeDetailList.getChargeAmount());
                chargeDetails.setChargeTotal(billChargeDetailList.getChargeTotal());
                chargeGroupDetailsList.add(chargeDetails);
            }
        }

        List<Du> duModels = duService.getDU();
        Du duList = new Du();
        for (Du duModel : duModels) {
            duList.setDuCode(duModel.getDuCode());
            duList.setDuName(duModel.getDuName());
            duList.setAddressLn1(duModel.getAddressLn1());
            duList.setAddressLn2(duModel.getAddressLn2());
            duList.setContactPerson(duModel.getContactPerson());
        }

        /*LocalDateTime superBowlXLV = billsService.findByBillNo(billno).getDueDate().getYear();
        LocalDateTime celebration = superBowlXLV.plusDays(1);

        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss S");*/

        /*logger.info(superBowlXLV.format(formatter));
        logger.info(celebration.format(formatter));

        assertTrue(celebration.isAfter(superBowlXLV));*/

        model.addAttribute("billgroupLists", chargeGroupDetailsList);
        model.addAttribute("du", duList);
        model.addAttribute("account", accountService.getByOldAccountNo(billsService.findByBillNo(billno).getOldAcctNo()));
        return "bills/viewbill";
    }
}
