package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchUserPage {

    private WebDriver webDriver;
    private WebDriverWait wait;

    public SearchUserPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    @Step("Username alanı '{username}' ile doldurulur")
    public SearchUserPage fillUsername1(String username) {
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//label[text()='Username']/following::input[1]")));
        usernameInput.clear();
        usernameInput.sendKeys(username);
        return this;
    }

    @Step("User Role olarak '{role}' seçilir")
    public SearchUserPage selectUserRole1(String role) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[text()='User Role']/following::div[contains(@class, 'oxd-select-wrapper')]")));
        dropdown.click();

        WebElement roleOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@role='option']/span[text()='" + role + "']")));
        roleOption.click();
        return this;
    }

    @Step("Employee Name alanı '{name}' ile doldurulur ve ilk öneri seçilir")
    public SearchUserPage fillEmployeeName1(String name) {
        WebElement employeeInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//label[text()='Employee Name']/following::input[1]")));
        employeeInput.clear();
        employeeInput.sendKeys(name);

        WebElement suggestion = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='oxd-autocomplete-option']//span[contains(text(), '" + name + "')]")));
        suggestion.click();
        return this;
    }

    @Step("Status olarak '{status}' seçilir")
    public SearchUserPage selectStatus1(String status) {
        WebElement statusDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[text()='Status']/following::div[contains(@class, 'oxd-select-wrapper')]")));
        statusDropdown.click();

        WebElement statusOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@role='option']/span[text()='" + status + "']")));
        statusOption.click();
        return this;
    }

    @Step("Search butonuna tıklanır")
    public SearchUserPage clickSearchButton() {
        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[normalize-space()='Search']")));
        searchBtn.click();
        return this;
    }

    @Step("Reset butonuna tıklanır")
    public SearchUserPage clickResetButton() {
        WebElement resetBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[normalize-space()='Reset']")));
        resetBtn.click();
        return this;
    }
}
