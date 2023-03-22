package pro.sky.basket.model;

public class Basket {
// делаем айди переменную - по которой будем считать
    private Integer id;
    public Basket(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
