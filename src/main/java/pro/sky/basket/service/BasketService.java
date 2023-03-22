package pro.sky.basket.service;

import pro.sky.basket.model.Basket;

import java.util.List;

public interface BasketService {
     List<Basket> add(List<Integer> ids);
     List<Basket> getAll();
}
