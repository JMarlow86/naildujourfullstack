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
@Table(name = "NAIL_ORDER")
@Entity

public class Order {

    @NonNull
    @Id  @GeneratedValue(strategy = GenerationType.AUTO)
    int orderId;

    @NonNull
    String name;

    @NonNull
    String drink;

    @NonNull
    String polish;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "order_polishes",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "polish_id"))
    private Set<Polish> polishes = new LinkedHashSet<>();

    public Order (int orderId, String name, String drink, String polish){
        this.orderId = orderId;
        this.name = name;
        this.drink = drink;
        this.polish = polish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId && name.equals(order.name) && drink.equals(order.drink) && polish.equals(order.polish) && Objects.equals(polishes, order.polishes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, name, drink, polish, polishes);
    }

}
