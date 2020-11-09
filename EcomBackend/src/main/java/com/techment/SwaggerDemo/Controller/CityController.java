package com.techment.SwaggerDemo.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techment.SwaggerDemo.POJO.City;
import com.techment.SwaggerDemo.Service.CityService;


@RestController
@RequestMapping("/city")
public class CityController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CityController.class);
	@Autowired
	private CityService cityService;
	
	
	@PostMapping("/add_city")
	public ResponseEntity create(@Valid @RequestBody City city) {
		 LOGGER.info("User Attempting to add city");
		return ResponseEntity.ok(cityService.save(city));
	}
	
	@GetMapping("/cities")
	public List<City> findAllCities(){
		 LOGGER.info("User Attempting to fetch all city");
		return cityService.getAllCities();
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<City> delete(@PathVariable Long id){
		 LOGGER.info("User Attempting to delete city");
	cityService.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	  @GetMapping("/{id}")
	    public City findCityById(@PathVariable("id") long cityId) {
	        LOGGER.info("GET /cities/{id}");
	        return cityService.findCityById(cityId);
	    }
	
//	@GetMapping("/{id}")
//	public ResponseEntity<City> findById(@PathVariable long id){
//		 LOGGER.info("User Attempting to fetch city by id");
//		Optional<City> city = cityService.findCityById(id));
//				return ResponseEntity.ok(city.get());
//	}
	

}
