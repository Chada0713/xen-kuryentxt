package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.ChargeType;
import com.xenenergy.projects.entities.Pager;
import com.xenenergy.projects.entities.PaginationProperty;
import com.xenenergy.projects.services.interfaces.ChargeTypeService;
import com.xenenergy.projects.services.interfaces.RateMasterService;
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
 * Created by xenuser on 5/18/2017.
 */
@Controller
@SessionAttributes("caller")
@RequestMapping("/ratemaster")
public class ChargeTypeController {

    private PaginationProperty property = new PaginationProperty();

    @Autowired
    private ChargeTypeService chargeTypeService;

    @Autowired
    private RateMasterService rateMasterService;

    @RequestMapping(value = "/{cid}/charge-type", method = RequestMethod.GET)
    public ModelAndView showPersonsPage(@PathVariable("cid") long cid, @RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("chargetype/index");
        int evalPageSize = pageSize.orElse(property.INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? property.INITIAL_PAGE : page.get() - 1;

        Page<ChargeType> chargeTypeList = chargeTypeService.findAllPageable(cid,
                new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(chargeTypeList.getTotalPages(), chargeTypeList.getNumber(), property.BUTTONS_TO_SHOW);

        modelAndView.addObject("chargetypelists", chargeTypeList);
        modelAndView.addObject("rateMaster", rateMasterService.getById(cid));
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", property.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }

    @GetMapping("/{cid}/charge-type/add")
    public String addForm(Model model, @PathVariable("cid") long cid) {
        model.addAttribute("ratemaster", rateMasterService.getById(cid));
        model.addAttribute("chargetype", new ChargeType());
        return "chargetype/add";
    }
    
    @PostMapping("/{cid}/charge-type/create")
    public String save(@PathVariable("cid") long cid, ChargeType chargeType, final RedirectAttributes redirectAttributes) {
        if (chargeTypeService.insert(chargeType) != null) {
            redirectAttributes.addFlashAttribute("save", "success");
        } else {
            redirectAttributes.addFlashAttribute("save", "unsuccess");
        }
        return "redirect:/ratemaster/" + cid + "/charge-type";
    }

    @GetMapping("/{cid}/charge-type/{operation}/{id}")
    public String editDeleteForm(@PathVariable("cid") long cid, @PathVariable("id") long id,
                                 @PathVariable("operation") String operation,
                                 Model model, final RedirectAttributes redirectAttributes) {
        if (operation.equals("delete")) {
            if (chargeTypeService.deleteById(id)) {
                redirectAttributes.addFlashAttribute("delete", "success");
            } else {
                redirectAttributes.addFlashAttribute("delete", "unsuccess");
            }
        } else if (operation.equals("edit")) {
            if (chargeTypeService.getById(id) != null) {
                model.addAttribute("ratemaster", rateMasterService.getById(cid));
                model.addAttribute("chargetype", chargeTypeService.getById(id));
                return "chargetype/edit";
            } else {
                redirectAttributes.addFlashAttribute("status", "notfound");
            }
        }
        return "redirect:/ratemaster/" + cid + "/charge-type";
    }

    @PostMapping("/{cid}/charge-type/update")
    public String update(@PathVariable("cid") long cid, @ModelAttribute("chargetype") ChargeType chargeType,
                         final RedirectAttributes redirectAttributes) {
        if (chargeTypeService.update(chargeType) != null) {
            redirectAttributes.addFlashAttribute("edit", "success");
        } else {
            redirectAttributes.addFlashAttribute("edit", "unsuccess");
        }

        return "redirect:/ratemaster/" + cid + "/charge-type";
    }

}
