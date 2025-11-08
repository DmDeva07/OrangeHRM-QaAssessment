package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper {
    private final WebDriver driver;

    public WaitHelper(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver must not be null");
        }
        this.driver = driver;
    }

    // 1. Wait until element is visible
    public WebElement waitForElementVisible(By locator, int timeInSeconds) {
        validateLocator(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // 2. Wait until element is click
    public WebElement waitForElementClickable(By locator, int timeInSeconds) {
        validateLocator(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // 3. Wait until URL becomes a specific one
    public void waitForUrlToBe(String url, int timeInSeconds) {
        validateString(url, "URL");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.urlToBe(url));
    }

    // 4. Wait until URL contains a specific keyword
    public void waitForUrlContains(String partialUrl, int timeInSeconds) {
        validateString(partialUrl, "Partial URL");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.urlContains(partialUrl));
    }

    // 5. Wait until element disappears (useful for overlay and pop-up)
    public void waitForElementToDisappear(By locator, int timeInSeconds) {
        validateLocator(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    // 6. Wait until text appears in an element
    public void waitForTextToBePresent(By locator, String text, int timeInSeconds) {
        validateLocator(locator);
        validateString(text, "Text");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    // Internal validation for Locator
    private void validateLocator(By locator) {
        if (locator == null) {
            throw new IllegalArgumentException("Locator must not be null");
        }
    }

    // Internal validation for String
    private void validateString(String value, String name) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(name + " must not be null or empty");
        }
    }
}
