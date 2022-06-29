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
@Table(name = "polish")
@Entity

public class Polish {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @NonNull
    String colorName;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polish polish = (Polish) o;
        return id == polish.id && colorName.equals(polish.colorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, colorName);
    }
}

