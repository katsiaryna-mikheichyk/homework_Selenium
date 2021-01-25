package com.epam.automation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewPaste {
    @FindBy(id = "postform-text")
    private WebElement mainTextField;

    @FindBy(id = "postform-name")
    private WebElement title;

    @FindBy(id = "postform-expiration")
    private WebElement expiration;

    private WebDriver driver;

    public NewPaste(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public NewPaste setText(String text) {
        mainTextField.sendKeys(text);
        return this;
    }

    public NewPaste openPage() {
        driver.get("https://pastebin.com");
        return this;
    }

    public NewPaste setTitle(String text) {
        title.sendKeys(text);
        return this;
    }

    public NewPaste setExpiration(String text) {
        Select expirationSelect = new Select(expiration);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('postform-expiration').setAttribute('hidden', 'false')");
        js.executeScript("document.getElementById('postform-expiration').setAttribute('style', '')");
        expirationSelect.selectByVisibleText(text);
        return this;
    }
}
