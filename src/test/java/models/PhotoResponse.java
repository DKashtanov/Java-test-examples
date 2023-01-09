package models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PhotoResponse {

    @SerializedName("response")
    private ArrayList<PhotoData> response;

    public ArrayList<PhotoData> getResponse() {
        return response;
    }

    public void setResponse(ArrayList<PhotoData> response) {
        this.response = response;
    }
}
