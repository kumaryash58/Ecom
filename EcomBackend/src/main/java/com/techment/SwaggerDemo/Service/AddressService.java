package com.techment.SwaggerDemo.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import java.util.List;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.techment.SwaggerDemo.POJO.Address;

import com.techment.SwaggerDemo.Repository.AddressRepository;

import com.techment.SwaggerDemo.Security.JwtProvider;


@Service
public class AddressService {
	 private static final Logger LOGGER = LoggerFactory.getLogger(AddressService.class);
	@Autowired
	private AddressRepository addressRepository;
	
//	@Autowired
//	private CountryRepository countryRepository;
//	@Autowired
//	private StateRepository stateRepository;
//	@Autowired
//	private CityRepository cityRepository;
	
    @Autowired
    private CountryService countryService;
    
    @Autowired
    private StateService stateService;
    
    @Autowired
    private CityService cityService;
	
	@Autowired
	private JwtProvider jwtProvider;
	
	@Autowired
	private UserService userService;
	
	       //create.................. 
		public Optional<Address> addAddress(String addressLine1, String addressLine2, String zipCode, long country, long states, long city, String token) {
			LOGGER.info("User attempting to add Address name");
			Optional<Address> address = Optional.empty();
							  
			if(!addressRepository.findByZipCode(zipCode).isPresent()) {
			//ArrayList<State> statesList = new ArrayList<>();
			
				address = Optional.of(addressRepository.save( new Address(addressLine1, addressLine2, zipCode, 
				countryService.findCountryById(country),
				stateService.findStateById(states), 
				cityService.findCityById(city),
				Timestamp.valueOf(LocalDateTime.now()), 
				jwtProvider.getUsername(userService.filterToken(token)))));

        
        }
        return address;
    }
//	
	
//	//save address
//		public Address save(Address address) {
//			return addressRepository.save(address);
//		}
		
		//address listing
		public List<Address> getAllAddresses(){
		   LOGGER.info("User attempting to retrieve all countries");
		return addressRepository.findAll();
	}
		
		
		
		//find by id
		public Optional<Address> findById(Long id){
			return addressRepository.findById(id);
		}
		
		//delete by id 
	    public void deleteById(Long id){
	         addressRepository.deleteById(id);
		}
	    
	

	
	

	

	
}
