package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class LoginPage extends Form {

    public LoginPage() {
        super(By.id("index_login"), "Login page");
    }

    private final ITextBox txtEmailOrPhone = getElementFactory().getTextBox(By.id("index_email"),
            "Email/Phone text");
    private final IButton btnEnter = getElementFactory().getButton(By.xpath(
            "//button[contains(@class,'signInButton')]"), "Enter button");

    public void enterLogin(String login){
        txtEmailOrPhone.sendKeys(login);
    }

    public void clickEnter(){
        btnEnter.click();
    }
}