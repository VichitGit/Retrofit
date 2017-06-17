package developer.vichit.android.com.retrofit.form;

import com.google.gson.annotations.SerializedName;

/**
 * Created by VichitDeveloper on 6/17/17.
 */

public class UpdateArticleForm {

    @SerializedName("TITLE")
    private String title;
    @SerializedName("DESCRIPTION")
    private String description;
    @SerializedName("AUTHOR")
    private int authorId;
    @SerializedName("CATEGORY_ID")
    private int categoryId;
    @SerializedName("STATUS")
    private String status;
    @SerializedName("IMAGE")
    private String imageUrl;

    public UpdateArticleForm(String title, String description, int authorId, int categoryId, String status, String imageUrl) {
        this.title = title;
        this.description = description;
        this.authorId = authorId;
        this.categoryId = categoryId;
        this.status = status;
        this.imageUrl = imageUrl;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

