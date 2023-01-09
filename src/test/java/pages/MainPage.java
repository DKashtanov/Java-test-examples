package pages;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class MainPage extends Form {

    public MainPage() {
        super(By.id("main_feed"), "Main page");
    }

    private final ILabel lblMyPage = getElementFactory().getLabel(By.id("l_pr"), "My page");

    public void clickOnMyPage() {
        lblMyPage.state().waitForClickable();
        lblMyPage.click();
    }
}