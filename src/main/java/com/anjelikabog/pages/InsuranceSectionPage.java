package com.anjelikabog.pages;

import com.anjelikabog.steps.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsuranceSectionPage {

    @FindBy(id="main-page")
    WebElement insurance;

    public InsuranceSectionPage(){
        PageFactory.initElements(BaseSteps.getDriver(),this);
    }

    public void selectSection(String name){
        insurance.findElement(By.xpath(".//label[text()='" + name +"']")).click();
    }

    public void choose(String name){
        insurance.findElement(By.xpath("//*[contains(text(), '" + name +"')]")).click();
    }

}
