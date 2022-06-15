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
@Table(name = "employee")
@Entity

public class Employee {
    @Id @NonNull
    int phone;
    @NonNull
    String name;
    @NonNull
    String pronoun;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return phone == employee.phone && name.equals(employee.name) && pronoun.equals(employee.pronoun);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phone, name, pronoun);
    }
}
 //OnetoOne employee to customer