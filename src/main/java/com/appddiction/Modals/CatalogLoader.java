package com.appddiction.Modals;

import com.appddiction.Repos.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.logging.Logger;

/**
 * Created by daniel on 8/2/17.
 */

@Component
public class CatalogLoader implements ApplicationListener<ContextRefreshedEvent> {

    private CatalogRepository catalogRepository;

    private Logger log = Logger.getLogger(String.valueOf(CatalogLoader.class));

    @Autowired
    public void setCatalogRepository(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        Catalog math = new Catalog();
        math.setTitle("Basic Math");
        math.setDescription("This is just a basic math class.");
        math.setPrice(new BigDecimal("100.00"));
        math.setCatalogId("M12345678910");
        catalogRepository.save(math);

        log.info("Saved Math - id: " + math.getId());

        Catalog science = new Catalog();
        science.setTitle("Basic Science");
        science.setDescription("This is just a basic science class.");
        science.setPrice(new BigDecimal("150.00"));
        science.setCatalogId("S12345678910");
        catalogRepository.save(science);

        log.info("Saved science - id: " + science.getId());

    }
}
