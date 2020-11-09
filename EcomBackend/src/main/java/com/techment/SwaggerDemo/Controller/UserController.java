package com.techment.SwaggerDemo.Controller;

import com.techment.SwaggerDemo.POJO.User;
import com.techment.SwaggerDemo.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import javax.validation.Valid;
import java.util.List;


@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/users")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
   // @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/json", method = RequestMethod.POST, produces = "application/json")
    @PostMapping("/signin")
    public String login(@RequestBody @Valid UserDto userDto) {
        LOGGER.info("POST /users/signin");
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return userService.signin(userDto.getUsername(), userDto.getPassword()).orElseThrow(()->
                new HttpServerErrorException(HttpStatus.FORBIDDEN, "Login Faile"));
    }

   // @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public User signup(@RequestBody @Valid UserDto userDto){
        LOGGER.info("POST /users/signup");
       String s = userDto.getUsername();
       System.out.println("ttttttt"+s);
        return userService.signup(userDto.getUsername(), userDto.getPassword()
                ).orElseThrow(() -> new HttpServerErrorException(HttpStatus.BAD_REQUEST,"User already exists"));
    }

//    @GetMapping
//    public List<User> getAllUsers() {
//        LOGGER.info("GET /users");
//        return userService.getAll();
//    }
    
 
}
