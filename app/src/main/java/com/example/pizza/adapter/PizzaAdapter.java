package com.example.pizza.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pizza.R;
import com.example.pizza.classes.Produit;

import java.util.List;

public class PizzaAdapter extends BaseAdapter {
    private List<Produit> produits;
    private LayoutInflater inflater;

    public PizzaAdapter(Activity activity, List<Produit> produits) {
        this.produits = produits;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return produits.size();
    }

    @Override
    public Object getItem(int position) {
        return produits.get(position);
    }

    @Override
    public long getItemId(int position) {
        return produits.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = inflater.inflate(R.layout.activity_produit, null);

        TextView id = convertView.findViewById(R.id.id);
        TextView duree = convertView.findViewById(R.id.duree);
        TextView nomProduit = convertView.findViewById(R.id.nomProduit);
        TextView nbrIngridients = convertView.findViewById(R.id.nbrIngredients);
        ImageView image = convertView.findViewById(R.id.imageProduit);

        id.setText(produits.get(position).getId()+"");
        nomProduit.setText(produits.get(position).getNom());
        duree.setText(produits.get(position).getDuree()+"");
        image.setImageResource(produits.get(position).getPhoto());
        nbrIngridients.setText(produits.get(position).getNbrIngredients()+"");

        return convertView;
    }
}
