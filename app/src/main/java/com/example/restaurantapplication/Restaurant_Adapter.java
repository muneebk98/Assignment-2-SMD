package com.example.restaurantapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class Restaurant_Adapter extends RecyclerView.Adapter<Restaurant_Adapter.ViewHolder> implements Filterable {

    ArrayList<Restaurant> restaurants;
    ArrayList<Restaurant> restaurantsFull;

    public Restaurant_Adapter(Context context, ArrayList<Restaurant> list){
        restaurants = list;
        restaurantsFull = new ArrayList<>(list);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView rating, Name, location, phone, desc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rating = itemView.findViewById(R.id.rating);
            Name = itemView.findViewById(R.id.Name);
            location = itemView.findViewById(R.id.location);
            phone = itemView.findViewById(R.id.phone);
            desc = itemView.findViewById(R.id.desc);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_restaurant, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Restaurant restaurant = restaurants.get(position);
        holder.rating.setText(String.valueOf(restaurant.getRating()));
        holder.desc.setText(restaurant.getDescription());
        holder.Name.setText(restaurant.getName());
        holder.location.setText(restaurant.getLocation());
        holder.phone.setText(restaurant.getPhone());
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    @Override
    public Filter getFilter() {
        return restaurantFilter;
    }

    private Filter restaurantFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Restaurant> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(restaurantsFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Restaurant item : restaurantsFull) {
                    if (item.getName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            restaurants.clear();
            restaurants.addAll((List<Restaurant>) results.values);
            restaurants.sort(Comparator.comparingInt(Restaurant::getRating).reversed());
            notifyDataSetChanged();
        }
    };
}
