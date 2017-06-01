package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.Locality;
import com.xenenergy.projects.entities.Pager;
import com.xenenergy.projects.entities.PaginationProperty;
import com.xenenergy.projects.services.interfaces.DuAreaService;
import com.xenenergy.projects.services.interfaces.LocalityService;
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
 * Created by xenuser on 5/15/2017.
 */
@Controller
@SessionAttributes("caller")
@RequestMapping("/du-area")
public class LocalityController {

    private PaginationProperty property = new PaginationProperty();

    @Autowired
    private LocalityService localityService;

    @Autowired
    private DuAreaService duAreaService;

    @RequestMapping(value = "/{cid}/locality", method = RequestMethod.GET)
    public ModelAndView showPersonsPage(@PathVariable("cid") long cid, @RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("locality/index");
        int evalPageSize = pageSize.orElse(property.INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? property.INITIAL_PAGE : page.get() - 1;

        Page<Locality> localityList = localityService.findAllByIdArea(cid,
                new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(localityList.getTotalPages(), localityList.getNumber(), property.BUTTONS_TO_SHOW);

        modelAndView.addObject("localityLists", localityList);
        modelAndView.addObject("duArea", duAreaService.getById(cid));
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", property.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }

    @GetMapping("/{cid}/locality/add")
    public String addForm(Model model, @PathVariable("cid") long cid) {
        model.addAttribute("area", duAreaService.getById(cid));
        model.addAttribute("locality", new Locality());
        return "locality/add";
    }

    @PostMapping("/{cid}/locality/create")
    public String save(@PathVariable("cid") long cid, Locality locality, final RedirectAttributes redirectAttributes) {
        if (localityService.insert(locality) != null) {
            redirectAttributes.addFlashAttribute("save", "success");
        } else {
            redirectAttributes.addFlashAttribute("save", "unsuccess");
        }
        return "redirect:/du-area/" + cid + "/locality";
    }

    @GetMapping("/{cid}/locality/{operation}/{id}")
    public String editDeleteForm(@PathVariable("cid") long cid, @PathVariable("id") long id,
                                 @PathVariable("operation") String operation,
                                 Model model, final RedirectAttributes redirectAttributes) {
        if (operation.equals("delete")) {
            if (localityService.deleteById(id)) {
                redirectAttributes.addFlashAttribute("delete", "success");
            } else {
                redirectAttributes.addFlashAttribute("delete", "unsuccess");
            }
        } else if (operation.equals("edit")) {
            if (localityService.getById(id) != null) {
                model.addAttribute("area", duAreaService.getById(cid));
                model.addAttribute("locality", localityService.getById(id));
                return "locality/edit";
            } else {
                redirectAttributes.addFlashAttribute("status", "notfound");
            }
        }

        return "redirect:/du-area/" + cid + "/locality";
    }

    @PostMapping("/{cid}/locality/update")
    public String update(@PathVariable("cid") long cid, @ModelAttribute("duArea") Locality locality,
                         final RedirectAttributes redirectAttributes) {
        if (localityService.update(locality) != null) {
            redirectAttributes.addFlashAttribute("edit", "success");
        } else {
            redirectAttributes.addFlashAttribute("edit", "unsuccess");
        }

        return "redirect:/du-area/" + cid + "/locality";
    }
}
