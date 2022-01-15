package sn.saint.bambilorjava.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sn.saint.bambilorjava.model.auth.AuthenticationRequest;
import sn.saint.bambilorjava.model.auth.AuthenticationResponse;

public interface AuthenticationApi {

  @PostMapping("/login")
  ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request);
}
