import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Config {
        String browser = "chrome";
        public String getBrowserName(){
            return browser;
        }
    public WebDriver getBrowser(String browserType){

        WebDriver driver = null;
        if(browserType.equals("chrome")){
            System.setProperty("webdriver.chrome.driver" , "C:\\Users\\Антон\\IdeaProjects\\bitbein\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        if(browserType.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Антон\\IdeaProjects\\bitbein\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        return driver;
    }
}
