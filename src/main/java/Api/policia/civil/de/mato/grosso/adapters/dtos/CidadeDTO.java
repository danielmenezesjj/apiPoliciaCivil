package Api.policia.civil.de.mato.grosso.adapters.dtos;

import Api.policia.civil.de.mato.grosso.core.domain.Endereco;

public record CidadeDTO(String cid_nome, String cid_uf, Endereco endereco) {
}
