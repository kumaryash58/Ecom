package com.techment.SwaggerDemo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.techment.SwaggerDemo.POJO.Address;
import com.techment.SwaggerDemo.POJO.City;
import com.techment.SwaggerDemo.POJO.State;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{
      Optional<City> findByCityName(String cityName);

      
      
	Optional<Address> findByCityName(Optional<City> city);


	Optional<Address> findByCityName(State state);
}
