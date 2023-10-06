package Api.policia.civil.de.mato.grosso.core.businessRule;

import Api.policia.civil.de.mato.grosso.adapters.dtos.CidadeDTO;
import Api.policia.civil.de.mato.grosso.adapters.dtos.LotacaoDTO;
import Api.policia.civil.de.mato.grosso.adapters.exceptions.EntityAlreadyExistException;
import Api.policia.civil.de.mato.grosso.adapters.exceptions.EntityNotExistException;
import Api.policia.civil.de.mato.grosso.core.domain.Cidade;
import Api.policia.civil.de.mato.grosso.core.domain.Lotacao;
import Api.policia.civil.de.mato.grosso.infrastructure.repository.Cidade.CidadeRepository;
import Api.policia.civil.de.mato.grosso.infrastructure.repository.Lotacao.LotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class LotacaoBusiness {
    @Autowired
    private LotacaoRepository lotacaoRepository;


    public Page<Lotacao> findAll(Pageable pageable){
        return lotacaoRepository.findAll(pageable);

    }

    public Lotacao findOne(Integer lot_id) throws EntityNotExistException{
        Optional<Lotacao>optionalLotacao = lotacaoRepository.findByLotId(lot_id);
        if(!optionalLotacao.isPresent()){
            throw new EntityNotExistException(lot_id);
        }
        return optionalLotacao.get();
    }

    public Lotacao createLotacao(Lotacao lotacao) throws EntityAlreadyExistException {

        return lotacaoRepository.save(lotacao);
    }

    public void updateLotacao(Integer lot_id, LotacaoDTO data) throws EntityNotExistException {
        Optional<Lotacao> optionalLotacao = lotacaoRepository.findByLotId(lot_id);
        if (optionalLotacao.isPresent()) {
            Lotacao lotacao = optionalLotacao.get();
            lotacao.update(data);
            lotacaoRepository.save(lotacao);
        } else {
            throw new EntityNotExistException(lot_id);
        }
    }

    public void deleteLotacao(Integer lot_id) throws EntityNotExistException{
        Optional<Lotacao>optionalLotacao = lotacaoRepository.findByLotId(lot_id);
        if(!optionalLotacao.isPresent()){
            throw new EntityNotExistException(lot_id);
        }
        Lotacao lotacao = optionalLotacao.get();
        lotacaoRepository.delete(lotacao);
    }



}
