package com.perscholas.naildujour.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.HashSet;


@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Slf4j
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="NAIL_USER")
@Entity
public class User {

    @Id @NonNull  @Column
    String email;

     @Column
    String name;

     @Column
    String phone;

     @Column
    String role;

     @Column
    String pronoun;

    @OneToMany
    @Column
    Set<Order> orders;




    public User(String email, String name, String phone, String role, String pronoun){
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.role = role;
        this.pronoun = pronoun;
        this.orders = new HashSet<Order>();
    }


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




