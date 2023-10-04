package Api.policia.civil.de.mato.grosso.adapters.dtos;

import Api.policia.civil.de.mato.grosso.core.domain.Pessoa;

import java.util.Date;

public record ServidorTemporarioDTO(Date st_data_admissao, Date st_data_demissao, Pessoa pessoa) {
}
