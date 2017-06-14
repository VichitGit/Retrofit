package developer.vichit.android.com.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import developer.vichit.android.com.retrofit.Model.ArticelRespone;
import developer.vichit.android.com.retrofit.Model.ServiceGenerator;
import developer.vichit.android.com.retrofit.adapter.CustomAdapter;
import developer.vichit.android.com.retrofit.interfacce_generator.PostArticelService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = (RecyclerView) findViewById(R.id.rvMainActivity);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        customAdapter = new CustomAdapter();
        rv.setAdapter(customAdapter);


//        PostService postService = ServiceGenerator.createService(PostService.class);
//
//        Call<List<PostModel>> call = postService.findAllPosts();
//
//        call.enqueue(new Callback<List<PostModel>>() {
//            @Override
//            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
//
//
//            }
//
//            @Override
//            public void onFailure(Call<List<PostModel>> call, Throwable t) {
//                t.printStackTrace();
//
//            }
//        });

        PostArticelService postArticelService = ServiceGenerator.createService(PostArticelService.class);
        Call<ArticelRespone> call = postArticelService.findAllArticel();

        call.enqueue(new Callback<ArticelRespone>() {
            @Override
            public void onResponse(Call<ArticelRespone> call, Response<ArticelRespone> response) {
                ArticelRespone articelRespone = response.body();

                customAdapter.addMoreItems(articelRespone.getArticellist());

            }

            @Override
            public void onFailure(Call<ArticelRespone> call, Throwable t) {

            }
        });


    }
}
