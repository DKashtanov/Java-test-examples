package models;

import com.google.gson.annotations.SerializedName;

public class ResponseData {

    @SerializedName("response")
    private RecordData response;
    @SerializedName("server")
    private Integer server;
    @SerializedName("photo")
    private String photo;
    @SerializedName("hash")
    private String hash;

    public RecordData getResponse() {
        return response;
    }

    public void setResponse(RecordData response) {
        this.response = response;
    }

    public Integer getServer() {
        return server;
    }

    public void setServer(Integer server) {
        this.server = server;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}