package pro.sky.basket.service;

import org.springframework.stereotype.Service;
import pro.sky.basket.model.Basket;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasketServiceImpl implements BasketService {
    private List<Basket> basket = new ArrayList<>();

// делаем метод add который принимает айди и добавляет его в наш лист
    public void add(Integer id) {
        Basket newBasket = new Basket(id);
        basket.add(newBasket);

    }
// создаем метод гетолл, который возвращает все наши баскеты в листе Баскет
    public List<Basket> getAll() {
        return basket;
    }
}
