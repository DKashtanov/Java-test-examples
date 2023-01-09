package models.apiModels;

import io.restassured.response.Response;
import testData.TestConstants;

public class ResponseResult<T> {

    private int statusCode;
    private T result;
    private String url;
    private String description;

    public ResponseResult() {
    }

    public ResponseResult(int statusCode, T result, String url, String description) {
        this.statusCode = statusCode;
        this.result = result;
        this.url = url;
        this.description = description;
    }

    public ResponseResult(Response response, String description) {
        this.statusCode = response.getStatusCode();
        this.url = null;
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public static boolean isSuccessful(ResponseResult responseResult){
        String statusCodeIdentity = String.valueOf(responseResult.getStatusCode()).substring(0,1);
        return !statusCodeIdentity.equals(TestConstants.STATUS_CODE_4xx) &&
                !statusCodeIdentity.equals(TestConstants.STATUS_CODE_5xx);
    }

    public static boolean isSuccessfulAndResultIsNotNull(ResponseResult responseResult){
        return isSuccessful(responseResult) && responseResult.getResult() != null;
    }
}