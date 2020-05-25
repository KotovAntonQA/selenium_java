package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TradePage {
    private WebDriver driver;

    public TradePage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"open-user-nav\"]/text()")
    private WebElement userName;

    public TradePage userName(){
        String text = driver.findElement(By.xpath("//*[@id=\"open-user-nav\"]/span[1]")).getText();
        System.out.println(text);
        return new TradePage(driver);
    }



}
