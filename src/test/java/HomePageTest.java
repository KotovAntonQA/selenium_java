import Pages.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class HomePageTest {
    private WebDriver driver;
    private HomePage homePage;
    static WebDriverWait wait;


    @Before
    public void setUp(){
        Config config = new Config();
        driver = config.getBrowser(config.browser);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Links links = new Links();
        String url = links.getHomePage();
        driver.get(url);
        homePage = new HomePage(driver);
    }

    @Test
    public void loginToSystemTest(){
      HomePage homePage = PageFactory.initElements(driver, HomePage.class);
      homePage.loginForm();
      Variables variables = new Variables();
      homePage.loginToSystemEmail(variables.userEmail);
      homePage.loginToSystemPassword(variables.userPassword);
      homePage.signIn();
      wait = (new WebDriverWait(driver, 5));
      wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[contains(text(), '"+variables.userEmail+"' )]")));
      String userName = driver.findElement(By.xpath("//button[contains(text(), '"+variables.userEmail+"' )]")).getText();
      String currentUrl = driver.getCurrentUrl();
      Links link = new Links();
      assert (userName != variables.userEmail || currentUrl != link.getTradePage()): "Incorrect user email: " + userName + " " + "must be: " + variables.userEmail + " " +  "Incorrect url " + currentUrl + " " + "must be: " + link.getTradePage();
    }

    @Test
    public void loginToSystemEmptyInputs(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.loginForm();
        homePage.signIn();
        ErrorsClass errorsClass = new ErrorsClass();
        String emailError = homePage.loginEmailInputError();
        String passwordError = homePage.loginPasswordInputError();
        assert (emailError != errorsClass.loginEmailInputError && passwordError != errorsClass.loginPasswordInputError) : "Wrong error messages";
    }

    @Test
    public void loginToSystemEmptyEmail(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        Variables variables = new Variables();
        homePage.loginForm();
        homePage.loginToSystemPassword(variables.userPassword);
        homePage.signIn();
        ErrorsClass errorsClass = new ErrorsClass();
        String emailError = homePage.loginEmailInputError();
        assert (emailError != errorsClass.loginEmailInputError) : "Wrong error message in email input: " + " " + emailError;
    }

    @Test
    public void loginToSystemEmptyPassword(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        Variables variables = new Variables();
        homePage.loginForm();
        homePage.loginToSystemEmail(variables.userEmail);
        homePage.signIn();
        ErrorsClass errorsClass = new ErrorsClass();
        String passwordError = homePage.loginPasswordInputError();
        assert (passwordError != errorsClass.loginPasswordInputError): "Wrong error message in password input: " + " " +  passwordError;
    }

    @Test
    public void loginToSystemWrongFormatEmail(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        Variables variables = new Variables();
        homePage.loginForm();
        homePage.loginToSystemEmail(variables.userEmailNoDomain);
        homePage.signIn();
        ErrorsClass errorsClass = new ErrorsClass();
        String emailError = homePage.loginWrongEmailFormatInputError();
        assert (emailError != errorsClass.loginWrongEmailFormatInputError): "Wrong error message in email input: " + " " +  emailError;
    }

    @Test
    public  void loginToSystemWrongEmail(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        Variables variables = new Variables();
        homePage.loginForm();
        homePage.loginToSystemEmail(variables.userWrongEmail);
        homePage.loginToSystemPassword(variables.userPassword);
        homePage.signIn();
        wait = (new WebDriverWait(driver, 5));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div")));
        ErrorsClass errorsClass = new ErrorsClass();
        String emailError = homePage.loginWrongEmailError();
        assert (emailError != errorsClass.loginWrongEmailError) : "Wrong error message in email notification: " + " " +  emailError;

    }





    @After
    public void closeAll(){
        driver.quit();
    }
}
