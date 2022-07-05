package com.perscholas.naildujour.models;


import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import javax.persistence.*;
import java.util.Objects;


@NoArgsConstructor
@Getter
@Setter
@Slf4j
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "beverage")
@Entity


public class Beverage {

    @NonNull
    @Id
    @Column
    String name;

    @NonNull @Column
    String type;


    public Beverage(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beverage beverage = (Beverage) o;
        return name.equals(beverage.name) && type.equals(beverage.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }
}
