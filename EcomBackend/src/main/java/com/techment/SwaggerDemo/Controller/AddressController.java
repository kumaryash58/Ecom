package com.techment.SwaggerDemo.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

import com.techment.SwaggerDemo.POJO.Address;
import com.techment.SwaggerDemo.POJO.Country;
import com.techment.SwaggerDemo.Service.AddressService;

@RestController
@RequestMapping("api/address")
public class AddressController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CityController.class);
	
	@Autowired
	private AddressService addressService;
	
	
	
	 @PostMapping("/add")
	    public Address createNewAddress(@RequestBody AddressDto addressDto, @RequestHeader(value = "Authorization") String token) {
	        LOGGER.info("POST /address/add");
	        return addressService.addAddress(addressDto.getAddressLine1(),
	                                                addressDto.getAddressLine2(),
	                                                addressDto.getZipCode(),
	                                                addressDto.getCountryId(),
	                                                addressDto.getStateId(),
	                                                addressDto.getCityId(),token).orElseThrow(() -> new HttpServerErrorException(HttpStatus.BAD_REQUEST,"Country already exists"));
	    }
	 
	 @GetMapping("/all_address")
	 public List<Address> getAllAddress(Address address){
		 LOGGER.info("Get api/address/all_address");
		 return addressService.getAllAddresses();
	 }
	 
	 @GetMapping("/{id}")
	 public Optional<Address> findAddressById(@PathVariable("id") long addressId) {
		 LOGGER.info("Get api/address/{id}");
		 return addressService.findById(addressId);
	 }
	 
	 @DeleteMapping("delete/{id}")
	   public ResponseEntity<Address> delete(@PathVariable Long id){
		   LOGGER.info("User Attempting to delete Address");
		   addressService.deleteById(id);
		return ResponseEntity.ok().build();
	   }
	 
	 
	 
//	@PostMapping("/add_address")
//	public ResponseEntity create(@Valid @RequestBody Address address) {
//		 LOGGER.info("User Attempting to add address");
//		return ResponseEntity.ok(addressService.save(address));
//	}
	

}
