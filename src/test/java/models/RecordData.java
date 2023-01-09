package models;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class RecordData {

    @SerializedName("post_id")
    private Integer postId;
    @SerializedName("upload_url")
    private String uploadUrl;
    @SerializedName("items")
    private List<Integer> items;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getUploadUrl() {
        return uploadUrl;
    }

    public void setUploadUrl(String uploadUrl) {
        this.uploadUrl = uploadUrl;
    }

    public List<Integer> getItems() {
        return items;
    }

    public void setItems(List<Integer> items) {
        this.items = items;
    }
}