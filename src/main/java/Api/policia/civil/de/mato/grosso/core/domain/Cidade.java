package Api.policia.civil.de.mato.grosso.core.domain;


import Api.policia.civil.de.mato.grosso.adapters.dtos.CidadeDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Cidade")
@Entity(name = "Cidade")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid_id;
    private String cid_nome;
    private String cid_uf;


    public Cidade(CidadeDTO data) {
        this.cid_nome = data.cid_nome();
        this.cid_uf = data.cid_uf();
    }
}
