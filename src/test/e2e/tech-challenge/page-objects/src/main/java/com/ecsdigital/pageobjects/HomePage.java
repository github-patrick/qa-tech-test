package com.ecsdigital.pageobjects;

import com.ecsdigital.service.Equalizable;
import com.ecsdigital.service.Equalizer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {

    private WebDriver driver;

    private Equalizable equalizer;

    @FindBy(tagName = "button")
    private WebElement button;

    @FindBys(@FindBy(css="tbody tr"))
    private List<WebElement> elements;

    WebDriverWait wait;


    public HomePage(WebDriver driver, Equalizable equalizable) {
        this.equalizer = equalizable;
        this.driver = driver;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver, this);
    }

    public void clickRenderButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("button")));
        button.click();
    }

    public Integer getAnswerForFirstRow() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tbody tr")));
        String[] firstRow = elements.get(0).getText().split(" ");
        return equalizer.checkLeftAndRightEquality(firstRow);
    }

    public Integer getAnswerForSecondRow() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tbody tr")));
        String[] firstRow = elements.get(1).getText().split(" ");
        return equalizer.checkLeftAndRightEquality(firstRow);
    }

    public Integer getAnswerForThirdRow() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tbody tr")));
        String[] firstRow = elements.get(2).getText().split(" ");
        return equalizer.checkLeftAndRightEquality(firstRow);
    }

}
