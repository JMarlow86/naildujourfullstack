package com.perscholas.naildujour.models;


import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
@Getter
@Setter
@Slf4j
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "beverage")
@Entity




public class Beverage {

    @Id @NonNull
    String name;
    @NonNull
    String type;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "beverage_name")

    private Beverage beverage;

    @OneToMany(mappedBy = "beverage", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Beverage> beverages = new LinkedHashSet<>();

    public Beverage(String name, @NonNull String type) {
        this.name = name;
        this.type = type;
    }

    //Helper Method


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
