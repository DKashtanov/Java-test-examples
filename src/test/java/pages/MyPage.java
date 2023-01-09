package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import testData.DataProvider;
import testData.TestConstants;
import utils.CompareImage;
import utils.DateUtils;
import utils.RobotUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyPage extends Form {

    public MyPage() {
        super(By.className("ProfileHeader"), "My page");
    }

    private final String firstPostText = "//div[contains(@id,'%s')]/div[contains(@class,'text')]";
    private final String firstPostAuthor = "//div[contains(@id,'%s')]//a[@class='author']";
    private final String firstPostComment = "//div[contains(@id,'%s')]/div[contains(@class,'text')]";
    private final String firstPostCommentAuthor = "//div[contains(@id,'%s')]//a[not(@data-post-id) and @data-from-id]";
    private final String showNextCommentButton = "//div[contains(@id,'%s')]//span[contains(@class,'js-replies')]";
    private final String LikeButton = "//div[contains(@id,'%s')]//div[contains(@data-section-ref,'reactions-button-icon')]";
    private final String postImage = "//div[contains(@id,'%s')]//a[@aria-label]";
    private final ILabel openPostImage = getElementFactory().getLabel(By.xpath(
            "//div[contains(@id,'photo')]//img[not(@loading)]"), "Open image label");
    private final IButton closeButton = getElementFactory().getButton(By.xpath(
            "//div[contains(@class,'close') and (contains(@class,'btn'))]"), "Close button");

    public ILabel getFirstPost(String id){
        return getElementFactory().getLabel(By.xpath(String.format(firstPostText, id)), "First post on page text");
    }

    public String getFirstPostText(String id){
        if (!getFirstPost(id).state().isDisplayed()){
            getFirstPost(id).getMouseActions().moveMouseToElement();
        }
        return getFirstPost(id).getText();
    }

    public ILabel getLabelFirstPostAuthor(String id){
        return getElementFactory().getLabel(By.xpath(String.format(firstPostAuthor, id)),
                "First post on page author text");
    }

    public String getFirstPostAuthor(String id){
        return getLabelFirstPostAuthor(id).getText();
    }

    public ILabel getLabelFirstPostComment(Integer id){
        return getElementFactory().getLabel(By.xpath(String.format(firstPostComment,
                id + DataProvider.TEST_DATA.getDifferenceBetweenPostIdAndCommentId())), "First post comment text");
    }

    public String getFirstPostComment(Integer id){
        if (!getLabelFirstPostComment(id).state().isDisplayed()){
            getLabelFirstPostComment(id).getMouseActions().moveMouseToElement();
        }
        return getLabelFirstPostComment(id).getText();
    }

    public ILabel getLabelFirstPostCommentAuthor(String id){
        return getElementFactory().getLabel(By.xpath(String.format(firstPostCommentAuthor,
                id)), "First post comment author text");
    }

    public String getFirstPostCommentAuthor(String id){
        return getLabelFirstPostCommentAuthor(id).getText();
    }

    public IButton getButtonNextComment(String id){
        return getElementFactory().getButton(By.xpath(String.format(showNextCommentButton, id)),
                "Show next comment button");
    }

    public void showNextComment(String id){
        if(getButtonNextComment(id).state().isClickable()){
            getButtonNextComment(id).click();
        }
    }

    public IButton getButtonLike(String id){
        return getElementFactory().getButton(By.xpath(String.format(LikeButton, id)),"Like button");
    }

    public void makeLike(String id){
        if (!getButtonLike(id).state().isDisplayed()) {
            getButtonLike(id).getMouseActions().moveMouseToElement();
        }
        getButtonLike(id).click();
    }

    public boolean isRecordLabelDisplayed(String id){
        return getFirstPost(id).state().isDisplayed();
    }

    public static String getImageName(){
        return DateUtils.getDataAndTime() + DataProvider.TEST_DATA.getImageToCompareName();
    }

    public ILabel getPostImage(String id){
        return getElementFactory().getLabel(By.xpath(String.format(postImage, id)), "Record's image");
    }

    public void downloadImage(String id, String imageName){
        getPostImage(id).getMouseActions().moveMouseToElement();
        getPostImage(id).click();
        openPostImage.getMouseActions().rightClick();
        RobotUtils.downloadImage(DataProvider.setImagePath(), imageName);
        closeButton.click();
    }

    public String compareImages(String imageName){
        return String.valueOf(CompareImage.compareImages(DataProvider.TEST_DATA.getImagePath(),
                DataProvider.TEST_DATA.getImageToComparePath() + imageName));
    }

    public void downloadImageByUrl(String id, String imageName){
        getPostImage(id).getJsActions().scrollIntoView();
        getPostImage(id).click();
        InputStream in;
        try {
            in = new URL(openPostImage.getAttribute(TestConstants.ATTRIBUTE_NAME)).openStream();
            Path path = Paths.get(String.format(DataProvider.TEST_DATA.getImageToComparePath() + imageName));
            Files.copy(in, path);
        } catch (IOException e) {
            AqualityServices.getLogger().error("Can't download an image. " + e.getMessage());
        }
        closeButton.click();
    }
}