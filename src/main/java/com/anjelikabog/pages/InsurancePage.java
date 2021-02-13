package com.anjelikabog.pages;

import com.anjelikabog.steps.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InsurancePage {

    @FindBy(xpath = "//*[@data-test-id='PageTeaserDict_header']")
    public WebElement title;

    public InsurancePage(){
        PageFactory.initElements(BaseSteps.getDriver(),this);
    }

    public void waitTitle(){
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(title));
    }

    public void goToRegistration(){
        BaseSteps.getDriver().findElement(By.xpath("//*[@data-test-id='PageTeaserDict_button']")).click();
    }


}
