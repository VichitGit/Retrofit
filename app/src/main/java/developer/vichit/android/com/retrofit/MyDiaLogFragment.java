package developer.vichit.android.com.retrofit;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

import developer.vichit.android.com.retrofit.article_respone.ArticelRespone;
import developer.vichit.android.com.retrofit.event.ArticleUpdateEvent;

public class MyDiaLogFragment extends DialogFragment implements View.OnClickListener {
    EditText edTitle, edDescription;
    Button btnUpdate;

    private static final String ARTICLE = "article";
    private ArticelRespone.Articel article;

    public static MyDiaLogFragment newInstance(ArticelRespone.Articel article) {
        MyDiaLogFragment fragment = new MyDiaLogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARTICLE, article);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmen_diaolog_update_article, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        edTitle = (EditText) view.findViewById(R.id.edTitle_Update);
        edDescription = (EditText) view.findViewById(R.id.edDescription_Update);

        btnUpdate = (Button) view.findViewById(R.id.btnUpdate_Update);

        if (getArguments() != null) {
            article = getArguments().getParcelable(ARTICLE);
            edTitle.setText(article.getTitle());
            edDescription.setText(article.getDescription());

        }
        btnUpdate.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        onUpdateClicked();


    }
    //Calling EventBus to send Subsrciber
    protected void onUpdateClicked() {
        article.setTitle(edTitle.getText().toString());
        article.setDescription(edDescription.getText().toString());
        EventBus.getDefault().post(new ArticleUpdateEvent(article));

    }

}


