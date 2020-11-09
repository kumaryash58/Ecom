package com.techment.SwaggerDemo.Service;


import com.techment.SwaggerDemo.POJO.User;
import com.techment.SwaggerDemo.Repository.UserRepository;
import com.techment.SwaggerDemo.Security.JwtProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	    @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private PasswordEncoder passwordEncoder;

	    @Autowired
	    private JwtProvider jwtProvider;

	    /**
	     * Sign in a user into the application, with JWT-enabled authentication
	     *
	     * @param username  username
	     * @param password  password
	     * @return Optional of the Java Web Token, empty otherwise
	     */
	    public Optional<String> signin(String username, String password) {
	        LOGGER.info("User attempting to signin");

	        Optional<String> token = Optional.empty();
	        Optional<User> user = userRepository.findByUsername(username);
	        if (user.isPresent()) {
	            try {
	                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	                token = Optional.of(jwtProvider.createToken(username));
	            } catch (AuthenticationException e){
	                LOGGER.info("Wrong Credentials");
	            }
	        }
	        return token;
	    }

	    /**
	     * Create a new user in the database.
	     *
	     * @param username username
	     * @param password password
	     * @return Optional of user, empty if the user already exists.
	     */
	    public Optional<User> signup(String username, String password) {
	        LOGGER.info("User attempting to signup");

	        Optional<User> user = Optional.empty();
	        if (!userRepository.findByUsername(username).isPresent()) {

	            user = Optional.of(userRepository.save(new User(username,
	                    passwordEncoder.encode(password))));
	        }
	        return user;
	    }

//	    public List<User> getAll() {
//	        LOGGER.info("User attempting to retrieve all users");
//	        return userRepository.findAll();
//	    }
	    
	    public String filterToken(String token) {
	        return token.replace("Bearer", "").trim();
	    }

}
