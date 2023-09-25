package Api.policia.civil.de.mato.grosso.infrastructure.repository.Unidade;

import Api.policia.civil.de.mato.grosso.core.domain.Unidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UnidadeRepository  extends JpaRepository<Unidade, Integer> {
    @Query("SELECT u FROM Unidade u WHERE u.unid_id = :unidId")
    Optional<Unidade> findByUnidId(Integer unidId);
}
