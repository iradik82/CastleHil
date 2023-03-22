package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonMethods {

    @FindBy(id = "user-name")
    public WebElement userNameTextField;

    @FindBy(id = "password")
    public WebElement passwordTextField;

    @FindBy(xpath = "//input[@id='login-button']")
    public WebElement loginButton;

    @FindBy(xpath = "(//div[@class='app_logo'])[1]")
    public WebElement logoSign;

    @FindBy(xpath = "(//h3[@data-test='error'])[1]")
    public WebElement errorMsg;

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

}
