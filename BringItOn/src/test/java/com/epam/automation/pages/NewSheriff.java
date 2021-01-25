package com.epam.automation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewSheriff {
    @FindBy(id = "postform-text")
    private WebElement mainTextField;

    @FindBy(id = "postform-name")
    private WebElement title;

    @FindBy(id = "postform-expiration")
    private WebElement expiration;

    @FindBy(id = "postform-format")
    private WebElement syntax;

    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement createButton;

    private WebDriver driver;

    public NewSheriff(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public NewSheriff openPage() {
        driver.get("https://pastebin.com");

        return this;
    }

    public NewSheriff setText(String text) {
        mainTextField.sendKeys(text);
        return this;
    }

    public NewSheriffCheck createNewPaste() {
        createButton.click();
        return new NewSheriffCheck(driver);
    }

    public NewSheriff setTitle(String text) {
        title.sendKeys(text);
        return this;
    }

    public NewSheriff setExpiration(String text) {
        Select expirationSelect = new Select(expiration);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('postform-expiration').setAttribute('hidden', 'false')");
        js.executeScript("document.getElementById('postform-expiration').setAttribute('style', '')");
        expirationSelect.selectByVisibleText(text);
        return this;
    }

    public NewSheriff setSyntax(String text) {
        Select syntaxSelect = new Select(syntax);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('postform-format').setAttribute('hidden', 'false')");
        js.executeScript("document.getElementById('postform-format').setAttribute('style', '')");
        syntaxSelect.selectByVisibleText(text);
        return this;
    }
}