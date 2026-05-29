package com.teketik.spring.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.health.registry.HealthContributorRegistry;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
abstract class BaseITest {

    @Autowired
    protected HealthContributorRegistry healthContributorRegistry;

    @Autowired
    protected MockMvc mockMvc;

}
