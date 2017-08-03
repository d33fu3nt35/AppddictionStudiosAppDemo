package com.appddiction.Controllers;

import com.appddiction.Modals.Catalog;
import com.appddiction.Services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
}
