package developer.vichit.android.com.retrofit.adapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import developer.vichit.android.com.retrofit.R;
import developer.vichit.android.com.retrofit.article_respone.ArticelRespone;
import developer.vichit.android.com.retrofit.event.ArticleLoadMoreEvent;
import developer.vichit.android.com.retrofit.interfacce_generator.MyClickListener;


public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<ArticelRespone.Articel> articelList;
    ArticelRespone.Articel articel;
    MyClickListener myClickListener;

    private static final int VIEW_ITEM = 1;
    private static final int VIEW_PROG = 0;

    private int visibleThreshold = 5;
    private boolean loading = false;


    public CustomAdapter(RecyclerView recyclerView) {
        articelList = new ArrayList<>();

        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);

                    //get position items in LayoutManager
                    int totalItemCount = linearLayoutManager.getItemCount();
                    int lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();

                    if (!loading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                        // End has been reached
                        // Do Something
                        loading = true;
                        //send event bus to other subscriber
                        EventBus.getDefault().post(new ArticleLoadMoreEvent());
                    }


                }
            });

        }
    }

    public void onLoaded() {
        loading = false;
    }

    //if loading
    public boolean isLoading() {
        return loading;
    }

    public int size() {
        return this.articelList.size();

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh = null;

        if (viewType == VIEW_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.item_custom_layout,
                    parent, false);
            vh = new ArticleViewHolder(view);


        } else if (viewType == VIEW_PROG) {
            View view = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.item_custom_progressbar,
                    parent, false);
            vh = new ProgressBarViewHolder(view);

        }

        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        articel = articelList.get(position);

        if (holder instanceof ArticleViewHolder) {
            ArticleViewHolder articleViewHolder = (ArticleViewHolder) holder;

            articleViewHolder.tvTitle.setText(articel.getTitle());
            articleViewHolder.tvDescription.setText(articel.getDescription());
            articleViewHolder.tvAuthor.setText(articel.getAuthor().getName());
            articleViewHolder.tvCategory.setText(articel.getCategory().getName());
            articleViewHolder.tvDate.setText(articel.getCreatedDate());

        } else if (holder instanceof ProgressBarViewHolder) {
            ProgressBarViewHolder progressBarViewHolder = (ProgressBarViewHolder) holder;
            progressBarViewHolder.progressBar.setIndeterminate(true);

        }


    }

    @Override
    public int getItemCount() {
        return articelList.size();
    }

    //View Type of Layout
    @Override
    public int getItemViewType(int position) {
        return (articelList.get(position) != null) ? VIEW_ITEM : VIEW_PROG;
    }

    //Add items to array.
    public void addMoreItems(List<ArticelRespone.Articel> articelList) {
        this.articelList.addAll(articelList);
        notifyDataSetChanged();
    }

    //clear list
    public void clearList() {
        this.articelList.clear();
    }

    //get position Article
    public ArticelRespone.Articel getArticel(int position) {
        return this.articelList.get(position);
    }

    //loop for refresh RecyclerView
    public void updateItemOf(ArticelRespone.Articel article) {

        for (ArticelRespone.Articel temp : this.articelList) {
            if (temp.getId() == article.getId()) {
                temp.setTitle(article.getTitle());
                temp.setDescription(article.getDescription());
                int position = this.articelList.indexOf(temp);

                notifyItemChanged(position);
                return;
            }
        }

    }

    //add progressBar to last position of articleList
    public void addProgressBar() {
        articelList.add(null);
        notifyItemInserted(articelList.size() - 1);
    }

    //Remove progressBar last position of articleList
    public void removeProgressBar() {
        articelList.remove(articelList.size() - 1);
        notifyItemRemoved(articelList.size() - 1);
    }


    //Send Referance by Recyclerview
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        myClickListener = (MyClickListener) recyclerView.getContext();
    }


    public class ArticleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvTitle, tvDescription, tvDate, tvAuthor, tvCategory;
        ImageButton ibMenu;

        public ArticleViewHolder(View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvDescription = (TextView) itemView.findViewById(R.id.tvDescription);
            tvCategory = (TextView) itemView.findViewById(R.id.tvCategory);
            tvAuthor = (TextView) itemView.findViewById(R.id.tvAuthor);
            tvDate = (TextView) itemView.findViewById(R.id.tvDate);
            ibMenu = (ImageButton) itemView.findViewById(R.id.ibMenu);

            ibMenu.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            myClickListener.onClick(getAdapterPosition(), v);

        }
    }

    private class ProgressBarViewHolder extends RecyclerView.ViewHolder {

        ProgressBar progressBar;

        public ProgressBarViewHolder(View itemView) {
            super(itemView);

            progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar);
        }
    }
}

