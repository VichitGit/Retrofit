package developer.vichit.android.com.retrofit.event;

import developer.vichit.android.com.retrofit.Model.ArticelRespone;

/**
 * Created by VichitDeveloper on 6/17/17.
 */

public class ArticleUpdateEvent {

    private ArticelRespone.Articel articel;

    public ArticleUpdateEvent(ArticelRespone.Articel articel) {
        this.articel = articel;
    }

    public ArticelRespone.Articel getArticle() {
        return articel;
    }

    public void setArticle(ArticelRespone.Articel article) {
        this.articel = article;
    }



}
