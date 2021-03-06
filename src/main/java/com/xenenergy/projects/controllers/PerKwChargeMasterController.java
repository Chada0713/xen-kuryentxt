package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.Pager;
import com.xenenergy.projects.entities.PaginationProperty;
import com.xenenergy.projects.entities.PerKwChargeMaster;
import com.xenenergy.projects.services.interfaces.PerKwChargeMasterService;
import com.xenenergy.projects.services.interfaces.RateMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
    import java.util.Date;
import java.util.Optional;

/**
 * Created by xenuser on 5/18/2017.
 */
@Controller
@SessionAttributes("caller")
@RequestMapping("/ratemaster")
public class PerKwChargeMasterController {

    private PaginationProperty property = new PaginationProperty();

    @Autowired
    private PerKwChargeMasterService perKwChargeMasterService;

    @Autowired
    private RateMasterService rateMasterService;

    @RequestMapping(value = "/{cid}/per-kw-charge-master", method = RequestMethod.GET)
    public ModelAndView showPersonsPage(@PathVariable("cid") long cid, @RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("perkwchargemaster/index");
        int evalPageSize = pageSize.orElse(property.INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? property.INITIAL_PAGE : page.get() - 1;

        Page<PerKwChargeMaster> perKwChargeMasterLists = perKwChargeMasterService.findAllByIdRateMaster(cid,
                new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(perKwChargeMasterLists.getTotalPages(), perKwChargeMasterLists.getNumber(), property.BUTTONS_TO_SHOW);

        modelAndView.addObject("perKwChargeMasterLists", perKwChargeMasterLists);
        modelAndView.addObject("rateMaster", rateMasterService.getById(cid));
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("perkwchargemaster2", new PerKwChargeMaster());
        modelAndView.addObject("pageSizes", property.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }

    @GetMapping("/{cid}/per-kw-charge-master/add")
    public String addForm(Model model, @PathVariable("cid") long cid) {
        model.addAttribute("ratemaster", rateMasterService.getById(cid));
        model.addAttribute("perkwchargemaster", new PerKwChargeMaster());
        return "perkwchargemaster/add";
    }

    @PostMapping("/{cid}/per-kw-charge-master/create")
    public String save(@PathVariable("  cid") long cid, PerKwChargeMaster perKwChargeMaster, final RedirectAttributes redirectAttributes) {
        if (perKwChargeMasterService.insert(perKwChargeMaster) != null) {
            redirectAttributes.addFlashAttribute("save", "success");
        } else {
            redirectAttributes.addFlashAttribute("save", "unsuccess");
        }
        return "redirect:/ratemaster/" + cid + "/per-kw-charge-master";
    }

    @PostMapping("/{cid}/per-kw-charge-master/duplicate/{id}")
    public String duplicate(@PathVariable("cid") int cid, @PathVariable("id") int id, @ModelAttribute("perkwchargemaster2") PerKwChargeMaster perKwChargeMaster, final RedirectAttributes redirectAttributes) {
        if (perKwChargeMasterService.duplicateRate(id, cid, perKwChargeMaster.getEffectivityDate()) == true){
        redirectAttributes.addFlashAttribute("duplicate", "success");
    }
        else
            redirectAttributes.addFlashAttribute("duplicate", "unsuccess");

        return "redirect:/ratemaster/" + cid + "/per-kw-charge-master";
    }

    @GetMapping("/{cid}/per-kw-charge-master/{operation}/{id}")
    public String editDeleteForm(@PathVariable("cid") long cid, @PathVariable("id") long id,
                                 @PathVariable("operation") String operation,
                                 Model model, final RedirectAttributes redirectAttributes) {
        if (operation.equals("delete")) {
            if (perKwChargeMasterService.deleteById(id)) {
                redirectAttributes.addFlashAttribute("delete", "success");
            } else {
                redirectAttributes.addFlashAttribute("delete", "unsuccess");
            }
        } else if (operation.equals("edit")) {
            if (perKwChargeMasterService.getById(id) != null) {
                model.addAttribute("ratemaster", rateMasterService.getById(cid));
                model.addAttribute("perkwchargemaster", perKwChargeMasterService.getById(id));
                return "perkwchargemaster/edit";
            } else {
                redirectAttributes.addFlashAttribute("status", "notfound");
            }
        }
        return "redirect:/ratemaster/" + cid + "/per-kw-charge-master";
    }

    @PostMapping("/{cid}/per-kw-charge-master/update")
    public String update(@PathVariable("cid") long cid, @ModelAttribute("duArea") PerKwChargeMaster perKwChargeMaster,
                         final RedirectAttributes redirectAttributes) {
        if (perKwChargeMasterService.update(perKwChargeMaster) != null) {
            redirectAttributes.addFlashAttribute("edit", "success");
        } else {
            redirectAttributes.addFlashAttribute("edit", "unsuccess");
        }

        return "redirect:/ratemaster/" + cid + "/per-kw-charge-master";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
