package pro.sky.basket.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import pro.sky.basket.exception.BasketException;
import pro.sky.basket.model.Basket;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
//делаем скоуп через контекстВеба, что позволяет нам юзать многопоточность браузеров и разных устройств
@Scope(WebApplicationContext.SCOPE_SESSION)
public class BasketServiceImpl implements BasketService {
    private final List<Basket> basket = new ArrayList<>();

// делаем метод add который принимает айди и добавляет его в наш лист
    public List<Basket> add(List<Integer> ids) {
        // по стримам - проходим мапой с добавлением новых айди и записываем в наш лист
        List<Basket> newBasket = ids.stream()
                .map(Basket::new)
                .collect(Collectors.toList());
        // проверка на имеющий продукт (нужна подсказка не работает код)
        if (newBasket.contains(newBasket)) {
            throw new BasketException("Такой продукт уже есть");
        } else
        //добавляем в корзину новые айтемы
        basket.addAll(newBasket);
        return newBasket;

    }
// создаем метод гетолл, который возвращает все наши баскеты в листе Баскет
    public List<Basket> getAll() {
        return basket;
    }
}
