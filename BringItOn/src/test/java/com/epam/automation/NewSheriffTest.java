package com.epam.automation;


import com.epam.automation.pages.NewSheriff;
import com.epam.automation.pages.NewSheriffCheck;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class NewSheriffTest {

    private WebDriver driver;

    private final String code = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";

    private final String title = "how to gain dominance among developers";

    @Before
    public void initEnv() {
        System.out.println("init");
        System.setProperty("webdriver.chrome.driver", "/Users/Katsiaryna_Mikheichy/Documents/webdriver/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void firstTest() {
        NewSheriffCheck resultpage = new NewSheriff(driver)
                .openPage()
                .setText("Hello from WebDriver")
                .setTitle("helloweb")
                .setExpiration("10 Minutes")
                .createNewPaste();

        Assert.assertTrue("Title contains proper text", resultpage.isTitleEquals("helloweb"));
        Assert.assertTrue("TextArea contains proper text", resultpage.isTextareaEquals("Hello from WebDriver"));
        Assert.assertTrue("Expire Field contains proper text", resultpage.isExpireEquals("10 min"));
}

    @After
    public void destroyEnv() {
        driver.quit();
    }
}
