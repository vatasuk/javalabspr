package com.example.javalabspr.Entity;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Data
@Table
public class City {
    @Id
    private int id;
    @NotNull(message = "Пустое поле")
    @Size(min = 5,message = "Название города не может быть меньше 5 символов")
    private String cityname;
    @NotNull(message = "Пустое поле")
    @Size(min = 3,message = "Мало")
    private String pop;

    public City()
    {

    }
}