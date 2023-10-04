package Api.policia.civil.de.mato.grosso.infrastructure.repository.ServidorTemporario;

import Api.policia.civil.de.mato.grosso.core.domain.Pessoa;
import Api.policia.civil.de.mato.grosso.core.domain.ServidorTemporario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.Optional;

public interface ServidorTemporarioRepository  extends JpaRepository<ServidorTemporario, Integer> {


}
