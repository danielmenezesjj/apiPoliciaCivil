package Api.policia.civil.de.mato.grosso.core.businessRule;


import Api.policia.civil.de.mato.grosso.adapters.dtos.PessoaDTO;
import Api.policia.civil.de.mato.grosso.adapters.dtos.UnidadeDTO;
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

    public void updateUnidade(Integer unid_id, UnidadeDTO data) throws EntityNotExistException {
        Optional<Unidade> unidadeOptional = unidadeRepository.findByUnidId(unid_id);
        if (unidadeOptional.isPresent()) {
            Unidade unidade = unidadeOptional.get();
            unidade.update(data);
        }else{
            throw new EntityNotExistException(unid_id);
        }
    }

    public void deleteUnidade(Integer unid_id) throws  EntityNotExistException{
        Optional<Unidade> optionalUnidade = unidadeRepository.findByUnidId(unid_id);
        if(optionalUnidade.isPresent()){
            Unidade unidade = optionalUnidade.get();
            unidadeRepository.delete(unidade);
        }else{
            throw new EntityNotExistException(unid_id);
        }
    }




}
