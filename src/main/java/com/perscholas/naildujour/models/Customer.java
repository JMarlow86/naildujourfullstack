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
@Table(name = "customer")
@Entity

public class Customer {

    @Id @NonNull
    int phone;
    @NonNull
    String name;
    @NonNull
    String email;
    @NonNull
    String pronoun;
    @NonNull
    String beverage;
    @NonNull
    String polishToes;
    @NonNull
    String polishFingers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return phone == customer.phone && name.equals(customer.name) && email.equals(customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phone, name, email);
    }

    //one to many customers to service menus


}




