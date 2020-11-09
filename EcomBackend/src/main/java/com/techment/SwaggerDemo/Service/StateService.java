package com.techment.SwaggerDemo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techment.SwaggerDemo.POJO.City;
import com.techment.SwaggerDemo.POJO.Country;
import com.techment.SwaggerDemo.POJO.State;
import com.techment.SwaggerDemo.Repository.CityRepository;
import com.techment.SwaggerDemo.Repository.StateRepository;

@Service
public class StateService {
	 private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);  
	
	@Autowired
	public StateRepository stateRepository;
	
	@Autowired
	public CityRepository cityRepository;
	   
	//create state
    public Optional<State> addState(String stateName, List<String> cities) {
        LOGGER.info("User attempting to add a state");
        Optional<State> state = Optional.empty();
        if(!stateRepository.findByStateNameIgnoreCaseContaining(stateName).isPresent()) {
            ArrayList<City> citiesOb = new ArrayList<>();

            for(String city : cities) {
                citiesOb.add(cityRepository.findByCityName(city).orElseThrow(() ->
                        new NoSuchElementException("City does not exist " + city)));
            }
            state = Optional.of(stateRepository.save(new State(stateName, citiesOb)));
        }
        return state;
    }

    
    public State findStateById(long stateId) {
        LOGGER.info("User attempting to find a state by id");
        return verifyState(stateId);
    }



    private State verifyState(long stateId) throws NoSuchElementException {
        LOGGER.info("Verifying state");
        return stateRepository.findById(stateId).orElseThrow(() ->
                new NoSuchElementException("State does not exist " + stateId)
        );
    }
	   
//	   //find by id 
//	   public Optional<State> findStateById(Long id){
//		 return  stateRepository.findById(id);
//	   }
	   
	//state listing
    public List<State> getAllStates() {
        return stateRepository.findAll();
    }
    
    //delete by id
    public void deleteById(Long id) {
    	stateRepository.deleteById(id);
    }
}
