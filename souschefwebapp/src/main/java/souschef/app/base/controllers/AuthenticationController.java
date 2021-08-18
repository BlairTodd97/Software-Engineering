package souschef.app.base.controllers;

import jdk.jfr.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import souschef.app.base.TokenGenerator;
import souschef.app.base.UserRepository;
import souschef.app.base.dtos.UserDTO;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;


@RequestMapping("/auth")
@RestController
@Slf4j
public class AuthenticationController {

    private UserRepository userRepository;

    public AuthenticationController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    @CrossOrigin("http://localhost:3000")
    ResponseEntity<?> authenticateUser(@Validated @RequestBody UserDTO user){ //change this to return just the token
        log.info("Request to authenticate user: {}", user);
        UserDTO foundUser = userRepository.findUserByEmail(user.getEmail());
        if(foundUser == null){
            log.error("[Attempted login] User email not found");
            return ResponseEntity.notFound().build();
        } else if(!foundUser.getPassword().equals(user.getPassword())){
            log.error("[Attempted login] User password not found");
            return ResponseEntity.notFound().build();
        } else if(!foundUser.getToken().isEmpty()){
            return ResponseEntity.ok().body(foundUser);
        }
        log.info(foundUser.toString());
        String newToken = TokenGenerator.genToken();
        foundUser.setToken(newToken);
        userRepository.save(foundUser);
        System.out.println(ResponseEntity.ok().body(newToken));
        return ResponseEntity.ok().body(newToken);
    }

    @PostMapping("/signup")
    @CrossOrigin("http://localhost:3000")
    ResponseEntity<UserDTO> createUser(@Validated @RequestBody UserDTO user) throws URISyntaxException {
        log.info("Request to signup user: {}", user);
        String newToken = TokenGenerator.genToken();
        user.setToken(newToken);
        UserDTO result = userRepository.save(user);
        return ResponseEntity.created(new URI("/api/user/" + result.getToken())).body(result);
    }

    @PutMapping("/logout/{token}")
    @CrossOrigin("http://localhost:3000")
    ResponseEntity<?> logoutUser(@PathVariable String token) {
        log.info("Logging out user {}", token);
        Optional<UserDTO> user = userRepository.findUserByToken(token);
        if(user.isPresent()) {
            UserDTO userLogout = user.get();
            userLogout.setToken("");
            userRepository.save(userLogout);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
