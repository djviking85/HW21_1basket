package pro.sky.basket.conrtoller;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import pro.sky.basket.exception.BasketException;
import pro.sky.basket.model.Basket;
import pro.sky.basket.service.BasketService;

import java.util.List;

@RestController
//делаем скоуп через контекстВеба, что позволяет нам юзать многопоточность браузеров и разных устройств
@Scope(WebApplicationContext.SCOPE_SESSION)
@RequestMapping("/order")

public class BasketController {
    private final BasketService basketService;

    // инжектим сервис
    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BasketException.class)
    public String handleException(BasketException e) {
        return String.format("ошибка: %s,  причина: %s", HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }
// гет мап на добавление по id? и по get?
    // они принимают листы корзин
    @GetMapping("/add")
    public List<Basket> add(@RequestParam("id") List<Integer> basketId) {
        return  basketService.add(basketId);
    }
    @GetMapping("/get")
    public List<Basket> get() {
        return  basketService.getAll();
    }
}
