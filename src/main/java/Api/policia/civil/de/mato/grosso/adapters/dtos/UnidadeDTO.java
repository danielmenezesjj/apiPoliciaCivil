package Api.policia.civil.de.mato.grosso.adapters.dtos;

import Api.policia.civil.de.mato.grosso.core.domain.Endereco;

public record UnidadeDTO(String unid_nome, String unid_sigla, Endereco endereco) {
}
