package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }



    @FindBy(xpath = "//*[@id=\"root\"]/div/div/header/div/div/div[1]/div[1]/button[1]")
    private WebElement loginToFormButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/header/div/div/div[1]/div[1]/button[2]")
    private WebElement signUpToFormButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div/div/form/div[2]/div/input")
    private WebElement loginEmailInput;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div/div/form/div[2]/div/span[2]/span")
    private WebElement loginEmailInputError;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div/div/form/div[2]/div/span[2]")
    private WebElement loginWrongEmailFormatInputError;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div/div")
    private WebElement loginWrongEmailError;


    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div/div/form/div[3]/div/input")
    private WebElement loginPasswordInput;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div/div/form/div[3]/div/span[2]")
    private  WebElement loginPasswordInputError;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div/div/form/div[4]/button")
    private WebElement forgotPassword;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div/div/form/div[5]/button")
    private WebElement login;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div/div/form/div[7]/button")
    private WebElement registerNowButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div/div/div/div[1]/input")
    private WebElement signUpEmailInput;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div/div/div/div[2]/input")
    private WebElement singUpPasswordInput;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div/div/div/div[3]/button")
    private WebElement signUp;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div/div/div/div[6]/button")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div/div/button/svg/path")
    private WebElement closeFromButton;



    public HomePage loginForm (){
        loginToFormButton.click();
        return new HomePage(driver);
    }

    public HomePage loginToSystemEmail(String userEmail){
        loginEmailInput.sendKeys(userEmail);
        return new HomePage(driver);
    }

    public HomePage loginToSystemPassword(String userPassword){
        loginPasswordInput.sendKeys(userPassword);
        return new HomePage(driver);
    }

    public HomePage signIn(){
        login.click();
        return new HomePage(driver);
    }

    public String loginEmailInputError(){
        return loginEmailInputError.getText();
    }

    public String loginWrongEmailFormatInputError(){
        return loginWrongEmailFormatInputError.getText();
    }

    public String loginPasswordInputError(){
        return  loginPasswordInputError.getText();
    }

    public String loginWrongEmailError(){
        return loginWrongEmailError.getText();
    }
}
