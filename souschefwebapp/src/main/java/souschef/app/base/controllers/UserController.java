package souschef.app.base.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import souschef.app.base.UserRepository;
import souschef.app.base.dtos.UserDTO;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Slf4j
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //DEPRECATED: shouldn't need to access all users
//    @GetMapping(value = "/users")
//    Collection<UserDTO> users(){
//        return userRepository.findAll();
//    }

    @GetMapping(value = "/user/{token}")
    ResponseEntity<?> getUser(@PathVariable String token){
        Optional<UserDTO> user = userRepository.findUserByToken(token);
        if(user.isPresent()){
            return ResponseEntity.ok().body(user);
        } else{
            return ResponseEntity.notFound().build();
        }

    }

    //DEPRECATED TO AUTHENTICATION CONTROLLER
//    @PostMapping("/user")
//    ResponseEntity<UserDTO> createUser(@Validated @RequestBody UserDTO user) throws URISyntaxException{
//        log.info("Request to create user: {}", user);
//        UserDTO result = userRepository.save(user);
//        return ResponseEntity.created(new URI("/api/user/" + result.getToken())).body(result);
//    }

    @PutMapping("/user/{token}")
    ResponseEntity<UserDTO> updateUser(@Validated @RequestBody UserDTO user, @PathVariable String token){
        log.info("Request to update user: {}", user);
        Optional<UserDTO> foundUser = userRepository.findUserByToken(token);
        if(foundUser.isPresent()){
            UserDTO userEdit = foundUser.get();
            userEdit.setPassword(user.getPassword());
            userEdit.setEmail(user.getEmail());
            userEdit.setFirstName(user.getFirstName());
            userEdit.setLastName(user.getLastName());
            UserDTO result = userRepository.save(userEdit);
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.notFound().build();
    }

    @Transactional
    @DeleteMapping("/user/{token}")
    public ResponseEntity<?> deleteUser(@PathVariable String token){
        log.info("Request to delete user: {}", token);
        userRepository.deleteUserByToken(token);
        return ResponseEntity.ok().build();
    }

}
