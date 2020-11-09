package com.techment.SwaggerDemo.Repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.techment.SwaggerDemo.POJO.Address;
import com.techment.SwaggerDemo.POJO.City;
import com.techment.SwaggerDemo.POJO.Country;
import com.techment.SwaggerDemo.POJO.State;

@RepositoryRestResource(exported = false)
public interface AddressRepository extends JpaRepository<Address, Long>{
	   //Optional<Address> findByZipCode(String zipCode);
	   
	    Page<Address> findByCountry(Country country, Pageable pageable);
	    Page<Address> findByState(State state, Pageable pageable);
	    Page<Address> findByCity(City city, Pageable pageable);

		Optional<Address> findByZipCode(String zipCode);
	    

}
