package Api.policia.civil.de.mato.grosso.adapters.controller;

import Api.policia.civil.de.mato.grosso.adapters.dtos.UnidadeDTO;
import Api.policia.civil.de.mato.grosso.adapters.exceptions.EntityAlreadyExistException;
import Api.policia.civil.de.mato.grosso.adapters.exceptions.EntityNotExistException;
import Api.policia.civil.de.mato.grosso.core.businessRule.UnidadeBusiness;
import Api.policia.civil.de.mato.grosso.core.domain.Unidade;
import Api.policia.civil.de.mato.grosso.infrastructure.repository.Unidade.UnidadeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/unidades")
public class UnidadeController {

    @Autowired
    UnidadeBusiness unidadeBusiness;

    @GetMapping
    public ResponseEntity<Page<Unidade>> getAllUnidade(Pageable pageable){
        var unidades = unidadeBusiness.findAll(pageable);
        return ResponseEntity.ok(unidades);
    }


    @GetMapping("/{unid_id}")
    public ResponseEntity getOneUnidade(@PathVariable Integer unid_id) throws EntityNotExistException {
       var unidade = unidadeBusiness.findOne(unid_id);
       return ResponseEntity.ok(unidade);
    }


    @PostMapping
    public ResponseEntity createUnidade(@RequestBody @Valid UnidadeDTO data) throws EntityAlreadyExistException {
        Unidade unidade = new Unidade(data);
        unidadeBusiness.createUnidade(unidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(unidade);
    }

    @PutMapping("/{unid_id}")
    @Transactional
    public ResponseEntity updateUnidade(@PathVariable Integer unid_id, @RequestBody @Valid UnidadeDTO data) throws EntityNotExistException{
        unidadeBusiness.updateUnidade(unid_id, data);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{unid_id}")
    public ResponseEntity deleteUnidade(@PathVariable Integer unid_id) throws EntityNotExistException {
        unidadeBusiness.deleteUnidade(unid_id);
        return ResponseEntity.noContent().build();

    }


}
