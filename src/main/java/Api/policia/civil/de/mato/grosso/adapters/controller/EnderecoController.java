package Api.policia.civil.de.mato.grosso.adapters.controller;


import Api.policia.civil.de.mato.grosso.adapters.dtos.EnderecoDTO;
import Api.policia.civil.de.mato.grosso.adapters.exceptions.EntityAlreadyExistException;
import Api.policia.civil.de.mato.grosso.adapters.exceptions.EntityNotExistException;
import Api.policia.civil.de.mato.grosso.core.businessRule.EnderecoBusiness;
import Api.policia.civil.de.mato.grosso.core.domain.Endereco;
import Api.policia.civil.de.mato.grosso.infrastructure.repository.Cidade.CidadeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {


    @Autowired
    private EnderecoBusiness enderecoBusiness;

    @Autowired
    private CidadeRepository cidadeRepository;

    @GetMapping
    public ResponseEntity<Page<Endereco>> getAllEndereco(Pageable pageable) {
        Page<Endereco> allEndereco = enderecoBusiness.findAll(pageable);
        return ResponseEntity.ok(allEndereco);
        //ok
    }

    @GetMapping("/{end_id}")
    public ResponseEntity getoneEndereco(@PathVariable Integer end_id) throws EntityNotExistException {
        var city = enderecoBusiness.findOne(end_id);
        return ResponseEntity.ok(city);
    }

    @PostMapping
    public ResponseEntity createEndereco(@RequestBody @Valid EnderecoDTO data) throws EntityAlreadyExistException {
        Endereco endereco = new Endereco(data);
        Endereco createEndereco = enderecoBusiness.createEndereco(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(createEndereco);
    }

    @PutMapping("/{end_id}")
    @Transactional
    public ResponseEntity updateEndereco(@PathVariable Integer end_id, @RequestBody EnderecoDTO data) throws EntityNotExistException {
            enderecoBusiness.updateEndereco(end_id, data);
            return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{end_id}")
    @Transactional
    public ResponseEntity deleteEndereco(@PathVariable Integer end_id) throws EntityNotExistException {
        enderecoBusiness.deleteEndereco(end_id);
        return ResponseEntity.noContent().build();
    }

}