package souschef.app.base.dtos;

import lombok.Data;
import souschef.app.base.enums.TipDifficulty;

@Data
public class TipsDTO {
    private Long id;
    private String title;
    private String description;
    private TipDifficulty difficulty;

    //cons
    public TipsDTO() {
        title = "test";
        description = "test description";
        difficulty = TipDifficulty.BEGINNER;
    }

    //setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setTipDescription(String tipDescription) {
        this.description = description;
    }
    public void setDifficulty(int i) {
        switch(i) {
            case 0:
                difficulty = TipDifficulty.BEGINNER;
            case 1:
                difficulty = TipDifficulty.AMATEUR;
            case 2:
                difficulty = TipDifficulty.ADVANCED;
            case 3:
                difficulty = TipDifficulty.PROFESSIONAL;
            default:
                difficulty = TipDifficulty.BEGINNER;
        }
    }


    //getters
    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getTipDescription() {
        return description;
    }
    public int getDifficulty() {
        switch(difficulty) {
            case BEGINNER:
                return 0;
            case AMATEUR:
                return 1;
            case ADVANCED:
                return 2;
            case PROFESSIONAL:
                return 3;
            default:
                return -1;
        }
    }

    @Override
    public String toString() {
        return "TipsDTO{" +
                "ID='" + id + "'" +
                "title='" + title + "'" +
                "tipDescription='" + description + "'" +
                "difficulty='" + difficulty + "'";
    }
}