package developer.vichit.android.com.retrofit.interfacce_generator;

import java.util.List;

import developer.vichit.android.com.retrofit.Model.PostModel;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by VichitDeveloper on 6/13/17.
 */

public interface PostService {

    @GET("posts")
    Call<List<PostModel>> findAllPosts();

    @GET("posts/{id}")
    Call<List<PostModel>> findPostById();


}
