package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PasswordForm extends Form {

    public PasswordForm() {
        super(By.id("root"), "Password form");
    }

    private final ITextBox txtPassword = getElementFactory().getTextBox(By.xpath(
            "//input[@name='password']"), "Password text");
    private final IButton btnContinue = getElementFactory().getButton(By.xpath(
            "//span[contains(@class,'Button') and contains(@class,'in')]"), "Continue button");

    public void enterPassword(String password){
        txtPassword.sendKeys(password);
    }

    public void clickContinue(){
        btnContinue.click();
    }
}