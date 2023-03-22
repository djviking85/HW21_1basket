package pro.sky.basket.model;

import java.util.Objects;

public class Basket {


    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return Objects.equals(id, basket.id);
    }

}
