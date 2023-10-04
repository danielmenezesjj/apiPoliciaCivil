package Api.policia.civil.de.mato.grosso.core.businessRule;


import Api.policia.civil.de.mato.grosso.adapters.dtos.PessoaDTO;
import Api.policia.civil.de.mato.grosso.adapters.exceptions.EntityAlreadyExistException;
import Api.policia.civil.de.mato.grosso.adapters.exceptions.EntityNotExistException;
import Api.policia.civil.de.mato.grosso.core.domain.Pessoa;
import Api.policia.civil.de.mato.grosso.core.domain.Unidade;
import Api.policia.civil.de.mato.grosso.infrastructure.repository.Pessoa.PessoaRepository;
import Api.policia.civil.de.mato.grosso.infrastructure.repository.Unidade.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class UnidadeBusiness {

    @Autowired
    private UnidadeRepository unidadeRepository;

    public Page<Unidade> findAll(Pageable pageable){
        return unidadeRepository.findAll(pageable);
    }


    public Unidade findOne(Integer unid_id) throws EntityNotExistException {
        Optional<Unidade> optionalUnidade = unidadeRepository.findByUnidId(unid_id);
        if(!optionalUnidade.isPresent()){
            throw new EntityNotExistException(unid_id);
        }
        return optionalUnidade.get();
    }

    public Unidade createUnidade(Unidade unidade) throws EntityAlreadyExistException {
        if (unidadeRepository.findByUnidName(unidade.getUnid_nome()).isPresent()) {
            throw  new EntityAlreadyExistException(unidade.getUnid_nome());
        }
        return unidadeRepository.save(unidade);
    }

//    public void updatePessoa(Integer pes_id, PessoaDTO data) throws EntityNotExistException {
//        Optional<Pessoa> pessoaOptional = unidadeRepository.findByPesId(pes_id);
//        if (pessoaOptional.isPresent()) {
//            Pessoa pessoa = pessoaOptional.get();
//            pessoa.update(data);
//        }else{
//            throw new EntityNotExistException(pes_id);
//        }
//    }
//
//    public void deletePessoa(Integer pes_id) throws  EntityNotExistException{
//        Optional<Pessoa> optionalPessoa = unidadeRepository.findByPesId(pes_id);
//        if(optionalPessoa.isPresent()){
//            Pessoa pessoa = optionalPessoa.get();
//            unidadeRepository.delete(pessoa);
//        }else{
//            throw new EntityNotExistException(pes_id);
//        }
//    }




}
