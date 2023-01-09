package testData;

import com.google.gson.annotations.SerializedName;

public class ConfigData {

    @SerializedName("url")
    private String url;
    @SerializedName("login")
    private String login;
    @SerializedName("password")
    private String password;
    @SerializedName("requestUrl")
    private String requestUrl;
    @SerializedName("token")
    private String token;
    @SerializedName("ownerId")
    private String ownerId;
    @SerializedName("version")
    private String version;
    @SerializedName("methodWallPost")
    private String methodWallPost;
    @SerializedName("methodWallEdit")
    private String methodWallEdit;
    @SerializedName("methodGetWallUploadServer")
    private String methodGetWallUploadServer;
    @SerializedName("methodSaveWallPhoto")
    private String methodSaveWallPhoto;
    @SerializedName("methodCreateComment")
    private String methodCreateComment;
    @SerializedName("methodGetLikesList")
    private String methodGetLikesList;
    @SerializedName("methodDeleteRecord")
    private String methodDeleteRecord;

    public String getUrl() {
        return url;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public String getToken() {
        return token;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getVersion() {
        return version;
    }

    public String getMethodWallPost() {
        return methodWallPost;
    }

    public String getMethodWallEdit() {
        return methodWallEdit;
    }

    public String getMethodGetWallUploadServer() {
        return methodGetWallUploadServer;
    }

    public String getMethodSaveWallPhoto() {
        return methodSaveWallPhoto;
    }

    public String getMethodCreateComment() {
        return methodCreateComment;
    }

    public String getMethodGetLikesList() {
        return methodGetLikesList;
    }

    public String getMethodDeleteRecord() {
        return methodDeleteRecord;
    }
}
