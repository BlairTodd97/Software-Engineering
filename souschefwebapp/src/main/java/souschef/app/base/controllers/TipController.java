package souschef.app.base.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import souschef.app.base.converter.TipConverter;
import souschef.app.base.dtos.TipsDTO;
import souschef.app.base.entity.Tip;
import souschef.app.base.repo.TipRepo;

import java.util.List;

@RestController
public class TipController {

    @Autowired
    TipRepo tipRepo;
    @Autowired
    TipConverter converter;

    @GetMapping("/findAll")
    public List<TipsDTO> findAll() {

        List<Tip> findAll = tipRepo.findAll();
        return converter.entityToDto(findAll);
    }

    @GetMapping("find/{ID}")
    public TipsDTO findById(@PathVariable(value = "ID") Long id) {

        Tip orElse = tipRepo.findById(id).orElse(null);
        return converter.entityToDto(orElse);
    }

    @PostMapping("/save")
    public TipsDTO save(@RequestBody TipsDTO dto) {

        Tip tip = converter.dtoToEntity(dto);
        tip = tipRepo.save(tip);

        return converter.entityToDto(tip);
    }
}
