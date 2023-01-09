import aquality.selenium.browser.AqualityServices;
import models.ResponseData;
import models.apiModels.ResponseResult;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.MyPage;
import pages.PasswordForm;
import testData.DataProvider;
import utils.Logger;
import utils.RandomUtils;
import utils.api.VkApiUtils;

public class VkApiTest extends BaseTest{

    private final LoginPage loginPage = new LoginPage();
    private final PasswordForm passwordForm = new PasswordForm();
    private final MainPage mainPage = new MainPage();
    private final MyPage myPage = new MyPage();
    private final Logger logger = new Logger();

    @Test
    public void checkVkApi() {
        logger.logStep("Go to VK Url");

        logger.logStep("Authorization");
        loginPage.enterLogin(DataProvider.CONFIG_DATA.getLogin());
        loginPage.clickEnter();
        passwordForm.enterPassword(DataProvider.CONFIG_DATA.getPassword());
        passwordForm.clickContinue();

        logger.logStep("Go to 'My Page'");
        mainPage.clickOnMyPage();

        logger.logStep("Create a record and get its id");
        String messageText = RandomUtils.getRandomString();
        ResponseResult<ResponseData> message = VkApiUtils.createRecord(messageText);
        String messageId = message.getResult().getResponse().getPostId().toString();
        Assert.assertEquals(message.getStatusCode(), HttpStatus.SC_OK, "Status code is not expected.");

        logger.logStep("Check that the record appeared");
        Assert.assertEquals(myPage.getFirstPostText(messageId), messageText, "Messages don't match");
        Assert.assertEquals(myPage.getFirstPostAuthor(messageId),
                DataProvider.TEST_DATA.getAuthor(), "Authors don't match.");

        logger.logStep("Edit the message and add an image");
        String newText = RandomUtils.getRandomString();
        ResponseResult<ResponseData> editMessage = VkApiUtils.editRecord(newText, messageId);
        String editMessageId = editMessage.getResult().getResponse().getPostId().toString();

        logger.logStep("Check that the message was changed and the image was added");
        Assert.assertEquals(myPage.getFirstPostText(editMessageId), newText, "Messages don't match.");
        String imageName = MyPage.getImageName();
        myPage.downloadImageByUrl(editMessageId, imageName);
        Assert.assertTrue(myPage.compareImages(imageName).startsWith(DataProvider.TEST_DATA.getImagesDifferencePercentage()),
                "The images don't equal.");

        logger.logStep("Add a comment to the record");
        String commentText = RandomUtils.getRandomString();
        VkApiUtils.addComment(editMessageId, commentText);

        logger.logStep("Check that the comment is added");
        myPage.showNextComment(editMessageId);
        Assert.assertEquals(myPage.getFirstPostComment(Integer.parseInt(editMessageId)), commentText,
                "Comments don't match.");
        Assert.assertEquals(myPage.getFirstPostCommentAuthor(editMessageId), myPage.getFirstPostAuthor(editMessageId),
                "Authors don't match.");

        logger.logStep("Like the post");
        myPage.makeLike(editMessageId);

        logger.logStep("Check that the like is added");
        Assert.assertEquals(VkApiUtils.checkLikes(editMessageId).getResult().getResponse().getItems()
                .get(Integer.parseInt(DataProvider.TEST_DATA.getFirstLikeIndex())).toString(),
                DataProvider.CONFIG_DATA.getOwnerId(), "Users don't match.");

        logger.logStep("Delete the record");
        VkApiUtils.deleteRecord(editMessageId);

        logger.logStep("Check that the record is deleted");
        AqualityServices.getConditionalWait().waitFor(() -> !myPage.isRecordLabelDisplayed(editMessageId));
        Assert.assertFalse(myPage.isRecordLabelDisplayed(editMessageId), "The record wasn't deleted.");
    }
}