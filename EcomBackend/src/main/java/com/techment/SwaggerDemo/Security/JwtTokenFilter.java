package com.techment.SwaggerDemo.Security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.filter.GenericFilterBean;



import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Optional;

public class JwtTokenFilter extends GenericFilterBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenFilter.class);
    private static final String BEARER = "Bearer";

    private DemoUserDetailsService userDetailsService;
    public JwtTokenFilter(DemoUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    /**
     * Determine if there is a JWT as part of the HTTP Request Header.
     * If it is valid then set the current context With the Authentication(user and roles) found in the token
     *
     * @param req Servlet Request
     * @param res Servlet Response
     * @param filterChain Filter Chain
     * @throws IOException
     * @throws ServletException
     */
    
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
            throws IOException, ServletException {
        LOGGER.info("Process request to check for a JSON Web Token ");
        //Check for Authorization:Bearer JWT
        String headerValue = ((HttpServletRequest)req).getHeader("Authorization");
        getBearerToken(headerValue).ifPresent(token-> {
            //Pull the Username and Roles from the JWT to construct the user details
        	userDetailsService.loadUserByJwtToken(token).ifPresent(userDetails -> {
                //Add the user details (Permissions) to the Context for just this API invocation
                SecurityContextHolder.getContext().setAuthentication(
                        new PreAuthenticatedAuthenticationToken(userDetails, "", userDetails.getAuthorities()));
            });
        });

        //move on to the next filter in the chains
        filterChain.doFilter(req, res);
    }
    
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
//            throws IOException, ServletException {
//        LOGGER.info("Process request to check for a JSON Web Token ");
//        //Check for Authorization:Bearer JWT
//        String headerValue = ((HttpServletRequest)req).getHeader("Authorization");
//        getBearerToken(headerValue).ifPresent(token-> {
//            //Pull the Username and Roles from the JWT to construct the user details
//            userDetailsService.loadUserByJwtToken(token).ifPresent(userDetails -> {
//                //Add the user details (Permissions) to the Context for just this API invocation
//                SecurityContextHolder.getContext().setAuthentication(
//                        new PreAuthenticatedAuthenticationToken(userDetails, "", userDetails.getAuthorities()));
//            });
//        });
//
//        //move on to the next filter in the chains
//        filterChain.doFilter(req, res);
//    	
////    	 System.out.println("INSIDE JWT FILTER");
////
////         final HttpServletRequest request = (HttpServletRequest) req;
////         HttpServletResponse response = (HttpServletResponse) res;
////
////
////         // Access-Control-Allow-Origin
////         String origin = request.getHeader("Origin");
////         response.setHeader("Access-Control-Allow-Origin", allowedOrigins.contains(origin) ? origin : "");
////         response.setHeader("Vary", "Origin");
////
////         // Access-Control-Max-Age
////         response.setHeader("Access-Control-Max-Age", "3600");
////
////         // Access-Control-Allow-Credentials
////         response.setHeader("Access-Control-Allow-Credentials", "true");
////
////         // Access-Control-Allow-Methods
////         response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
////
////         // Access-Control-Allow-Headers
////         response.setHeader("Access-Control-Allow-Headers",
////                 "Origin, Authorization, myheader, X-Requested-By, X-Requested-With, Content-Type, Accept, " + "X-CSRF-TOKEN");
////
////         if (request.getMethod().equals("OPTIONS")) {
////             response.flushBuffer();
////         }else{
////
////             final String authHeader = request.getHeader("Authorization");
////             String reqHdr = request.getHeader("X-Requested-By");
////             String myHdr = request.getHeader("myheader");
////
////             System.out.println("=====================================================");
////             System.out.println("Auth header = "+authHeader);
////             System.out.println("requested by header = "+reqHdr);
////             System.out.println("my header = "+myHdr);
////             System.out.println("=====================================================");
////
////             if (authHeader == null || !authHeader.startsWith("Bearer ")) {
////                 System.out.println("JwtFilter.doFilter -> auth header is null or token does not start with Bearer");
////                 throw new ServletException("Missing or invalid Authorization header.");
////             }
////
////             final String token = authHeader.substring(7); // The part after "Bearer "
////
////             try {
////                 final Claims claims = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody();
////                 request.setAttribute("claims", claims);
////             }
////             catch (final SignatureException e) {
////                 System.out.println("JwtFilter.doFilter -> Signature Exception, invalid token = "+e.getMessage());
////                 throw new ServletException("Invalid token.");
////             }
////
////             filterChain.doFilter(req, res);
////
////         }
//    }

    /**
     * if present, extract the jwt token from the "Bearer <jwt>" header value.
     *
     * @param headerVal
     * @return jwt if present, empty otherwise
     */
    private Optional<String> getBearerToken(String headerVal) {
        if (headerVal != null && headerVal.startsWith(BEARER)) {
            return Optional.of(headerVal.replace(BEARER, "").trim());
        }
        return Optional.empty();
    }
}
