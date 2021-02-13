package com.anjelikabog.steps;

import com.anjelikabog.util.TestProperties;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {
    public static WebDriver getDriver() {
        return driver;
    }

    protected static WebDriver driver;

    public static Properties property = TestProperties.getInstance().getProperties();


    @Before
    public static void executeBeforeTest() {
        System.setProperty("webdriver.chrome.driver", property.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(property.getProperty("url"));
    }

    protected static void fillField(By elem, String value) {
        driver.findElement(elem).clear();
        driver.findElement(elem).sendKeys(value);
    }

    @After
    public static void executeAfterTest() {
        driver.quit();
    }

}
