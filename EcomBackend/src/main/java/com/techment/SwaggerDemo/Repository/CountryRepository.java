package com.techment.SwaggerDemo.Repository;


import java.sql.Timestamp;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.techment.SwaggerDemo.POJO.Address;
import com.techment.SwaggerDemo.POJO.Country;
import com.techment.SwaggerDemo.POJO.State;

@Repository
@RepositoryRestResource(exported = false)
public interface CountryRepository extends JpaRepository<Country, Long> {

	Optional<Country> findByCountryNameIgnoreCaseContaining(String countryName);
    Page<Country> findByCreatedAt(Timestamp createdAt, Pageable pageable);
    
    
	Optional<Address> findByCountryNameIgnoreCaseContaining(Country country);
	Optional<Address> findCountryById(long country);
	
	
	
	//@NotNull(message = "country not be null")
	//Country findByCountryNameIgnoreCaseContaining(Optional<Country> country);

}
