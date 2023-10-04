package Api.policia.civil.de.mato.grosso.core.domain;


import Api.policia.civil.de.mato.grosso.adapters.dtos.UnidadeDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity(name = "Unidade")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Unidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer unid_id;
    private String unid_nome;
    private String unid_sigla;


    @ManyToMany
    @JoinTable(name = "unidade_endereco", joinColumns = @JoinColumn(name = "unid_id"), inverseJoinColumns = @JoinColumn(name = "end_id"))
    private List<Endereco> enderecoList;

    @OneToMany(mappedBy = "unidade", cascade = CascadeType.ALL)
    private List<Lotacao> lotacaoList;



    public Unidade(UnidadeDTO data) {
        this.unid_nome = data.unid_nome();
        this.unid_sigla = data.unid_sigla();
        this.enderecoList = new ArrayList<>();  // Inicialize a lista
        if (data.endereco() != null) {
            this.enderecoList.add(data.endereco());  // Adicione o endereço à lista
        }
    }
    public void update(UnidadeDTO data){
        if(data.unid_nome() != null){
            this.unid_nome = data.unid_nome();
        }
        if(data.unid_sigla() != null){
            this.unid_sigla = data.unid_sigla();
        }
    }
}
