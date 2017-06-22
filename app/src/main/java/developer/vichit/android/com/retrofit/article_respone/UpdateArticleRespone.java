package developer.vichit.android.com.retrofit.article_respone;

import com.google.gson.annotations.SerializedName;

/**
 * Created by VichitDeveloper on 6/17/17.
 */

public class UpdateArticleRespone {
    @SerializedName("CODE")
    private String code;
    @SerializedName("MESSAGE")
    private String message;
    @SerializedName("DATA")
    private ArticelRespone.Articel article;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArticelRespone.Articel getArticle() {
        return article;
    }

    public void setArticle(ArticelRespone.Articel article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "UpdateArticleResponse{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", article=" + article +
                '}';
    }


}
