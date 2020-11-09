//package com.techment.SwaggerDemo.Config;
//
//import java.util.Optional;
//
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.ValidationUtils;
//import org.springframework.validation.Validator;
//
//import com.techment.SwaggerDemo.Form.AddressForm;
//import com.techment.SwaggerDemo.POJO.Address;
//
//import com.techment.SwaggerDemo.Repository.AddressRepository;
//import com.techment.SwaggerDemo.Repository.CityRepository;
//import com.techment.SwaggerDemo.Repository.CountryRepository;
//import com.techment.SwaggerDemo.Repository.StateRepository;
//
//
//@Component
//public class AddressValidator implements Validator {
//
//
// 
//    @Autowired
//    private AddressRepository addressRepository;
//    
//    @Autowired
//    private CountryRepository countryRepository;
//    
//    @Autowired
//    private StateRepository stateRepository;
//    
//    @Autowired
//    private CityRepository cityRepository;
// 
//    // The classes are supported by this validator.
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return clazz == AddressForm.class;
//    }
// 
//    @Override
//    public void validate(Object target, Errors errors) {
//    	AddressForm addressForm = (AddressForm) target;
// 
//        // Check the fields of AppUserForm.
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressLine1", "NotEmpty.addressForm.addressLine1");
////        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressLine2", "NotEmpty.addressForm.addressLine2");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zipCode", "NotEmpty.addressForm.zipCode");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "NotEmpty.addressForm.country");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state", "NotEmpty.addressForm.state");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "NotEmpty.addressForm.city");
//     
// 
//   
// 
//        if (!errors.hasFieldErrors("addressLine1")) {
//            Optional<Address> address = addressRepository.findByZipCode(addressForm.getAddressLine1());
//            if (address != null) {
//      
//                errors.rejectValue("addressLine1", "Duplicate.addressForm.addressLine1");
//            }
//        }
//        
////        if (!errors.hasFieldErrors("addressLine2")) {
////            Optional<Address> address = addressRepository.findByZipCode(addressForm.getAddressLine2());
////            if (address != null) {
////                // Username is not available.
////                errors.rejectValue("addressLine2", "Duplicate.addressForm.addressLine2");
////            }
////        }
//        
//        
//        if (!errors.hasFieldErrors("zipCode")) {
//            Optional<Address> address = addressRepository.findByZipCode(addressForm.getZipCode());
//            if (address != null) {
//            
//                errors.rejectValue("zipCode", "Duplicate.addressForm.zipCode");
//            }
//        }
//        
//        
//        if (!errors.hasFieldErrors("country")) {
//            Optional<Address> address = countryRepository.findByCountryNameIgnoreCaseContaining(addressForm.getCountry());
//            if (address != null) {
//             
//                errors.rejectValue("country", "Duplicate.addressForm.country");
//            }
//        }
//        
//        if (!errors.hasFieldErrors("state")) {
//            Optional<Address> address = stateRepository.findByStateNameIgnoreCaseContaining(addressForm.getState());
//            if (address != null) {
//                // state is not available.
//                errors.rejectValue("state", "Duplicate.addressForm.state");
//            }
//        }
//        
//        if (!errors.hasFieldErrors("city")) {
//            Optional<Address> address = cityRepository.findByCityName(addressForm.getState());
//            if (address != null) {
//                // city is not available.
//                errors.rejectValue("city", "Duplicate.addressForm.city");
//            }
//        }
// 
//     
//    }
//
//}
