package com.ecsdigital.config;

import com.ecsdigital.pageobjects.HomePage;
import com.ecsdigital.service.Equalizable;
import com.ecsdigital.service.Equalizer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {

    @Bean
    public Equalizable equalizable() {
        return new Equalizer();
    }

    @Bean
    public HomePage homePage() {
        WebDriver webdriver = webdriver();
        Equalizable equalizable = equalizable();
        return new HomePage(webdriver, equalizable);
    }

    @Bean
    public WebDriver webdriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        return new ChromeDriver();
    }
}
