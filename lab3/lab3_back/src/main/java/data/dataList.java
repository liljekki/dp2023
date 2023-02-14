package data;

import Entity.MyEntity;

import java.util.ArrayList;
import java.util.List;

public class dataList {
    private List<MyEntity> data = new ArrayList<>();

    public dataList() {
        this.data.add(new MyEntity(1,"maracan","good sleeping bag", "assets/img/spalnik.png"));
        this.data.add(new MyEntity(2, "kraken","good spalnik", "assets/img/spalnik2.png"));
        this.data.add(new MyEntity(3, "mudlo","second good spalnik", "assets/img/spalnik3.png"));
    }

    public List<MyEntity> getData() {
        return data;
    }

    public void setData(List<MyEntity> data) {
        this.data = data;
    }
}