package Steps;

import Utils.CommonMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.logging.Log;
import org.junit.Assert;
import org.testng.asserts.SoftAssert;

public class LoginSteps extends CommonMethods {
    @Given("I am on the Sauce Demo Login Page")
    public void i_am_on_the_sauce_demo_login_page() {

    }



    @When("I fill the account information for account StandardUser into the Username field {string} and the Password field {string}")
    public void i_fill_the_account_information_for_account_standard_user_into_the_username_field_and_the_password_field(String user, String pass) {
        sendText(login.userNameTextField,user);
        sendText(login.passwordTextField,pass);

    }
    @When("I click the Login Button")
    public void i_click_the_login_button() {
       click(login.loginButton);
    }
    @Then("I am redirected to the Sauce Demo Main Page")
    public void i_am_redirected_to_the_sauce_demo_main_page() throws InterruptedException {
        Thread.sleep(2000);

    }
    @Then("I verify the App Logo exists")
    public void i_verify_the_app_logo_exists() {


        Assert.assertTrue(login.logoSign.isDisplayed());


    }

    @When("I fill the account information for account LockedOutUser into the Username field {string} and the Password field {string}")
    public void i_fill_the_account_information_for_account_locked_out_user_into_the_username_field_and_the_password_field(String wrongUser, String pass) {

        sendText(login.userNameTextField,wrongUser);
        sendText(login.passwordTextField,pass);
    }




    @Then("I verify the Error Message contains the text {string}")
    public void i_verify_the_error_message_contains_the_text(String message) {

        String error = login.errorMsg.getText();

        // Assert.assertEquals(message,error);
        Assert.assertTrue(error.contains(message));

    }


}
