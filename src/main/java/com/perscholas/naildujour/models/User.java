package com.perscholas.naildujour.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Objects;

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

public class User {

    @Id @NonNull
    String email;
    @NonNull
    Role role;
    @NonNull
    String phone;

    @NonNull
    String name;

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
        User customer = (User) o;
        return phone == customer.phone && name.equals(customer.name) && email.equals(customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phone, name, email);
    }

    //one to many customers to service menus


}




