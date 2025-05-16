package Bases;
import Pages.AddUserPage;
import Pages.LoginPage;
import Pages.SearchUserPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest extends BaseLibrary {

    public LoginPage loginPage;
    public AddUserPage addUserPage;
    public SearchUserPage searchUserPage;

    @BeforeMethod
    public void openBrowser(){
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        loginPage = new LoginPage();
        addUserPage = new AddUserPage(webDriver);
        searchUserPage = new SearchUserPage(webDriver);
    }

    @AfterMethod
    public void closeBrowser(){
            webDriver.quit();
        }
}


