package com.techment.SwaggerDemo.Repository;

import java.util.ArrayList;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.techment.SwaggerDemo.POJO.Address;
import com.techment.SwaggerDemo.POJO.Country;
import com.techment.SwaggerDemo.POJO.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
	Optional<State> findByStateNameIgnoreCaseContaining(String stateName);

	
	





@NotNull(message = "state not be null")
	State findByStateNameIgnoreCaseContaining(Optional<State> state);






Optional<Address> findByStateNameIgnoreCaseContaining(State state);





	

}
