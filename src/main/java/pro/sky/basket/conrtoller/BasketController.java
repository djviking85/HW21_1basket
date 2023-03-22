package pro.sky.basket.conrtoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.basket.model.Basket;
import pro.sky.basket.service.BasketService;

import java.util.List;

@RestController
@RequestMapping("/order")

public class BasketController {
    private final BasketService basketService;

    // инжектим сервис
    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }
// гет мап на добавление по id? и по get?
    @GetMapping("/add")
    public Basket add(@RequestParam("id") Integer basketId) {
        return  basketService.add(basketId);
    }
    @GetMapping("/get")
    public List<Basket> get() {
        return  basketService.getAll();
    }
}
