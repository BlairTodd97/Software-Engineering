package souschef.app.base.dtos;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private @Id @GeneratedValue Long id;
    @NonNull
    private String firstName;
    private String lastName;
    @NonNull
    private String password;
    @NonNull
    private String email;
    private String token;

    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private Set<Note> notes = new HashSet<>();
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<RecipeDTO> recipes = new HashSet<>();
}
