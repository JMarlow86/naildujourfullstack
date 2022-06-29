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
@Table(name="NAIL_USER")
@Entity

public class User {

    @Id @NonNull
    String email;

    @NonNull
    String name;

    @NonNull
    String phone;

    @NonNull
    String role;

    @NonNull
    String pronoun;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @NonNull
    Order order;




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




}




