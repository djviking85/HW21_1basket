package pro.sky.basket.service;

import org.springframework.stereotype.Service;
import pro.sky.basket.model.Basket;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BasketServiceImpl implements BasketService {
    private final List<Basket> basket = new ArrayList<>();

// делаем метод add который принимает айди и добавляет его в наш лист
    public List<Basket> add(List<Integer> ids) {
        // по стримам - проходим мапой с добавлением новых айди и записываем в наш лист
        List<Basket> newBasket = ids.stream()
                .map(Basket::new)
                .collect(Collectors.toList());
        //добавляем в корзину новые айтемы
        basket.addAll(newBasket);

        return newBasket;
    }
// создаем метод гетолл, который возвращает все наши баскеты в листе Баскет
    public List<Basket> getAll() {
        return basket;
    }
}
