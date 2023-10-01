package Api.policia.civil.de.mato.grosso.infrastructure.repository.Cidade;

import Api.policia.civil.de.mato.grosso.core.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CidadeRepository  extends JpaRepository<Cidade, Integer> {
    //SELECT u FROM Unidade u WHERE u.unid_id = :unidId
    @Query("SELECT c FROM Cidade c where c.cid_id = :cidId")
    Optional<Cidade> findBycidid(Integer cidId);
}
