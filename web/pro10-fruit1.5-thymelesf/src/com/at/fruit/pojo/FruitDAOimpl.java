package com.at.fruit.pojo;

import java.util.List;

public class FruitDAOimpl extends BaseDAO<Fruit> implements FruitDAO{

    @Override
    public List<Fruit> getFruitless() {
        return super.executeQuery("select * from t_fruit");
    }
}
