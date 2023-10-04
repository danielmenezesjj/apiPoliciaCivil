package Api.policia.civil.de.mato.grosso.core.domain;


import Api.policia.civil.de.mato.grosso.adapters.dtos.PessoaDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "Pessoa")
@NoArgsConstructor
@Getter
@Setter
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pes_id;

    private String pes_nome;

    private Date pes_data_nascimento;

    private String pes_sexo;

    private String pes_mae;

    private String pes_pai;

    @ManyToMany
    @JoinTable(name = "pessoa_endereco", joinColumns = @JoinColumn(name = "pes_id"), inverseJoinColumns = @JoinColumn(name = "end_id"))
    private List<Endereco> enderecoList;


    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<FotoPessoa> fotoPessoaList;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<ServidorTemporario> servidorTemporarioList;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<ServidorEfetivo> servidorEfetivoList;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Lotacao> lotacaoList;


    public Pessoa(PessoaDTO data) {
        this.pes_nome = data.pes_nome();
        this.pes_data_nascimento = data.pes_data_nascimento();
        this.pes_sexo = data.pes_sexo();
        this.pes_mae = data.pes_mae();
        this.pes_pai = data.pes_pai();
        this.enderecoList = new ArrayList<>();  // Inicialize a lista
        if (data.endereco() != null) {
            this.enderecoList.add(data.endereco());  // Adicione o endereço à lista
        }
    }

    public void update(PessoaDTO data) {

    if(data.pes_nome() != null){
        this.pes_nome = data.pes_nome();
    }
    if(data.pes_data_nascimento() != null){
        this.pes_data_nascimento = data.pes_data_nascimento();
        }
    if(data.pes_sexo() != null){
        this.pes_sexo = data.pes_sexo();
    }
    if(data.pes_mae() != null){
        this.pes_mae = data.pes_mae();
    }
    if(data.pes_pai() != null){
        this.pes_pai = data.pes_pai();
    }

    }
}
