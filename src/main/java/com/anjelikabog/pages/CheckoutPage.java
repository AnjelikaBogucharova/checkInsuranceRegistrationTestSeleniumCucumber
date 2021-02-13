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


import static org.junit.Assert.assertTrue;

public class CheckoutPage  {
    WebDriver driver;

    @FindBy(id="surname_vzr_ins_0")
    public WebElement lastNameInsured;

    @FindBy(id="name_vzr_ins_0")
    public WebElement firstNameInsured;

    @FindBy(id="birthDate_vzr_ins_0")
    public WebElement birthDateInsured;

    @FindBy(id="person_lastName")
    public WebElement lastName;

    @FindBy(id="person_firstName")
    public WebElement firstName;

    @FindBy(id="person_middleName")
    public WebElement secondName;

    @FindBy(id="person_birthDate")
    public WebElement birthDate;

    @FindBy(id="passportSeries")
    public WebElement docSeries;

    @FindBy(id="passportNumber")
    public WebElement docNumber;

    @FindBy(id="documentDate")
    public WebElement docDate;

    @FindBy(id="documentIssue")
    public WebElement docIssue;

    @FindBy(xpath = "//*[contains(@class,'alert-form')]")
    public WebElement error;

    public CheckoutPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
        this.driver=BaseSteps.getDriver();
    }

    public void fillField(WebElement elem, String value){
        elem.clear();
        elem.sendKeys(value);
    }

    public void fillField(String key, String value){
        switch (key){
            case "Фамилия застрахованного": fillField(lastNameInsured, value); break;
            case "Имя застрахованного": fillField(firstNameInsured, value); break;
            case "Дата рождения застрахованного": fillField(birthDateInsured, value); changeOfFocus(); break;
            case "Фамилия": fillField(lastName, value); break;
            case "Имя": fillField(firstName, value); break;
            case "Отчество": fillField(secondName, value); break;
            case "Дата рождения": fillField(birthDate, value); changeOfFocus(); break;
            case "Серия паспорта": fillField(docSeries, value); break;
            case "Номер паспорта": fillField(docNumber, value); break;
            case "Дата выдачи": fillField(docDate, value); changeOfFocus(); break;
            case "Выдан": fillField(docIssue, value); break;
            default:  throw new AssertionError("Поле '"+key+"' не объявлено на странице");
        }
    }



    public String getField(String field){
        switch (field){
            case "Фамилия застрахованного": return lastNameInsured.getAttribute("value");
            case "Имя застрахованного": return firstNameInsured.getAttribute("value");
            case "Дата рождения застрахованного": return birthDateInsured.getAttribute("value");
            case "Фамилия": return lastName.getAttribute("value");
            case "Имя": return firstName.getAttribute("value");
            case "Отчество": return secondName.getAttribute("value");
            case "Дата рождения": return birthDate.getAttribute("value");
            case "Серия паспорта": return docSeries.getAttribute("value");
            case "Номер паспорта": return docNumber.getAttribute("value");
            case "Дата выдачи": return docDate.getAttribute("value");
            case "Выдан": return docIssue.getAttribute("value");
        }
        throw new AssertionError("Поле не объявлено на странице");
    }



    public void waitButtonIssueToBeClickable(){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[contains(text(),'Оформить')]")))).click();
    }

    public void changeOfFocus()  {
        driver.findElement(By.xpath("//legend[contains(text(),'Страхователь')]")).click();
    }

    public void clickButtonContinue(){
        driver.findElement(By.xpath("//button[contains(text(),'Продолжить')]")).click();
    }

    public void checkError(String value){
        assertTrue(String.format("Полученная ошибка %s не соответствует ожидаемой %s", error.getText(), value), error.getText().contains(value));
    }

}
