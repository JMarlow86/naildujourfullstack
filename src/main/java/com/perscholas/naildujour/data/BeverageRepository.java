package com.perscholas.naildujour.data;

import com.perscholas.naildujour.models.Beverage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BeverageRepository extends JpaRepository<Beverage, Integer> {

 Beverage findBeverageByName(String name);

 List<Beverage> findBeverageByType(String type);
 List<Beverage> findAll();
 void deleteBeverageByName(String name);
}
