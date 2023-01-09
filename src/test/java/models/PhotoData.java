package models;

import com.google.gson.annotations.SerializedName;

public class PhotoData {

    @SerializedName("album_id")
    private Integer albumId;
    @SerializedName("date")
    private Integer date;
    @SerializedName("id")
    private Integer id;
    @SerializedName("owner_id")
    private Integer ownerId;

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }
}