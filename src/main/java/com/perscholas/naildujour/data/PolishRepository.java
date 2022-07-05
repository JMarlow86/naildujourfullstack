package com.perscholas.naildujour.data;

import com.perscholas.naildujour.models.Polish;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface PolishRepository extends JpaRepository<Polish, Integer> {

    Polish findPolishByPolishName(String polishName);

    List<Polish> findAll();

    Polish findPolishByPolishId(int id);

    void deletePolishByPolishId(int polishId);
}
