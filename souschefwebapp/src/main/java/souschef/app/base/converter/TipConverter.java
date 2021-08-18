package souschef.app.base.converter;

import org.springframework.stereotype.Component;
import souschef.app.base.dtos.TipsDTO;
import souschef.app.base.entity.Tip;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TipConverter {

    public TipsDTO entityToDto(Tip tip) {
        TipsDTO dto = new TipsDTO();

        dto.setId(tip.getId());
        dto.setTitle(tip.getTitle());
        dto.setTipDescription(tip.getTipDescription());
        dto.setDifficulty(tip.getDifficulty());

        return dto;
    }

    public List<TipsDTO> entityToDto(List<Tip> tip) {

        return tip.stream().map(x-> entityToDto(x)).collect(Collectors.toList());
    }

    public Tip dtoToEntity(TipsDTO dto) {
        Tip tip = new Tip();

        tip.setId(dto.getId());
        tip.setTitle(dto.getTitle());
        tip.setTipDescription(dto.getTipDescription());
        tip.setDifficulty(dto.getDifficulty());

        return tip;
    }

    public List<Tip> dtoToEntity(List<TipsDTO> dto) {

        return dto.stream().map(x-> dtoToEntity(x)).collect(Collectors.toList());
    }

}
