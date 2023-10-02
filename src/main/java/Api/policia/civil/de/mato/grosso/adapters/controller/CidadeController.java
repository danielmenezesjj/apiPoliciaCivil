package Api.policia.civil.de.mato.grosso.adapters.controller;


import Api.policia.civil.de.mato.grosso.adapters.dtos.CidadeDTO;
import Api.policia.civil.de.mato.grosso.adapters.exceptions.EntityAlreadyExistException;
import Api.policia.civil.de.mato.grosso.adapters.exceptions.EntityNotExistException;
import Api.policia.civil.de.mato.grosso.core.businessRule.CidadeBusiness;
import Api.policia.civil.de.mato.grosso.core.domain.Cidade;
import Api.policia.civil.de.mato.grosso.infrastructure.repository.Cidade.CidadeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cidades")
public class CidadeController {


    @Autowired
    private CidadeBusiness cidadeBusiness;

    @Autowired
    private CidadeRepository cidadeRepository;

    @GetMapping
    public ResponseEntity<Page<Cidade>> getAllCity(Pageable pageable) {
        Page<Cidade> allCity = cidadeBusiness.findAll(pageable);
        return ResponseEntity.ok(allCity);
    }

    @GetMapping("/{cid_id}")
    public ResponseEntity getoneCity(@PathVariable Integer cid_id) throws EntityNotExistException {
        var city = cidadeBusiness.findOne(cid_id);
        return ResponseEntity.ok(city);
    }

    @PostMapping
    public ResponseEntity createCity(@RequestBody @Valid CidadeDTO data) throws EntityAlreadyExistException {
        Cidade cidade = new Cidade(data);
        Cidade createCity = cidadeBusiness.createCity(cidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(createCity);
    }

    @PutMapping("/{cid_id}")
    @Transactional
    public ResponseEntity updateCity(@PathVariable Integer cid_id, @RequestBody CidadeDTO data) throws EntityNotExistException {
            cidadeBusiness.updateCity(cid_id, data);
            return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{cid_id}")
    @Transactional
    public ResponseEntity deleteCity(@PathVariable Integer cid_id) throws EntityNotExistException {
        cidadeBusiness.deleteCity(cid_id);
        return ResponseEntity.noContent().build();
    }

}