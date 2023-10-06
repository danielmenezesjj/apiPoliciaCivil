package Api.policia.civil.de.mato.grosso.infrastructure.repository.Lotacao;

import Api.policia.civil.de.mato.grosso.core.domain.Cidade;
import Api.policia.civil.de.mato.grosso.core.domain.Lotacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LotacaoRepository extends JpaRepository<Lotacao, Integer> {
   @Query("SELECT l FROM Lotacao l WHERE l.lot_id = :lot_id")
    Optional<Lotacao> findByLotId(Integer lot_id);
}
