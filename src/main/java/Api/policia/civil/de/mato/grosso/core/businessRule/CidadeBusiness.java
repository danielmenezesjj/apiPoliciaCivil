package Api.policia.civil.de.mato.grosso.core.businessRule;

import Api.policia.civil.de.mato.grosso.adapters.dtos.CidadeDTO;
import Api.policia.civil.de.mato.grosso.adapters.exceptions.EntityAlreadyExistException;
import Api.policia.civil.de.mato.grosso.adapters.exceptions.EntityNotExistException;
import Api.policia.civil.de.mato.grosso.core.domain.Cidade;
import Api.policia.civil.de.mato.grosso.infrastructure.repository.Cidade.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class CidadeBusiness {
    @Autowired
    private CidadeRepository cidadeRepository;


    public Page<Cidade> findAll(Pageable pageable){
        return cidadeRepository.findAll(pageable);

    }

    public Cidade findOne(Integer cid_id) throws EntityNotExistException{
        Optional<Cidade>optionalCidade = cidadeRepository.findBycidid(cid_id);
        if(!optionalCidade.isPresent()){
            throw new EntityNotExistException(cid_id);
        }
        return optionalCidade.get();
    }

    public Cidade createCity(Cidade cidade) throws EntityAlreadyExistException {
        if(cidadeRepository.findByNomeAndUf(cidade.getCid_nome(), cidade.getCid_uf()).isPresent()){
            throw new EntityAlreadyExistException(cidade.getCid_nome());
        }
        return cidadeRepository.save(cidade);
    }

    public void updateCity(Integer cid_id, CidadeDTO data) throws EntityNotExistException {
        Optional<Cidade> optionalCidade = cidadeRepository.findBycidid(cid_id);
        if (optionalCidade.isPresent()) {
            Cidade cidade = optionalCidade.get();
            cidade.update(data);
            cidadeRepository.save(cidade);
        } else {
            throw new EntityNotExistException(cid_id);
        }
    }

    public void deleteCity(Integer cid_id) throws EntityNotExistException{
        Optional<Cidade>optionalCidade = cidadeRepository.findBycidid(cid_id);
        if(!optionalCidade.isPresent()){
            throw new EntityNotExistException(cid_id);
        }
        Cidade cidade = optionalCidade.get();
        cidadeRepository.delete(cidade);
    }



}
