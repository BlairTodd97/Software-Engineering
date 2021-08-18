package souschef.app.base;

import org.springframework.data.jpa.repository.JpaRepository;
import souschef.app.base.dtos.UserDTO;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<UserDTO, Long> {
    UserDTO findUserByFirstName(String firstName);
    UserDTO findUserByEmail(String email);
    Optional<UserDTO> findUserByToken(String token);


    void deleteUserByToken(String token);
}
