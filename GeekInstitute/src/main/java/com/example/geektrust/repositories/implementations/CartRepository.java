package com.example.geektrust.repositories.implementations;

import java.util.List;
import java.util.Optional;

import com.example.geektrust.entities.Cart;
import com.example.geektrust.repositories.ICartRepository;

public class CartRepository implements ICartRepository{
    private Cart cart;

    public CartRepository() {
        cart = new Cart();
    }

    @Override
    public Cart save(Cart entity) {
        cart = entity;
        return entity;
    }

    @Override
    public Cart getCart(){
        return cart;
    }
    
    @Override
    public List<Cart> findAll() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<Cart> findById(String Id) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
    
}
