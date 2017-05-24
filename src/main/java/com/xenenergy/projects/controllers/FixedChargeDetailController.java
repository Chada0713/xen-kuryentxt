package com.xenenergy.projects.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.xenenergy.projects.dao.FixedChargeDetailDao;
import com.xenenergy.projects.entities.FixedChargeDetail;
import com.xenenergy.projects.entities.Pager;
import com.xenenergy.projects.entities.PaginationProperty;
import com.xenenergy.projects.entities.RateMaster;
import com.xenenergy.projects.services.impl.FixedChargeDetailServiceImpl;
import com.xenenergy.projects.services.impl.FixedChargeMasterServiceImpl;
import com.xenenergy.projects.services.impl.RateMasterServiceImpl;
import org.omg.CORBA.FieldNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

/**
 * Created by xesi on 19/05/2017.
 */
@Controller
@RequestMapping("/ratemaster")
public class FixedChargeDetailController {
    private PaginationProperty property = new PaginationProperty();

    @Autowired
    private FixedChargeDetailServiceImpl fixedChargeDetailService;

    @Autowired
    private FixedChargeMasterServiceImpl fixedChargeMasterService;

    @RequestMapping(value = "/{cid}/fixedcharge/{rid}/fixedchargedetail", method = RequestMethod.GET)
    public String showPersonsPage(@PathVariable("cid") long cid, @PathVariable("rid") long rid, Model model) {
        model.addAttribute("fixedChargeDetailLists", fixedChargeDetailService.findAllByIdFixedChargeDetail(rid));
        model.addAttribute("fixedChargeMaster", fixedChargeMasterService.getById(rid));
        model.addAttribute("sumOfAmount", fixedChargeDetailService.findSumOfAmount(rid));
        return "fixedchargedetail/index";
    }

    @GetMapping("/{cid}/fixedcharge/{rid}/fixedchargedetail/add")
    public String addForm(Model model, @PathVariable("cid") long cid, @PathVariable("rid") long rid) {
        model.addAttribute("fixedCharge", fixedChargeMasterService.getById(rid));
        model.addAttribute("fixedChargeDetail", new FixedChargeDetail());
        model.addAttribute("maxPrintOrder", fixedChargeDetailService.findTopByPrintOrderOrderByPrintOrderDesc(rid));
        return "fixedchargedetail/add";
    }

    @PostMapping("/{cid}/fixedcharge/{rid}/fixedchargedetail/create")
    public String save(@PathVariable("cid") long cid, @PathVariable("rid") long rid,
                       FixedChargeDetail fixedChargeDetail, final RedirectAttributes redirectAttributes) {
        if (fixedChargeDetailService.insert(fixedChargeDetail) != null) {
            redirectAttributes.addFlashAttribute("save", "success");
        } else {
            redirectAttributes.addFlashAttribute("save", "unsuccess");
        }
        return "redirect:/ratemaster/" + cid + "/fixedcharge/" + rid + "/fixedchargedetail";
    }

    @GetMapping("/{cid}/fixedcharge/{rid}/fixedchargedetail/{operation}/{id}")
    public String editDeleteForm(@PathVariable("cid") long cid,
                                 @PathVariable("rid") long rid,
                                 @PathVariable("id") long id,
                                 @PathVariable("operation") String operation,
                                 Model model, final RedirectAttributes redirectAttributes) {
        if (operation.equals("delete")) {
            if (fixedChargeDetailService.deleteById(id)) {
                redirectAttributes.addFlashAttribute("delete", "success");
            } else {
                redirectAttributes.addFlashAttribute("delete", "unsuccess");
            }
        } else if (operation.equals("edit")) {
            if (fixedChargeDetailService.getById(id) != null) {
                model.addAttribute("fixedCharge", fixedChargeMasterService.getById(rid));
                model.addAttribute("fixedChargeDetail", fixedChargeDetailService.getById(id));
                return "fixedchargedetail/edit";
            } else {
                redirectAttributes.addFlashAttribute("status", "notfound");
            }
        }
        return "redirect:/ratemaster/" + cid + "/fixedcharge/" + rid + "/fixedchargedetail";
    }

    @PostMapping("/{cid}/fixedcharge/{rid}/fixedchargedetail/update")
    public String update(@PathVariable("cid") long cid, @PathVariable("rid") long rid,
                         FixedChargeDetail fixedChargeDetail, final RedirectAttributes redirectAttributes) {
        if (fixedChargeDetailService.update(fixedChargeDetail) != null) {
            redirectAttributes.addFlashAttribute("edit", "success");
        } else {
            redirectAttributes.addFlashAttribute("edit", "unsuccess");
        }
        return "redirect:/ratemaster/" + cid + "/fixedcharge/" + rid + "/fixedchargedetail";
    }

    @GetMapping("/{cid}/fixedcharge/{rid}/fixedchargedetail/copytemplate")
    public String copyTemplate(@PathVariable("cid") long cid,
                               @PathVariable("rid") long rid,
                               Model model, final RedirectAttributes redirectAttributes) {
        fixedChargeDetailService.callCopyToTemplate(rid);
        redirectAttributes.addFlashAttribute("copy", "success");

        return "redirect:/ratemaster/" + cid + "/fixedcharge/" + rid + "/fixedchargedetail";
    }
}