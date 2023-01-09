package utils.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import testData.RequestsConstants;
import java.io.File;

public class VkApiSpecifications {

    public static RequestSpecification specCreateRecord(String owner_id, String message, String token,
                                             String version){
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addQueryParam(RequestsConstants.REQUEST_PARAMETER_OWNER_ID, owner_id)
                .addQueryParam(RequestsConstants.REQUEST_PARAMETER_MESSAGE, message)
                .addQueryParam(RequestsConstants.REQUEST_PARAMETER_ACCESS_TOKEN, token)
                .addQueryParam(RequestsConstants.REQUEST_PARAMETER_VERSION, version)
                .build();
    }

    public static RequestSpecification specMultipart(File file){
        return new RequestSpecBuilder()
                .setContentType(ContentType.MULTIPART)
                .addMultiPart(RequestsConstants.REQUEST_PARAMETER_PHOTO, file)
                .build();
    }

    public static RequestSpecification specUploadImage(String token, String version){
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addQueryParam(RequestsConstants.REQUEST_PARAMETER_ACCESS_TOKEN, token)
                .addQueryParam(RequestsConstants.REQUEST_PARAMETER_VERSION, version)
                .build();
    }

    public static RequestSpecification specSaveImage(String user_id, Integer server, String photo, String hash,
                                                     String token, String version){
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addQueryParam(RequestsConstants.REQUEST_PARAMETER_USER_ID, user_id)
                .addQueryParam(RequestsConstants.REQUEST_PARAMETER_SERVER, server)
                .addQueryParam(RequestsConstants.REQUEST_PARAMETER_PHOTO, photo)
                .addQueryParam(RequestsConstants.REQUEST_PARAMETER_HASH, hash)
                .addQueryParam(RequestsConstants.REQUEST_PARAMETER_ACCESS_TOKEN, token)
                .addQueryParam(RequestsConstants.REQUEST_PARAMETER_VERSION, version)
                .build();
    }

    public static RequestSpecification specEditRecord(String owner_id, String post_id, String message,
                                                      String imageId, String token, String version){
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addQueryParam(RequestsConstants.REQUEST_PARAMETER_OWNER_ID, owner_id)
                .addQueryParam(RequestsConstants.REQUEST_PARAMETER_POST_ID, post_id)
                .addQueryParam(RequestsConstants.REQUEST_PARAMETER_MESSAGE, message)
                .addQueryParam(RequestsConstants.REQUEST_PARAMETER_ATTACHMENTS, String.format(
                        RequestsConstants.REQUEST_PARAMETER_ATTACHMENTS_VALUE, owner_id, imageId))
                .addQueryParam(RequestsConstants.REQUEST_PARAMETER_ACCESS_TOKEN, token)
                .addQueryParam(RequestsConstants.REQUEST_PARAMETER_VERSION, version)
                .build();
    }

    public static RequestSpecification specAddComment(String owner_id, String post_id, String message,
                                                      String token, String version){
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addQueryParam(RequestsConstants.REQUEST_PARAMETER_OWNER_ID, owner_id)
                .addQueryParam(RequestsConstants.REQUEST_PARAMETER_POST_ID, post_id)
                .addQueryParam(RequestsConstants.REQUEST_PARAMETER_MESSAGE, message)
                .addQueryParam(RequestsConstants.REQUEST_PARAMETER_ACCESS_TOKEN, token)
                .addQueryParam(RequestsConstants.REQUEST_PARAMETER_VERSION, version)
                .build();
    }

    public static RequestSpecification specGetLikes(String owner_id, String post_id, String token, String version){
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addQueryParam(RequestsConstants.REQUEST_PARAMETER_OWNER_ID, owner_id)
                .addQueryParam(RequestsConstants.REQUEST_PARAMETER_ITEM_ID, post_id)
                .addQueryParam(RequestsConstants.REQUEST_PARAMETER_TYPE, RequestsConstants.REQUEST_PARAMETER_TYPE_VALUE)
                .addQueryParam(RequestsConstants.REQUEST_PARAMETER_ACCESS_TOKEN, token)
                .addQueryParam(RequestsConstants.REQUEST_PARAMETER_VERSION, version)
                .build();
    }

    public static RequestSpecification specDeleteRecord(String owner_id, String post_id, String token, String version){
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addQueryParam(RequestsConstants.REQUEST_PARAMETER_OWNER_ID, owner_id)
                .addQueryParam(RequestsConstants.REQUEST_PARAMETER_POST_ID, post_id)
                .addQueryParam(RequestsConstants.REQUEST_PARAMETER_ACCESS_TOKEN, token)
                .addQueryParam(RequestsConstants.REQUEST_PARAMETER_VERSION, version)
                .build();
    }
}
