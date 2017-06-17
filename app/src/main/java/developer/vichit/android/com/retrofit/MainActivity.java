package developer.vichit.android.com.retrofit;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import developer.vichit.android.com.retrofit.Model.ArticelRespone;
import developer.vichit.android.com.retrofit.Model.ServiceGenerator;
import developer.vichit.android.com.retrofit.Model.UpdateArticleRespone;
import developer.vichit.android.com.retrofit.adapter.CustomAdapter;
import developer.vichit.android.com.retrofit.event.ArticleUpdateEvent;
import developer.vichit.android.com.retrofit.form.UpdateArticleForm;
import developer.vichit.android.com.retrofit.interfacce_generator.MyClickListener;
import developer.vichit.android.com.retrofit.interfacce_generator.PostArticelService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements TextWatcher, MyClickListener {
    RecyclerView rv;
    CustomAdapter customAdapter;

    EditText edKeyword;
    PostArticelService postArticelService;
    ArticelRespone.Articel articel;

    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edKeyword = (EditText) findViewById(R.id.edKeyword);

        rv = (RecyclerView) findViewById(R.id.rvMainActivity);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        customAdapter = new CustomAdapter();
        rv.setAdapter(customAdapter);


        //
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {

                loadArticle(edKeyword.getText().toString());
            }
        };

        //Service
        postArticelService = ServiceGenerator.createService(PostArticelService.class);
        loadArticle(edKeyword.getText().toString());
        edKeyword.addTextChangedListener(this);
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable, 1000);
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    //Load Article
    private void loadArticle(String keyword) {

        Call<ArticelRespone> call = postArticelService.findArticelByTitle(keyword);

        call.enqueue(new Callback<ArticelRespone>() {
            @Override
            public void onResponse(Call<ArticelRespone> call, Response<ArticelRespone> response) {

                ArticelRespone articelRespone = response.body();
                customAdapter.clearList();
                customAdapter.addMoreItems(articelRespone.getArticellist());
                Log.e("ooooo", customAdapter.getItemCount() + "");
            }

            @Override
            public void onFailure(Call<ArticelRespone> call, Throwable t) {

            }
        });

    }


    //Popup Update Article
    @Override
    public void onClick(int position, View view) {
        articel = customAdapter.getArticel(position);

        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.inflate(R.menu.my_popmenu);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.popDelete:

                        break;
                    case R.id.popUpdate:
                        DialogFragment fragment = MyDiaLogFragment.newInstance(articel);
                        fragment.show(getSupportFragmentManager(), "MyDialogFragment");
                        break;
                }
                return false;
            }
        });
        popupMenu.show();

    }

    //Start EventBus that declare in DialogFragment
    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    //Stop EventBus that declare in DialogFragment
    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    //Subscriber
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onArticleUpdateEvent(ArticleUpdateEvent event){
        final ArticelRespone.Articel article = event.getArticle();
        UpdateArticleForm form = new UpdateArticleForm(
                article.getTitle(),
                article.getDescription(),
                article.getAuthor().getId(),
                article.getCategory().getId(),
                article.getStatus(),
                article.getImage()
        );

        //Update Article
        Call<UpdateArticleRespone> updateArticle = postArticelService.updateArticle(article.getId(), form);
        updateArticle.enqueue(new Callback<UpdateArticleRespone>() {
            @Override
            public void onResponse(Call<UpdateArticleRespone> call, Response<UpdateArticleRespone> response) {
                customAdapter.updateItemOf(response.body().getArticle());
            }

            @Override
            public void onFailure(Call<UpdateArticleRespone> call, Throwable t) {

            }
        });
    }

}

