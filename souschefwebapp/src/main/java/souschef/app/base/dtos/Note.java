package souschef.app.base.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Note {

    private @Id @GeneratedValue Long id;
    private String title;
    private String noteContent;

    public Note(String noteTitle, String noteContent){
        this.title = noteTitle;
        this.noteContent = noteContent;
    }

}
