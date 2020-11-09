package com.techment.SwaggerDemo.Service;



import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.techment.SwaggerDemo.POJO.Country;
import com.techment.SwaggerDemo.POJO.State;
import com.techment.SwaggerDemo.Repository.CountryRepository;
import com.techment.SwaggerDemo.Repository.StateRepository;
import com.techment.SwaggerDemo.Security.JwtProvider;



@Service
public class CountryService {
	 private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);
	@Autowired
    private CountryRepository countryRepository;
	
	
	
	@Autowired
	private StateRepository stateRepository;
	
	   @Autowired
	    private JwtProvider jwtProvider;
	   
	   @Autowired
	   private UserService userService;
	
	  //create.................. 
    public Optional<Country> addCountry(String countryName, List<String> states, String token) {
        LOGGER.info("User attempting to add country name");
        Optional<Country> country = Optional.empty();
        if(!countryRepository.findByCountryNameIgnoreCaseContaining(countryName).isPresent()) {
            ArrayList<State> statesList = new ArrayList<>();
           

            for(String state : states) {
                statesList.add(stateRepository.findByStateNameIgnoreCaseContaining(state).orElseThrow(() ->
                        new NoSuchElementException("State does not exist " + state)));
            }
            country = Optional.of(countryRepository.save(new Country(countryName, statesList,Timestamp.valueOf(LocalDateTime.now()), jwtProvider.getUsername(userService.filterToken(token)))));
//            country = Optional.of(countryRepository.save(new Country(
//            		countryName, 
//            	statesList, 
//            		Timestamp.valueOf(LocalDateTime.now()), 
//            		jwtProvider.getUsername(userService.filterToken(token)) )));
        
        }
        return country;
    }
	   
	  //delete.................. 
	   public String removeCountry(String countryName) {
		    LOGGER.info("Country Removing");
		String rtn ="";
		   Optional<Country> countryOptional=countryRepository.findByCountryNameIgnoreCaseContaining(countryName);
		   {
			   Country country = countryOptional.get();
			   //country = countryRepository.delete(countryName);
			   countryRepository.save(country);
			   rtn="{\"status\":\"success\",\"msg\":\"country has been deleted successfully\"}";
		   }
		   return rtn;
	   }
	   
	   //save
	   public Country save(Country country) {
		   return countryRepository.save(country);
	   }
	   
	   //update
	    public Optional<String> updateCountry(Long id) {

	        Optional<String> rtn = Optional.empty();
	        if(countryRepository.existsById(id)) {
            Optional<Country> country = countryRepository.findById(id);
	        countryRepository.save(country.get());
	            rtn = Optional.of("{\"status\":\"success\",\"msg\":\"status has been updated successfully\"}");
	        }
	        else {
	        	 rtn = Optional.of("{\"status\":\"failure\",\"msg\":\"Authorization failed\"}");
	        }
	            return rtn;
	    }
	   
	   
	    public Country findCountryById(long countryId) {
	        LOGGER.info("User attempting to find country by id");
	        return verifyCountry(countryId);
	    }


	    private Country verifyCountry(long countryId) throws NoSuchElementException {
	        LOGGER.info("Verifying Country");
	        return countryRepository.findById(countryId).orElseThrow(() ->
	                new NoSuchElementException("State does not exist " + countryId)
	        );
	    }

	    
//	   //find by id 
//	   public Optional<Country> findCountryById(long id){
//		 return  countryRepository.findById(id);
//	   }
	   
	   //delete by id
	   public void  deleteById(Long id) {
		   countryRepository.deleteById(id);
		   
	   }
	   
	   
		  //List.................. 
	   public List<Country> getAllCountries() {
	        LOGGER.info("User attempting to retrieve all countries");
	        return countryRepository.findAll();
	    }
    
    
    
}
