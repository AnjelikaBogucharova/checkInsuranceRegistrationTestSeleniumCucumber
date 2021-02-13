package com.anjelikabog.pages;

import com.anjelikabog.steps.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonPage {

    @FindBy(xpath = "//div[contains(@class,'site-header')]")
    WebElement header;

    public PersonPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectMenu(String nameMenu){
        header.findElement(By.xpath(".//*[@aria-label='" + nameMenu +"']")).click();
    }

    public void selectSubMenu(String nameSubMenu){
        header.findElement(By.xpath("//*[contains(text(), '" + nameSubMenu +"')]")).click();
    }

}
