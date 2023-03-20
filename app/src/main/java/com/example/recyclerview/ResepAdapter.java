package com.example.recyclerview;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ResepAdapter extends RecyclerView.Adapter<ResepAdapter.ViewHolder> {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvFoodName;
        private final TextView tvFoodDescription;
        private final ImageView imgFoodImage;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            tvFoodName = view.findViewById(R.id.food_name);
            tvFoodDescription = view.findViewById(R.id.food_description);
            imgFoodImage= view.findViewById(R.id.food_image);

        }
    }
    private ArrayList<Resep> localDataSet;
    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public ResepAdapter(ArrayList<Resep> dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        String name = localDataSet.get(position).getName();
        String description = localDataSet.get(position).getDescription();
        int image =localDataSet.get(position).getPoster();

        viewHolder.tvFoodName.setText(name);
        viewHolder.tvFoodDescription.setText(description);
        viewHolder.imgFoodImage.setImageResource(image);
        
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(viewHolder.itemView.getContext(), DetailActivity.class);

                intent.putExtra("title",name);
                intent.putExtra("description",description);
                intent.putExtra("poster",image);

                viewHolder.itemView.getContext().startActivity(intent);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}