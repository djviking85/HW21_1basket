package pro.sky.basket.service;

import pro.sky.basket.model.Basket;

import java.util.List;

public interface BasketService {
     void add(Integer id);
     List<Basket> getAll();
}
