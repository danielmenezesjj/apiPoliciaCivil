package Api.policia.civil.de.mato.grosso.core.domain;


import Api.policia.civil.de.mato.grosso.adapters.dtos.CidadeDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


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
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "cidade")
   // @JsonManagedReference// @JsonManagedReference é a parte direta da referência – aquela que é serializada normalmente
    private List<Endereco>enderecos;


    public Cidade(CidadeDTO data) {
        this.cid_nome = data.cid_nome();
        this.cid_uf = data.cid_uf();
        this.enderecos = new ArrayList<>();
        if(data.endereco() != null){
            this.enderecos.add(data.endereco());
        }
    }

    public void update(CidadeDTO data) {

        if(data.cid_nome() != null){
            this.cid_nome = data.cid_nome();
        }
        if(data.cid_uf() != null){
            this.cid_uf = data.cid_uf();
        }

    }
}
