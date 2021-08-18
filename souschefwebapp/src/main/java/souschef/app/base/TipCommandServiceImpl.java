package souschef.app.base;

import org.springframework.beans.factory.annotation.Autowired;
import souschef.app.base.dtos.TipsDTO;
import souschef.app.base.repo.TipCommandService;
import souschef.app.base.repo.TipRepo;

public class TipCommandServiceImpl implements TipCommandService {

    @Autowired
    private TipRepo tipRepository;

    @Override
    public TipsDTO createTip(String title) {
        return null;
    }
}
