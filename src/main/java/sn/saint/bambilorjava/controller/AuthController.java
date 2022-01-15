package sn.saint.bambilorjava.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;
import sn.saint.bambilorjava.controller.api.AuthenticationApi;
import sn.saint.bambilorjava.model.auth.AuthenticationRequest;
import sn.saint.bambilorjava.model.auth.AuthenticationResponse;
import sn.saint.bambilorjava.repository.AppuserRepository;
import sn.saint.bambilorjava.service.serviceImpl.UserDetailsServiceImpl;
import sn.saint.bambilorjava.utils.JwtUtil;


@RestController
@AllArgsConstructor
public class AuthController implements AuthenticationApi {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    AppuserRepository appuserRepository;

    @Override
    public ResponseEntity<AuthenticationResponse> authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());


        System.out.println("************************************");
        System.out.println(userDetails);
        System.out.println("************************************");
        final String jwt = jwtUtil.generateToken((User) userDetails);

        return ResponseEntity.ok(
                new AuthenticationResponse(jwt)
        );
    }
}
