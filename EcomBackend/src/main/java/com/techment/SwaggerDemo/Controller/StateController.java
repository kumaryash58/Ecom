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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

import com.techment.SwaggerDemo.POJO.Country;
import com.techment.SwaggerDemo.POJO.State;
import com.techment.SwaggerDemo.Service.StateService;

@RestController
@RequestMapping("/state")
public class StateController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StateController.class);
	
	@Autowired
	private StateService stateService;
	
	
	  @PostMapping("/add")
	    public State addNewState(@RequestBody StateDto stateDto) {
	        LOGGER.info("POST /states/add");
	        return stateService.addState(stateDto.getStateName(), stateDto.getCities()).orElseThrow(() -> new HttpServerErrorException(HttpStatus.BAD_REQUEST,"State already exists"));
	    }
	
    @GetMapping("/all_state")
    public List<State> getAllStates(){
    	 LOGGER.info("User Attempting to fetch all states");
        return stateService.getAllStates();
    }
    
    @DeleteMapping("delete/{id}")
    public ResponseEntity<State> delete(Long id){
    	 LOGGER.info("User Attempting to delete state");
    	stateService.deleteById(id);
    	return ResponseEntity.ok().build();
    }
    
    
    @GetMapping("/{id}")
    public State findStateById(@PathVariable("id") long stateId) {
        LOGGER.info("GET /cities/{id}");
        return stateService.findStateById(stateId);
    }
//    @GetMapping("/{id}")
//    public ResponseEntity<State> findById(@PathVariable Long id){
//    	 LOGGER.info("User Attempting to fetch state by id");
// 	   Optional<State> state = stateService.findById(id);
// 	   return ResponseEntity.ok(state.get());
// 	   
//    }
    
    
    
    

}
