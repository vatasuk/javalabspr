package com.example.javalabspr.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
public class Park {
    private int id;
    int cityid;
    @NotNull
    @Size(min = 5,message = "Название 5 символов")
    String parkname;
    @NotNull
    String parkdate;
    @NotNull
    String water;
    @NotNull
    String parktype;
    @NotNull
    String pl;
    public Park() {

    }

}
