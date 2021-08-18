package souschef.app.base.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import souschef.app.base.entity.Tip;

public interface TipRepo extends JpaRepository<Tip, Long> {

}
