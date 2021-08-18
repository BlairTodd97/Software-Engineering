package souschef.app.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import souschef.app.base.dtos.Note;
import souschef.app.base.dtos.RecipeDTO;
import souschef.app.base.dtos.UserDTO;
import souschef.app.base.enums.MealType;

import java.util.Collections;
import java.util.stream.Stream;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final UserRepository repository;

    @Autowired
    public DatabaseLoader(UserRepository repository){
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception{
        Stream.of("Test", "Johana", "Mary", "Blair", "Tristan")
                .forEach(firstName -> repository.save(new UserDTO(firstName, "fakePassword", "fakeEmail")));

        UserDTO blane = repository.findUserByFirstName("Test");
        Note newNote = Note.builder().title("Test note title").noteContent("Test note").build();
        RecipeDTO newRecipe = RecipeDTO.builder().mealType(MealType.BREAKFAST).title("Test Recipe").build();
        blane.setNotes(Collections.singleton(newNote));
        blane.setRecipes(Collections.singleton(newRecipe));
        blane.setEmail("test@gmail.com");
        blane.setPassword("testpass");
        blane.setToken(TokenGenerator.genToken());
        repository.save(blane);

        repository.findAll().forEach(System.out::println);
    }
}
