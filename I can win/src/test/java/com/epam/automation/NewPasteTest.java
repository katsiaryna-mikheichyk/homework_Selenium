package com.epam.automation;


import com.epam.automation.pages.NewPaste;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewPasteTest
{

    private WebDriver driver;

    @Before
    public void initEnv() {
        System.out.println("init");
        System.setProperty("webdriver.chrome.driver", "/Users/Katsiaryna_Mikheichy/Documents/webdriver/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void firstTest() {
        new NewPaste(driver)
                .openPage()
                .setText("Hello from WebDriver")
                .setTitle("helloweb")
                .setExpiration("10 Minutes");
    }

    @After
    public void destroyEnv() {
        driver.quit();
    }
}
