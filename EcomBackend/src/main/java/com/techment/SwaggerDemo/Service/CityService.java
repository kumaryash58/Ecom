package com.techment.SwaggerDemo.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techment.SwaggerDemo.POJO.City;

import com.techment.SwaggerDemo.Repository.CityRepository;

@Service
public class CityService {
	 private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);
        
	@Autowired
	private CityRepository cityRepository;
	
	//save city
	public City save(City city) {
		return cityRepository.save(city);
	}
	
	//city listing
	public List<City> getAllCities(){
		return cityRepository.findAll();
	}
	
	  
    public City findCityById(long cityId) {
        LOGGER.info("User attempting to remove city by id");
        return verifyCity(cityId);
    }
    
    private City verifyCity(long cityId) throws NoSuchElementException {
        LOGGER.info("Verifying city");
        return cityRepository.findById(cityId).orElseThrow(() ->
                new NoSuchElementException("City does not exist " + cityId)
        );
    }
	
//	//find by id
//	public Optional<City> findCityById(Long id){
//		return cityRepository.findById(id);
//	}
	
	//delete by id 
    public void deleteById(Long id){
         cityRepository.deleteById(id);
	}
    
    
}
