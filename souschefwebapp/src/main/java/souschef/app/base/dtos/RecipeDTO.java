package souschef.app.base.dtos;

import lombok.*;
import souschef.app.base.enums.MealType;

import javax.persistence.*;
import java.util.List;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RecipeDTO {

    private @Id @GeneratedValue Long id;
    private String title;
    private MealType mealType;

    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Ingredient> ingredients;
    private String imageURL; //idk how to actually save this

}
