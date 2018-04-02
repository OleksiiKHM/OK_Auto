package HW_6_PageFactoryPractice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "passwd")
    WebElement passwdField;

    @FindBy(id = "SubmitLogin")
    WebElement submitButton;

    public void enterUserEmail(String userEmail) {
        emailField.sendKeys(userEmail);
    }

    public void enterPassword(String password) {
        passwdField.sendKeys(password);
    }

    public void logIn(String userEmail, String password) {
        enterUserEmail(userEmail);
        enterPassword(password);
        submitButton.click();
    }

}
