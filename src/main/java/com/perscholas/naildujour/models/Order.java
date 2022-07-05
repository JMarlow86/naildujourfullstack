package com.perscholas.naildujour.models;


import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
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

    @Column
    String userEmail;

    @Column
    String beverageName;

    @Column
    int polishId;




    public Order (int orderId, String userEmail, String beverageName, int polishId){
        this.orderId = orderId;
        this.userEmail = userEmail;
        this.beverageName = beverageName;
        this.polishId = polishId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId && polishId == order.polishId && Objects.equals(userEmail, order.userEmail) && Objects.equals(beverageName, order.beverageName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, userEmail, beverageName, polishId);
    }
}
