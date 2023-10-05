package Api.policia.civil.de.mato.grosso.core.businessRule;


import Api.policia.civil.de.mato.grosso.adapters.dtos.CidadeDTO;
import Api.policia.civil.de.mato.grosso.adapters.dtos.PessoaDTO;
import Api.policia.civil.de.mato.grosso.adapters.exceptions.EntityAlreadyExistException;
import Api.policia.civil.de.mato.grosso.adapters.exceptions.EntityNotExistException;
import Api.policia.civil.de.mato.grosso.core.domain.Cidade;
import Api.policia.civil.de.mato.grosso.core.domain.Endereco;
import Api.policia.civil.de.mato.grosso.core.domain.Pessoa;
import Api.policia.civil.de.mato.grosso.core.domain.ServidorTemporario;
import Api.policia.civil.de.mato.grosso.infrastructure.repository.Pessoa.PessoaRepository;
import Api.policia.civil.de.mato.grosso.infrastructure.repository.ServidorEfetivo.ServidorEfetivoRepository;
import Api.policia.civil.de.mato.grosso.infrastructure.repository.ServidorTemporario.ServidorTemporarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Controller
public class PessoaBusiness {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    ServidorTemporarioRepository servidorTemporarioRepository;

    @Autowired
    ServidorEfetivoRepository servidorEfetivoRepository;

    public Page<Pessoa> findAll(Pageable pageable){
        return pessoaRepository.findAll(pageable);
    }


    public Pessoa findOne(Integer pes_id) throws EntityNotExistException {
        Optional<Pessoa> optionalPessoa = pessoaRepository.findByPesId(pes_id);
        if(!optionalPessoa.isPresent()){
            throw new EntityNotExistException(pes_id);
        }
        return optionalPessoa.get();
    }

    public Pessoa createPessoa(Pessoa pessoa) throws EntityAlreadyExistException {
        if (pessoaRepository.findByPesNome(pessoa.getPes_nome()).isPresent()) {
            throw  new EntityAlreadyExistException(pessoa.getPes_nome());
        }
        return pessoaRepository.save(pessoa);
    }

    public void updatePessoa(Integer pes_id, PessoaDTO data) throws EntityNotExistException {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findByPesId(pes_id);
        if (pessoaOptional.isPresent()) {
            Pessoa pessoa = pessoaOptional.get();
            pessoa.update(data);
        }else{
            throw new EntityNotExistException(pes_id);
        }
    }

    public void deletePessoa(Integer pes_id) throws  EntityNotExistException{
        Optional<Pessoa> optionalPessoa = pessoaRepository.findByPesId(pes_id);
        if(optionalPessoa.isPresent()){
            Pessoa pessoa = optionalPessoa.get();
            pessoaRepository.delete(pessoa);
        }else{
            throw new EntityNotExistException(pes_id);
        }
    }




}
