package developer.vichit.android.com.retrofit.interfacce_generator;

import developer.vichit.android.com.retrofit.article_respone.ArticelRespone;
import developer.vichit.android.com.retrofit.article_respone.UpdateArticleRespone;
import developer.vichit.android.com.retrofit.form_request.UpdateArticleForm;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface PostArticelService {

    @GET("v1/api/articles")
    Call<ArticelRespone> findAllArticel();

    @GET("v1/api/articles")
    Call<ArticelRespone> findArticelByTitle(@Query("title") String title);

    @PUT("v1/api/articles/{id}")
    Call<UpdateArticleRespone> updateArticle(
            @Path("id") int id,
            @Body UpdateArticleForm updateArticleForm
    );



}

