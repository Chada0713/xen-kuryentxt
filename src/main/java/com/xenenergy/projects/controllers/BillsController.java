package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.BillChargeDetail;
import com.xenenergy.projects.entities.BillChargeGroup;
import com.xenenergy.projects.entities.ChargeGroupDetails;
import com.xenenergy.projects.services.interfaces.BillChargeDetailService;
import com.xenenergy.projects.services.interfaces.BillChargeGroupService;
import com.xenenergy.projects.services.interfaces.BillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
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
        model.addAttribute("billgroupLists", chargeGroupDetailsList);
        return "bills/viewbill";
    }
}
