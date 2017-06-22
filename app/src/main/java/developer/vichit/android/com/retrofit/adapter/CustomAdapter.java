package developer.vichit.android.com.retrofit.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import developer.vichit.android.com.retrofit.article_respone.ArticelRespone;
import developer.vichit.android.com.retrofit.R;
import developer.vichit.android.com.retrofit.interfacce_generator.MyClickListener;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    List<ArticelRespone.Articel> articelList;
    ArticelRespone.Articel articel;
    MyClickListener myClickListener;

    public CustomAdapter() {
        articelList = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_custom_layout,
                parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        articel = articelList.get(position);

        holder.tvTitle.setText(articel.getTitle());
        holder.tvDescription.setText(articel.getDescription());
        holder.tvAuthor.setText(articel.getAuthor().getName());
        holder.tvCategory.setText(articel.getCategory().getName());
        holder.tvDate.setText(articel.getCreatedDate());

    }

    @Override
    public int getItemCount() {
        return articelList.size();
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
    public ArticelRespone.Articel getArticel (int position){
        return this.articelList.get(position);
    }

    //loop for refresh RecyclerView
    public void updateItemOf(ArticelRespone.Articel article){

        for (ArticelRespone.Articel temp: this.articelList) {
            if (temp.getId() == article.getId()){
                temp.setTitle(article.getTitle());
                temp.setDescription(article.getDescription());
                int position = this.articelList.indexOf(temp);

                notifyItemChanged(position);
                return;
            }
        }

    }

    //Send Referance by Recyclerview
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        myClickListener = (MyClickListener) recyclerView.getContext();
    }




    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvTitle, tvDescription, tvDate, tvAuthor, tvCategory;
        ImageButton ibMenu;

        public ViewHolder(View itemView) {
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
}

