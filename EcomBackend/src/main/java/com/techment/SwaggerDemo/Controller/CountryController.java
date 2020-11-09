package com.techment.SwaggerDemo.Controller;


import java.util.List;
import java.util.Optional;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

import com.techment.SwaggerDemo.POJO.Country;

import com.techment.SwaggerDemo.Service.CountryService;

@RestController
@RequestMapping("/api/country")
public class CountryController {

	  private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
	
	@Autowired
	private CountryService countryService;
	
//	@Autowired
//	private CountryDto countryDto;

//	@PostMapping("/add")
//	public String addAddress(@RequestBody List<Country> country) {
//		//countryRepository.saveAll(country);
//		countryService.save(country);
//		return "Saved: "+ country.size();
//	}
	
	
    @PostMapping("/add")
    public Country addNewCountry(@RequestBody CountryDto countryDto, @RequestHeader(value = "Authorization") String token) {  //@RequestHeader(value = "Authorization") 
        LOGGER.info("POST /countries/add");
        return countryService.addCountry(countryDto.getCountryName(), countryDto.getStates(), token).orElseThrow(() -> new HttpServerErrorException(HttpStatus.BAD_REQUEST,"Country already exists"));
    }
	
    
    @GetMapping("/all_country")
    public List<Country> getAllCountries(){
    	LOGGER.info("User Attempting to fetch country");
        return countryService.getAllCountries();
    }
    
    
//   @PatchMapping("/delete/country")
//   public String removeCountry(@PathVariable("countryName") String countryName ) {
//	   LOGGER.info("User Attempting to delete country");
//	   return countryService.removeCountry(countryName);
//   }
	
   
   @DeleteMapping("delete/{id}")
   public ResponseEntity<Country> delete(@PathVariable Long id){
	   LOGGER.info("User Attempting to delete country");
	   countryService.deleteById(id);
	return ResponseEntity.ok().build();
   }
   
   
   @GetMapping("/{id}")
   public Country findCountryById(@PathVariable("id") long countryId) {
       LOGGER.info("GET /cities/{id}");
       return countryService.findCountryById(countryId);
   }
//   @GetMapping("/{id}")
//   public ResponseEntity<Country> findById(@PathVariable Long id){
//	   LOGGER.info("User Attempting to fetch country by id");
//	   Optional<Country> country = countryService.findById(id);
//	   return ResponseEntity.ok(country.get());
//	   
//   }
   
   @PutMapping("update/{id}")
   public Optional<String> updateCountryStatus(@PathVariable Long id) {
	   LOGGER.info("User Attempting to update country by id");
           return countryService.updateCountry(id);

}
//   public ResponseEntity<Country> update(@PathVariable Long id, @Valid @RequestBody Country country){
//	   if(!countryService.findById(id).isPresent()) {
//		   ResponseEntity.badRequest().build();
//	   }
//	 
//	   return ResponseEntity.ok(countryService.save(country));
//   }

}
