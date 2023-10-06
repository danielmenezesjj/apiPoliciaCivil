package Api.policia.civil.de.mato.grosso.adapters.dtos;

import Api.policia.civil.de.mato.grosso.core.domain.Pessoa;
import Api.policia.civil.de.mato.grosso.core.domain.Unidade;

import java.util.Date;

public record LotacaoDTO(Date lot_data_lotacao, Date lot_data_remocao, String lot_portaria, Pessoa pessoa, Unidade unidade) {
}
