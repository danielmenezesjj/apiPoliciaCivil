package Api.policia.civil.de.mato.grosso.adapters.controller;

import Api.policia.civil.de.mato.grosso.adapters.dtos.PessoaDTO;
import Api.policia.civil.de.mato.grosso.adapters.exceptions.EntityAlreadyExistException;
import Api.policia.civil.de.mato.grosso.adapters.exceptions.EntityNotExistException;
import Api.policia.civil.de.mato.grosso.core.businessRule.PessoaBusiness;
import Api.policia.civil.de.mato.grosso.core.domain.Pessoa;
import Api.policia.civil.de.mato.grosso.infrastructure.repository.Pessoa.PessoaRepository;
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
@RequestMapping("pessoas")
public class PessoaController {

    @Autowired
    private PessoaBusiness pessoaBusiness;

    @GetMapping
    public ResponseEntity <Page<Pessoa>>  getAllPessoas(Pageable pageable){
        Page<Pessoa> pessoas = pessoaBusiness.findAll(pageable);
        return ResponseEntity.ok(pessoas);
    }


    @GetMapping("/{pes_id}")
    public ResponseEntity getOnePessoa(@PathVariable Integer pes_id) throws EntityNotExistException {
        var pessoa = pessoaBusiness.findOne(pes_id);
        return ResponseEntity.ok(pessoa);

    }

    @PostMapping
    public ResponseEntity postPessoas(@RequestBody @Valid PessoaDTO data) throws EntityAlreadyExistException {
        Pessoa newPessoa = new Pessoa(data);
        var register = pessoaBusiness.createPessoa(newPessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(register);
    }

    @PutMapping("/{pes_id}")
    @Transactional
    public ResponseEntity putPessoas(@PathVariable Integer pes_id, @RequestBody @Valid PessoaDTO data) throws EntityNotExistException {
        pessoaBusiness.updatePessoa(pes_id, data);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{pes_id}")
    public ResponseEntity delPessoa(@PathVariable Integer pes_id) throws EntityNotExistException{
        pessoaBusiness.deletePessoa(pes_id);
        return ResponseEntity.noContent().build();
    }



}
