package com.example.geektrust.repositories;

import com.example.geektrust.entities.Cart;

public interface ICartRepository extends CRUDRepository<Cart,String>{
    public Cart getCart();   
}
