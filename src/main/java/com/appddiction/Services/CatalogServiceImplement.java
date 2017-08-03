package com.appddiction.Services;

import com.appddiction.Modals.Catalog;
import com.appddiction.Repos.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by daniel on 8/3/17.
 */

@Service
public class CatalogServiceImplement implements CatalogService {

    private CatalogRepository catalogRepository;

    @Autowired
    public void setCatalogRepository(CatalogRepository catalogRepository){
        this.catalogRepository = catalogRepository;
    }

    @Override
    public Iterable<Catalog> listAllCatalogs() {
        return catalogRepository.findAll();
    }

    @Override
    public Catalog getCatalogById(Integer id) {
        return catalogRepository.findOne(id);
    }

    @Override
    public Catalog saveCatalog(Catalog catalog) {
        return catalogRepository.save(catalog);
    }

    @Override
    public void deleteCatalog(Integer id) {
        catalogRepository.delete(id);
    }
}
