package com.appddiction.Repos;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.Entity;

/**
 * Created by daniel on 8/2/17.
 */

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.appddiction.Modals"})
@EnableJpaRepositories(basePackages = {"com.appddiction.Repos"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
