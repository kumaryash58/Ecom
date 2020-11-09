package com.techment.SwaggerDemo.Controller;

import java.util.List;



public class CountryDto {
	
         private String countryName;
         private List<String> states;
 
         
       
		protected CountryDto() {}
         
       

		public CountryDto(String countryName, List<String> states) {
		    this.countryName = countryName;
			this.states = states;
		}



		public String getCountryName() {
			return countryName;
		}

	
           public List<String> getStates() {
			return states;
		}

	

		

	
         
 
}
