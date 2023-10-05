package Api.policia.civil.de.mato.grosso.adapters.controller;


import Api.policia.civil.de.mato.grosso.adapters.dtos.CidadeDTO;
import Api.policia.civil.de.mato.grosso.adapters.dtos.FotoPessoaDTO;
import Api.policia.civil.de.mato.grosso.adapters.exceptions.EntityAlreadyExistException;
import Api.policia.civil.de.mato.grosso.adapters.exceptions.EntityNotExistException;
import Api.policia.civil.de.mato.grosso.core.businessRule.CidadeBusiness;
import Api.policia.civil.de.mato.grosso.core.businessRule.FotoPessoaBusiness;
import Api.policia.civil.de.mato.grosso.core.domain.Cidade;
import Api.policia.civil.de.mato.grosso.core.domain.FotoPessoa;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/fotopessoa")
public class FotoPessoaController {


    @Autowired
    private FotoPessoaBusiness fotoPessoaBusiness;


    @PostMapping
    public ResponseEntity createFotoPessoa(
            @RequestParam("pessoaId") Integer pessoaId,
            @RequestParam("imagem") MultipartFile imagem) {
        FotoPessoa createFoto = fotoPessoaBusiness.adicionarImagemPessoa(pessoaId, imagem);
        return ResponseEntity.status(HttpStatus.CREATED).body(createFoto);
    }


    @GetMapping("/{pessoaId}")
    public ResponseEntity<String> obterImagemPessoaBase64(@PathVariable Integer pessoaId) {
        String imagemBase64 = fotoPessoaBusiness.obterImagemBase64(pessoaId);

        if (imagemBase64 != null) {
            return ResponseEntity.ok(imagemBase64);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}