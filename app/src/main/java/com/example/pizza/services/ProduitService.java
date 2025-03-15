package com.example.pizza.services;

import com.example.pizza.classes.Produit;
import com.example.pizza.dao.IDAO;

import java.util.ArrayList;
import java.util.List;

public class ProduitService implements IDAO<Produit> {

    private List<Produit> produits;

    public ProduitService() {
        this.produits = new ArrayList<>();
    }

    @Override
    public boolean create(Produit obj) {
        return produits.add(obj);
    }

    @Override
    public boolean delete(Produit obj) {
        return produits.remove(obj);
    }

    @Override
    public boolean update(Produit obj) {
        if(findById(obj.getId()) != null){
            obj.setNom(obj.getNom());
            obj.setDescription(obj.getDescription());
            obj.setDuree(obj.getDuree());
            obj.setPhoto(obj.getPhoto());
            obj.setDetailsIngred(obj.getDetailsIngred());
            obj.setNbrIngredients(obj.getNbrIngredients());
            obj.setPreparation(obj.getPreparation());
            return true;
        }else
            return false;
    }

    @Override
    public Produit findById(int id) {
        for(Produit produit : produits){
            if(produit.getId() == id)
                return produit;
        }
        return null;
    }

    @Override
    public List<Produit> findAll() {
        return produits;
    }
}
