package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddUserPage {
        private WebDriver webDriver;
        private WebDriverWait wait;

        public AddUserPage(WebDriver webDriver) {
            this.webDriver = webDriver;
            this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        }

    @Step("Admin Menüsü tıklanır")
        public AddUserPage clickAdminMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Admin']")));
        webDriver.findElement(By.xpath("//span[text()='Admin']")).click();
        return this;
    }
    @Step("User Management tıklanır")
    public AddUserPage clickUserManagement() {
            WebElement userManagementLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'/admin/viewAdminModule')]")));
            userManagementLink.click();
            return this;
    }
    @Step("Add User butonuna tıklanır")
    public AddUserPage clickAddButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Add']")));
        webDriver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
        return this;
    }
    @Step("Select User Role alanı tıklanır")
    public AddUserPage selectUserRole(String role) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='User Role']/following::div[1]")));
        webDriver.findElement(By.xpath("//label[text()='User Role']/following::div[1]")).click();
        WebElement dropdownOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='option']/span[text()='" + role + "']")));
        dropdownOption.click();
        return this;
    }
    @Step("Employee Name alanı doldurulur ve ilk öneri seçilir")
    public AddUserPage fillEmployeeName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Type for hints...']")));
        webDriver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys(name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-autocomplete-option']//span[contains(text(), 'Admin  Admin123')]\n"))).click();
        return this;
    }
    @Step("Username alanı doldurulur")
    public AddUserPage fillUsername(String username) {
        webDriver.findElement(By.xpath("//label[text()='Username']/following::input[1]")).sendKeys(username);
        return this;
    }
    @Step("Status select edilir")
    public AddUserPage selectStatus(String status) {
        webDriver.findElement(By.xpath("//label[text()='Status']/following::div[1]")).click();
        WebElement dropdownOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='option']/span[text()='" + status + "']")));
        dropdownOption.click();
        return this;
    }
    @Step("Şifre alanı doldurulur")
    public AddUserPage fillPassword(String password) {
        webDriver.findElement(By.xpath("//label[text()='Password']/following::input[1]")).sendKeys(password);
        return this;
    }
    @Step("Şifre tekrar alanı doldurulur")
    public AddUserPage fillConfirmPassword(String password) {
        webDriver.findElement(By.xpath("//label[text()='Confirm Password']/following::input[1]")).sendKeys(password);
        return this;
    }
    @Step("Kayıt butonuna tıklanır")
    public AddUserPage clickSaveButton() {
        webDriver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
        return this;
    }
}
