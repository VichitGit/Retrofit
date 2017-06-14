package developer.vichit.android.com.retrofit.interfacce_generator;

import developer.vichit.android.com.retrofit.Model.ArticelRespone;
import retrofit2.Call;
import retrofit2.http.GET;


public interface PostArticelService {

    @GET("v1/api/articles")
    Call<ArticelRespone> findAllArticel();

}

