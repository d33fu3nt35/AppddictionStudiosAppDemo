package com.appddiction.Services;

import com.appddiction.Modals.Catalog;

/**
 * Created by daniel on 8/3/17.
 */
public interface CatalogService {
    Iterable<Catalog> listAllCatalogs();

    Catalog getCatalogById(Integer id);

    Catalog saveCatalog(Catalog catalog);

    void deleteCatalog(Integer id);
}
