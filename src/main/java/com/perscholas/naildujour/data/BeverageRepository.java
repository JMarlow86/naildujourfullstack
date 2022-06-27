package com.perscholas.naildujour.data;

import com.perscholas.naildujour.models.Beverage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BeverageRepository extends JpaRepository<Beverage, String> {

//    @Query(nativeQuery = true)
//    List<Beverage> findUserBeverage(String drinkName);
//
//    @Query(value = "select * from beverage where type = :alcohol", nativeQuery = true)
//    List <Beverage>findAllAlcohol(String type);
 List<Beverage> findByTypeIgnoreCase(String type);

}
