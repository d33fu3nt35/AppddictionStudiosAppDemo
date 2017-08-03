package com.appddiction.Controllers;

import com.appddiction.Modals.Catalog;
import com.appddiction.Services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by daniel on 8/3/17.
 */

@Controller
public class CatalogController {

    private CatalogService catalogService;

    @Autowired
    public void setCatalogService(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @RequestMapping("catalog/new")
    public String newCatalog(Model model){
        model.addAttribute("catalog", new Catalog());
        return "catalogform";
    }

    @RequestMapping(value = "catalog", method = RequestMethod.POST)
    public String saveCatalog(Catalog catalog){
        catalogService.saveCatalog(catalog);
        return "redirect:/catalog/" + catalog.getId();
    }

    @RequestMapping("catalog/{id}")
    public String showCatalog(@PathVariable Integer id, Model model){
        model.addAttribute("catalog", catalogService.getCatalogById(id));
        return "catalogshow";
    }

    @RequestMapping(value = "/catalogs", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("catalogs", catalogService.listAllCatalogs());
        return "catalogs";
    }

    @RequestMapping("catalog/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("catalog", catalogService.getCatalogById(id));
        return "catalogform";
    }

    @RequestMapping("product/delete/{id}")
    public String delete(@PathVariable Integer id){
        catalogService.deleteCatalog(id);
        return "redirect:/catalogs";
    }
}
