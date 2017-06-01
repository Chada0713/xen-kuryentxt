package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.PaginationProperty;
import com.xenenergy.projects.entities.PerKwChargeDetail;
import com.xenenergy.projects.services.interfaces.ChargeTypeService;
import com.xenenergy.projects.services.interfaces.PerKwChargeDetailsService;
import com.xenenergy.projects.services.interfaces.PerKwChargeMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by Daryll Sabate on 5/19/2017.
 */
@Controller
@RequestMapping("/ratemaster")
public class PerKwChargeDetailController {

    private PaginationProperty property = new PaginationProperty();

    @Autowired
    private PerKwChargeDetailsService perKwChargeDetailService;

    @Autowired
    private PerKwChargeMasterService perKwChargeMasterService;

    @Autowired
    private ChargeTypeService chargeTypeService;

    @RequestMapping(value = "/{cid}/per-kw-charge-master/{rid}/details", method = RequestMethod.GET)
    public String showDetails(@PathVariable("cid") long cid,
                              @PathVariable("rid") long rid,
                              Model model) {
        model.addAttribute("perKwChargeDetails", perKwChargeDetailService.findAllPageable(rid));
        model.addAttribute("perKwChargeMaster", perKwChargeMasterService.getById(rid));
        model.addAttribute("totalamount", perKwChargeDetailService.findSumOfTotalAmount(rid));
        return "perkwchargedetail/index";
    }

    @GetMapping("/{cid}/per-kw-charge-master/{rid}/details/add")
    public String addForm(Model model, @PathVariable("cid") long cid,
                          @PathVariable("rid") long rid) {
        model.addAttribute("perkwchargedetail", new PerKwChargeDetail());
        model.addAttribute("perkwchargemaster", perKwChargeMasterService.getById(rid));
        model.addAttribute("printordermax", perKwChargeDetailService.getMaxPrintOrder(rid));
        model.addAttribute("chargetypes", chargeTypeService.getChargeTypeById(cid));
        return "perkwchargedetail/add";
    }

    @PostMapping("/{cid}/per-kw-charge-master/{rid}/details/create")
    public String save(@PathVariable("cid") long cid,
                       @PathVariable("rid") long rid,
                       PerKwChargeDetail perKwChargeDetail,
                       final RedirectAttributes redirectAttributes) {
        if (perKwChargeDetailService.insert(perKwChargeDetail) != null) {
            redirectAttributes.addFlashAttribute("save", "success");
        } else {
            redirectAttributes.addFlashAttribute("save", "unsuccess");
        }
        return "redirect:/ratemaster/" + cid + "/per-kw-charge-master/" + rid + "/details";
    }

    @GetMapping("/{cid}/per-kw-charge-master/{rid}/details/{operation}/{id}")
    public String editDeleteForm(@PathVariable("cid") long cid,
                                 @PathVariable("rid") long rid,
                                 @PathVariable("id") long id,
                                 @PathVariable("operation") String operation,
                                 Model model, final RedirectAttributes redirectAttributes) {
        if (operation.equals("delete")) {
            if (perKwChargeDetailService.deleteById(id)) {
                redirectAttributes.addFlashAttribute("delete", "success");
            } else {
                redirectAttributes.addFlashAttribute("delete", "unsuccess");
            }
        } else if (operation.equals("edit")) {
            if (perKwChargeDetailService.getById(id) != null) {
                model.addAttribute("perkwchargedetail", perKwChargeDetailService.getById(id));
                model.addAttribute("perkwchargemaster", perKwChargeMasterService.getById(rid));
                model.addAttribute("printordermax", perKwChargeDetailService.getMaxPrintOrder(rid));
                model.addAttribute("chargetypes", chargeTypeService.getChargeTypeById(cid));
                return "perkwchargedetail/edit";
            } else {
                redirectAttributes.addFlashAttribute("status", "notfound");
            }
        }
        return "redirect:/ratemaster/" + cid + "/per-kw-charge-master/" + rid + "/details";
    }

    @PostMapping("/{cid}/per-kw-charge-master/{rid}/details/update")
    public String update(@PathVariable("cid") long cid,
                         @PathVariable("rid") long rid,
                         @ModelAttribute("duArea") PerKwChargeDetail perKwChargeDetail,
                         final RedirectAttributes redirectAttributes) {
        if (perKwChargeDetailService.update(perKwChargeDetail) != null) {
            redirectAttributes.addFlashAttribute("edit", "success");
        } else {
            redirectAttributes.addFlashAttribute("edit", "unsuccess");
        }

        return "redirect:/ratemaster/" + cid + "/per-kw-charge-master/" + rid + "/details";
    }

    @GetMapping("/{cid}/per-kw-charge-master/{rid}/details/copytemplate")
    public String copyTemplate(@PathVariable("cid") long cid,
                               @PathVariable("rid") long rid,
                               Model model, final RedirectAttributes redirectAttributes) {
        perKwChargeDetailService.callCopyToTemplate(rid);
        redirectAttributes.addFlashAttribute("copy", "success");
        return "redirect:/ratemaster/" + cid + "/per-kw-charge-master/" + rid + "/details";
    }
}
