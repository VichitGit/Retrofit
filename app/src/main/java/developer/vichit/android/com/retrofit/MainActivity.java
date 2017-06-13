package developer.vichit.android.com.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import developer.vichit.android.com.retrofit.Model.PostModel;
import developer.vichit.android.com.retrofit.Model.ServiceGenerator;
import developer.vichit.android.com.retrofit.interfacce_generator.PostService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PostService postService = ServiceGenerator.createService(PostService.class);

        Call<List<PostModel>> call = postService.findAllPosts();

        call.enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                Log.e("vvvvv", response.body().get(99).getBody());
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                t.printStackTrace();

            }
        });


    }
}
