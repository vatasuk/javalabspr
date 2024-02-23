package com.example.javalabspr;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table
public class City {
    @Id
    private long id;
    private int pop;
    private String name;

    public City() {

    }
}