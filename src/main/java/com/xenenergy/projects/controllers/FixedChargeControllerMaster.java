package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.FixedChargeMaster;
import com.xenenergy.projects.entities.Pager;
import com.xenenergy.projects.entities.PaginationProperty;
import com.xenenergy.projects.services.impl.FixedChargeMasterServiceImpl;
import com.xenenergy.projects.services.impl.RateMasterServiceImpl;
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
 * Created by xesi on 18/05/2017.
 */
@Controller
@RequestMapping("/ratemaster")
public class FixedChargeControllerMaster {
    private static final int BUTTONS_TO_SHOW = 5;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 10;
    private static final int[] PAGE_SIZES = {10, 20, 50, 100};

    private PaginationProperty property = new PaginationProperty();
    @Autowired
    private FixedChargeMasterServiceImpl fixedChargeService;

    @Autowired
    private RateMasterServiceImpl rateMasterService;


    @RequestMapping(value = "/{cid}/fixedcharge", method = RequestMethod.GET)
    public ModelAndView showPersonsPage(@PathVariable("cid") long cid, @RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("fixedcharge/index");
        int evalPageSize = pageSize.orElse(property.INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? property.INITIAL_PAGE : page.get() - 1;

        Page<FixedChargeMaster> fixedCharges = fixedChargeService.findAllByIdRateMaster(cid,
                new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(fixedCharges.getTotalPages(), fixedCharges.getNumber(), property.BUTTONS_TO_SHOW);

        modelAndView.addObject("fixedchargeList", fixedCharges);
        modelAndView.addObject("rateMaster", rateMasterService.getById(cid));
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", property.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }

    @GetMapping("/{cid}/fixedcharge/add")
    public String addForm(Model model, @PathVariable("cid") long cid){
        model.addAttribute("rateMaster", rateMasterService.getById(cid));
        model.addAttribute("fixedCharge", new FixedChargeMaster());
        return "fixedcharge/add";
    }

    @PostMapping("/{cid}/fixedcharge/create")
    public String save(@PathVariable("cid") long cid, FixedChargeMaster fixedChargeMaster, final RedirectAttributes redirectAttributes){
        if(fixedChargeService.insert(fixedChargeMaster)!= null){
            redirectAttributes.addFlashAttribute("save", "success");
        }else{
            redirectAttributes.addFlashAttribute("save", "unsuccess");
        }
        return "redirect:/ratemaster/"+cid+"/fixedcharge";
    }

    @GetMapping("/{cid}/fixedcharge/{operation}/{id}")
    public String editDeleteForm(@PathVariable("cid") long cid, @PathVariable("operation") String operation,
                                 @PathVariable("id") int id, Model model, RedirectAttributes redirectAttributes){
        if(operation.equals("delete")){
            if(fixedChargeService.deleteById(id)){
                redirectAttributes.addFlashAttribute("delete", "success");
            }else{
                redirectAttributes.addFlashAttribute("delete", "unsuccess");
            }
        }else if(operation.equals("edit")){
            if(fixedChargeService.getById(id)!=null){
                model.addAttribute("rateMaster", rateMasterService.getById(cid));
                model.addAttribute("fixedcharge", fixedChargeService.getById(id));
                return "fixedcharge/edit";
            }else{
                redirectAttributes.addFlashAttribute("status", "notfound");
            }
        }
        return "redirect:/ratemaster/"+cid+"/fixedcharge";
    }

    @PostMapping("/{cid}/fixedcharge/update")
    public String update(@PathVariable("cid") long cid, @ModelAttribute("fixedcharge") FixedChargeMaster fixedChargeMaster,
                         final RedirectAttributes redirectAttributes){
        if(fixedChargeService.update(fixedChargeMaster)!=null){
            redirectAttributes.addFlashAttribute("edit", "success");
        }else{
            redirectAttributes.addFlashAttribute("edit", "unsuccess");
        }
        return "redirect:/ratemaster/"+cid+"/fixedcharge";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
