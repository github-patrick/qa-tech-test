package com.ecsdigital;

import com.ecsdigital.config.TestConfiguration;
import com.ecsdigital.pageobjects.HomePage;
import com.ecsdigital.service.Equalizer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.logging.Logger;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class TechTestIT {

    private static final Logger LOGGER = Logger.getLogger(Equalizer.class.getName());
    private static final String BASE_URL = "http://localhost";
    private static final int PORT = 3000;

    @Autowired
    private HomePage homePage;

    @Autowired
    private WebDriver driver;

    @Test
    public void arrayCheckerTest() {
        driver.get(BASE_URL + ":" + PORT);

        homePage.clickRenderButton();

        LOGGER.info("Selenium Test: First row index is: " + homePage.getAnswerForFirstRow());
        LOGGER.info("Selenium Test: Second row index is: " + homePage.getAnswerForSecondRow());
        LOGGER.info("Selenium Test: Third row index is: " + homePage.getAnswerForThirdRow());
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }
}