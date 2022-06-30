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
@Table(name = "NAIL_ORDER")
@SecondaryTable(name="user_orders",pkJoinColumns = @PrimaryKeyJoinColumn(name="orderId"))
@Entity
public class Order {

    @NonNull
    @Column
    @PrimaryKeyJoinColumn
    @Id  @GeneratedValue(strategy = GenerationType.AUTO)
    int orderId;

    @OneToOne
    User user;

    @NonNull @ManyToOne
    Beverage beverage;

    @NonNull @ManyToOne
    Polish polish;




    public Order (int orderId, User user, Beverage beverage, Polish polish){
        this.orderId = orderId;
        this.user = user;
        this.beverage = beverage;
        this.polish = polish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId && user.equals(order.user) && beverage.equals(order.beverage) && polish.equals(order.polish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, user, beverage, polish);
    }
}
