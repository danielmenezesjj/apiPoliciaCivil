package Api.policia.civil.de.mato.grosso.adapters.controller;


import Api.policia.civil.de.mato.grosso.adapters.dtos.CidadeDTO;
import Api.policia.civil.de.mato.grosso.adapters.dtos.LotacaoDTO;
import Api.policia.civil.de.mato.grosso.adapters.exceptions.EntityAlreadyExistException;
import Api.policia.civil.de.mato.grosso.adapters.exceptions.EntityNotExistException;
import Api.policia.civil.de.mato.grosso.core.businessRule.CidadeBusiness;
import Api.policia.civil.de.mato.grosso.core.businessRule.LotacaoBusiness;
import Api.policia.civil.de.mato.grosso.core.domain.Cidade;
import Api.policia.civil.de.mato.grosso.core.domain.Lotacao;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lotacao")
public class LotacaoController {


    @Autowired
    private LotacaoBusiness lotacaoBusiness;


    @GetMapping
    public ResponseEntity<Page<Lotacao>> getAllLotacao(Pageable pageable) {
        Page<Lotacao> allLotacao = lotacaoBusiness.findAll(pageable);
        return ResponseEntity.ok(allLotacao);
    }

    @GetMapping("/{lot_id}")
    public ResponseEntity getoneLotacao(@PathVariable Integer lot_id) throws EntityNotExistException {
        var lotacao = lotacaoBusiness.findOne(lot_id);
        return ResponseEntity.ok(lotacao);
    }

    @PostMapping
    public ResponseEntity createLotacao(@RequestBody @Valid LotacaoDTO data) throws EntityAlreadyExistException {
        Lotacao lotacao = new Lotacao(data);
        Lotacao createLotacao = lotacaoBusiness.createLotacao(lotacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(createLotacao);
    }

    @PutMapping("/{lot_id}")
    @Transactional
    public ResponseEntity updateLotacao(@PathVariable Integer lot_id, @RequestBody LotacaoDTO data) throws EntityNotExistException {
            lotacaoBusiness.updateLotacao(lot_id, data);
            return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{lot_id}")
    @Transactional
    public ResponseEntity deleteLotacao(@PathVariable Integer lot_id) throws EntityNotExistException {
        lotacaoBusiness.deleteLotacao(lot_id);
        return ResponseEntity.noContent().build();
    }

}