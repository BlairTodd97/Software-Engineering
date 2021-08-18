package souschef.app.base.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import souschef.app.base.UserRepository;
import souschef.app.base.dtos.RecipeDTO;
import souschef.app.base.dtos.UserDTO;
import souschef.app.base.enums.MealType;

import java.util.*;

@Slf4j
@RestController
@RequestMapping("/data/recipes")
public class RecipeController {

    private UserRepository userRepository;

    public RecipeController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/{token}")
    ResponseEntity<?> userRecipes(@PathVariable String token) {
        Optional<UserDTO> user = userRepository.findUserByToken(token);
        if (user.isPresent()) {
            return ResponseEntity.ok().body(user.get().getRecipes());
        }
        return ResponseEntity.notFound().build();
    }

    //search by title or mealtype
    @GetMapping(value = "/{token}/{search}")
    ResponseEntity<?> getRecipe(@PathVariable String token, @PathVariable String search) {
        Optional<UserDTO> user = userRepository.findUserByToken(token);
        if(user.isPresent()){
            Set<RecipeDTO> usersRecipes = user.get().getRecipes();
            List<RecipeDTO> matchedRecipes = new ArrayList<>();
            MealType checkMeal;
            try{
                checkMeal = MealType.valueOf(search);
            } catch(IllegalArgumentException e){
                checkMeal = null;
            }
            boolean foundRecipes = false;
            for(RecipeDTO recipe: usersRecipes){
                if(recipe.getTitle().contains(search) || recipe.getMealType().equals(checkMeal)){
                    matchedRecipes.add(recipe);
                    foundRecipes = true;
                }
            }
            if(foundRecipes){
                return ResponseEntity.ok(matchedRecipes);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{token}")
    ResponseEntity<?> createRecipe(@PathVariable String token, @Validated @RequestBody RecipeDTO recipe) {
        log.info("Request to create recipe: {}", recipe);
        Optional<UserDTO> user = userRepository.findUserByToken(token);
        if(user.isPresent()){
            UserDTO foundUser = user.get();
            foundUser.getRecipes().add(recipe);
            userRepository.save(foundUser);
            return ResponseEntity.ok().body(recipe);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{token}/{title}")
    ResponseEntity<?> updateRecipe(@PathVariable String token, @PathVariable String title, @Validated @RequestBody RecipeDTO recipe){
        log.info("Request to update recipe: {}", recipe);
        Optional<UserDTO> user = userRepository.findUserByToken(token);
        if(user.isPresent()){
            UserDTO foundUser = user.get();
            for(RecipeDTO replaceRecipe: foundUser.getRecipes()){
                if(replaceRecipe.getTitle().equals(title)){
                    foundUser.getRecipes().remove(replaceRecipe);
                    foundUser.getRecipes().add(recipe);
                    userRepository.save(foundUser);
                    return ResponseEntity.ok().body(recipe);
                }
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{token}")
    public ResponseEntity<?> deleteRecipe(@PathVariable String token, @Validated @RequestBody RecipeDTO recipe){
        log.info("Request to update recipe: {}", recipe);
        Optional<UserDTO> user = userRepository.findUserByToken(token);
        String search = recipe.getTitle();
        if(user.isPresent()){
            UserDTO foundUser = user.get();
            for(RecipeDTO deleteRecipe: foundUser.getRecipes()){
                if(deleteRecipe.getTitle().equals(search)) {
                    foundUser.getRecipes().remove(deleteRecipe);
                    userRepository.save(foundUser);
                    return ResponseEntity.ok().build();
                }
            }
        }
        return ResponseEntity.notFound().build();
    }
}
