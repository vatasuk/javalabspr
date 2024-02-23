package com.example.javalabspr;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table
public class Park {
    @Id
    private long id;
    int cityID, S;
    String name,date,water,type;
    private City city;
    public Park() {

    }
}
