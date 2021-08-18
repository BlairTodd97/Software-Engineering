package souschef.app.base.repo;

import souschef.app.base.dtos.TipsDTO;

public interface TipCommandService {

    TipsDTO createTip(String title);
}
