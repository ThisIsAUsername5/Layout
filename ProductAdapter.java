package com.example.layouty;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter
        extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> productList;

    public ProductAdapter(List<Product> productList) {
        this.productList = productList;
    }

    public static class ProductViewHolder
            extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvDescription;
        CardView cardView;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvProductTitle);
            tvDescription = itemView.findViewById(R.id.tvProductDescription);
            cardView = (CardView) itemView;
        }
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);

        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull ProductViewHolder holder, int position) {

        Product product = productList.get(position);

        holder.tvTitle.setText(product.getTitle());
        holder.tvDescription.setText(product.getDescription());

        holder.cardView.setOnClickListener(v -> {

            Toast.makeText(
                    v.getContext(),
                    "Wybrano: " + product.getTitle(),
                    Toast.LENGTH_SHORT
            ).show();

        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
