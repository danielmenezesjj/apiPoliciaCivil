package Api.policia.civil.de.mato.grosso.core.domain;


import Api.policia.civil.de.mato.grosso.adapters.dtos.CidadeDTO;
import Api.policia.civil.de.mato.grosso.adapters.dtos.EnderecoDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity(name = "Endereco")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int end_id;

    @Column(name = "end_tipo_logradouro")
    private String tipoLogradouro;

    @Column(name = "end_logradouro")
    private String logradouro;

    @Column(name = "end_numero")
    private String numero;

    @Column(name = "end_bairro")
    private String bairro;

    @ManyToOne
    @JoinColumn(name = "cid_id")
    @JsonBackReference// @JsonBackReference é a parte posterior da referência – será omitida na serialização.
    private Cidade cidade;



    @ManyToMany
    @JoinTable(name = "pessoa_endereco", joinColumns = @JoinColumn(name = "end_id"), inverseJoinColumns = @JoinColumn(name = "pes_id"))
    private List<Pessoa> pessoaList;

    @ManyToMany
    @JoinTable(name = "unidade_endereco", joinColumns = @JoinColumn(name = "end_id"), inverseJoinColumns = @JoinColumn(name = "unid_id"))
    private List<Unidade> unidadeList;

    public Endereco(EnderecoDTO data){
        this.tipoLogradouro = data.tipoLogradouro();
        this.logradouro = data.logradouro();
        this.numero = data.numero();
        this.bairro = data.bairro();
        this.cidade = data.cidade();
    }


    public void update(EnderecoDTO data) {

        if(data.tipoLogradouro() != null){
            this.tipoLogradouro = data.tipoLogradouro();
        }
        if(data.logradouro() != null){
            this.logradouro = data.logradouro();
        }
        if(data.numero() != null){
            this.numero = data.numero();
        }
        if(data.bairro() != null){
            this.bairro = data.bairro();
        }
        if(data.cidade() != null){
            this.cidade = data.cidade();
        }

    }
}
