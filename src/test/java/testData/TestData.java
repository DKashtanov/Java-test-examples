package testData;

import com.google.gson.annotations.SerializedName;

public class TestData {

    @SerializedName("messageLength")
    private String messageLength;
    @SerializedName("author")
    private String author;
    @SerializedName("imagePath")
    private String imagePath;
    @SerializedName("firstLikeIndex")
    private String firstLikeIndex;
    @SerializedName("imageToComparePath")
    private String imageToComparePath;
    @SerializedName("imageToCompareName")
    private String imageToCompareName;
    @SerializedName("imagesDifferencePercentage")
    private String imagesDifferencePercentage;
    @SerializedName("differenceBetweenPostIdAndCommentId")
    private Integer differenceBetweenPostIdAndCommentId;
    @SerializedName("robotDelayBefore")
    private Integer robotDelayBefore;
    @SerializedName("robotDelayWindow")
    private Integer robotDelayWindow;
    @SerializedName("robotDelayAfter")
    private Integer robotDelayAfter;
    @SerializedName("robotDelayBetweenTabs")
    private Integer robotDelayBetweenTabs;
    @SerializedName("pathToFolderSrc")
    private String pathToFolderSrc;
    @SerializedName("pathToFolderTest")
    private String pathToFolderTest;
    @SerializedName("pathToFolderResources")
    private String pathToFolderResources;
    @SerializedName("dataTimeFormat")
    private String dataTimeFormat;
    @SerializedName("tabCount")
    private Integer tabCount;
    @SerializedName("defaultTabsCount")
    private Integer defaultTabsCount;

    public String getMessageLength() {
        return messageLength;
    }

    public String getAuthor() {
        return author;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getFirstLikeIndex() {
        return firstLikeIndex;
    }

    public String getImageToComparePath() {
        return imageToComparePath;
    }

    public String getImageToCompareName() {
        return imageToCompareName;
    }

    public String getImagesDifferencePercentage() {
        return imagesDifferencePercentage;
    }

    public Integer getDifferenceBetweenPostIdAndCommentId() {
        return differenceBetweenPostIdAndCommentId;
    }

    public Integer getRobotDelayBefore() {
        return robotDelayBefore;
    }

    public Integer getRobotDelayWindow() {
        return robotDelayWindow;
    }

    public Integer getRobotDelayAfter() {
        return robotDelayAfter;
    }

    public Integer getRobotDelayBetweenTabs() {
        return robotDelayBetweenTabs;
    }

    public String getPathToFolderSrc() {
        return pathToFolderSrc;
    }

    public String getPathToFolderTest() {
        return pathToFolderTest;
    }

    public String getPathToFolderResources() {
        return pathToFolderResources;
    }

    public String getDataTimeFormat() {
        return dataTimeFormat;
    }

    public Integer getTabCount() {
        return tabCount;
    }

    public Integer getDefaultTabsCount() {
        return defaultTabsCount;
    }
}
