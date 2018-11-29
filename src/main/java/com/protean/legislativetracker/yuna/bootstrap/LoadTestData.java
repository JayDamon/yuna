package com.protean.legislativetracker.yuna.bootstrap;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class LoadTestData {

    private DataSource dataSource;

    public LoadTestData(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void loadSessionData() {
        
        Resource resource = new ClassPathResource("initialdata.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.execute(dataSource);
    }

}
