package utils.api;

import aquality.selenium.browser.AqualityServices;
import io.restassured.response.Response;
import models.ResponseData;
import models.PhotoResponse;
import models.apiModels.ResponseResult;
import testData.DataProvider;
import testData.RequestsConstants;
import utils.ReaderUtils;
import java.io.File;

public class VkApiUtils {

    public static ResponseResult<ResponseData> createRecord(String message){
        Response response = ApiUtils.doPostWithoutBody(DataProvider.CONFIG_DATA.getRequestUrl() +
                DataProvider.CONFIG_DATA.getMethodWallPost(), VkApiSpecifications.specCreateRecord(
                DataProvider.CONFIG_DATA.getOwnerId(), message, DataProvider.CONFIG_DATA.getToken(),
                DataProvider.CONFIG_DATA.getVersion()));
        ResponseData record = ReaderUtils.convertContentToObject(response.asString(), ResponseData.class);
        return new ResponseResult<>(response.getStatusCode(), record, DataProvider.CONFIG_DATA.getRequestUrl() +
                DataProvider.CONFIG_DATA.getMethodWallPost(), RequestsConstants.DESCRIPTION_CREATE_RECORD);
    }

    public static ResponseResult<ResponseData> editRecord(String message, String id){
        Response response = ApiUtils.doPostWithoutBody(DataProvider.CONFIG_DATA.getRequestUrl() +
                DataProvider.CONFIG_DATA.getMethodWallEdit(), VkApiSpecifications.specEditRecord(
                DataProvider.CONFIG_DATA.getOwnerId(), id, message, getImageId(), DataProvider.CONFIG_DATA.getToken(),
                DataProvider.CONFIG_DATA.getVersion()));
        ResponseData record = ReaderUtils.convertContentToObject(response.asString(), ResponseData.class);
        return new ResponseResult<>(response.getStatusCode(), record,  DataProvider.CONFIG_DATA.getRequestUrl() +
                DataProvider.CONFIG_DATA.getMethodWallEdit(), RequestsConstants.DESCRIPTION_EDIT_RECORD);
    }

    private static ResponseResult<ResponseData> getUploadServer(){
        Response getUploadServer = ApiUtils.doPostWithoutBody(DataProvider.CONFIG_DATA.getRequestUrl() +
                DataProvider.CONFIG_DATA.getMethodGetWallUploadServer(), VkApiSpecifications.specUploadImage(
                DataProvider.CONFIG_DATA.getToken(), DataProvider.CONFIG_DATA.getVersion()));
        return new ResponseResult<>(getUploadServer.getStatusCode(), ReaderUtils.convertContentToObject(
                getUploadServer.asString(), ResponseData.class), DataProvider.CONFIG_DATA.getRequestUrl() +
                DataProvider.CONFIG_DATA.getMethodGetWallUploadServer(),
                RequestsConstants.DESCRIPTION_GET_UPLOAD_SERVER);
    }

    private static ResponseResult<ResponseData> sendImageToUrl(String uploadUrl){
        File file = new File(DataProvider.TEST_DATA.getImagePath());
        Response sendImageToUrl = ApiUtils.doPostWithoutBody(uploadUrl, VkApiSpecifications.specMultipart(file));
        return new ResponseResult<>(sendImageToUrl.getStatusCode(), ReaderUtils.convertContentToObject(
                sendImageToUrl.asString(), ResponseData.class), uploadUrl,
                RequestsConstants.DESCRIPTION_SET_IMAGE_TO_URL);
    }

    private static ResponseResult<PhotoResponse> saveImage(ResponseData imageUploadServerResult){
        Response savedImage = ApiUtils.doPostWithoutBody(DataProvider.CONFIG_DATA.getRequestUrl() +
                DataProvider.CONFIG_DATA.getMethodSaveWallPhoto(), VkApiSpecifications.specSaveImage(
                DataProvider.CONFIG_DATA.getOwnerId(), imageUploadServerResult.getServer(),
                imageUploadServerResult.getPhoto(), imageUploadServerResult.getHash(),
                DataProvider.CONFIG_DATA.getToken(), DataProvider.CONFIG_DATA.getVersion()));
        return new ResponseResult<>(savedImage.getStatusCode(), ReaderUtils.convertContentToObject(
                savedImage.asString(), PhotoResponse.class), DataProvider.CONFIG_DATA.getRequestUrl() +
                DataProvider.CONFIG_DATA.getMethodSaveWallPhoto(), RequestsConstants.DESCRIPTION_SAVE_IMAGE);
    }

    public static String getImageId(){
        String imageId = null;
        ResponseResult<ResponseData> uploadServerResult = getUploadServer();
        if (ResponseResult.isSuccessfulAndResultIsNotNull(uploadServerResult)) {
            ResponseData imageUploadServerResult = sendImageToUrl(uploadServerResult.getResult().getResponse()
                    .getUploadUrl()).getResult();
            PhotoResponse saveImageResult = saveImage(imageUploadServerResult).getResult();
            imageId = String.valueOf(saveImageResult.getResponse().get(0).getId());
        }
        else {
            AqualityServices.getLogger().error("[Get upload server] request is not successful");
        }
        return imageId;
    }

    public static void addComment(String id, String commentText){
        ApiUtils.doPostWithoutBody(DataProvider.CONFIG_DATA.getRequestUrl() +
                DataProvider.CONFIG_DATA.getMethodCreateComment(), VkApiSpecifications.specAddComment(
                DataProvider.CONFIG_DATA.getOwnerId(), id, commentText, DataProvider.CONFIG_DATA.getToken(),
                DataProvider.CONFIG_DATA.getVersion()));
    }

    public static ResponseResult<ResponseData> checkLikes(String id){
        Response response = ApiUtils.doPostWithoutBody(DataProvider.CONFIG_DATA.getRequestUrl() +
                DataProvider.CONFIG_DATA.getMethodGetLikesList(), VkApiSpecifications.specGetLikes(
                DataProvider.CONFIG_DATA.getOwnerId(), id, DataProvider.CONFIG_DATA.getToken(),
                DataProvider.CONFIG_DATA.getVersion()));
        ResponseData comment = ReaderUtils.convertContentToObject(response.asString(), ResponseData.class);
        return new ResponseResult<>(response.getStatusCode(), comment,  DataProvider.CONFIG_DATA.getRequestUrl() +
                DataProvider.CONFIG_DATA.getMethodGetLikesList(), RequestsConstants.DESCRIPTION_CHECK_LIKES);
    }

    public static void deleteRecord(String id){
        ApiUtils.doPostWithoutBody(DataProvider.CONFIG_DATA.getRequestUrl() +
                DataProvider.CONFIG_DATA.getMethodDeleteRecord(), VkApiSpecifications.specDeleteRecord(
                DataProvider.CONFIG_DATA.getOwnerId(), id, DataProvider.CONFIG_DATA.getToken(),
                DataProvider.CONFIG_DATA.getVersion()));
    }
}