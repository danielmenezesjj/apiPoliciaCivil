package Api.policia.civil.de.mato.grosso.core.businessRule;

import Api.policia.civil.de.mato.grosso.core.domain.FotoPessoa;
import Api.policia.civil.de.mato.grosso.core.domain.Pessoa;
import Api.policia.civil.de.mato.grosso.infrastructure.repository.FotoPessoa.FotoPessoaRepository;
import Api.policia.civil.de.mato.grosso.infrastructure.repository.Pessoa.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Controller
public class FotoPessoaBusiness {
    @Autowired
    private FotoPessoaRepository fotoPessoaRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public FotoPessoa adicionarImagemPessoa(Integer pessoaId, MultipartFile imagem) {
        try {
            // Encontrar a pessoa
            Pessoa pessoa = pessoaRepository.findByPesId(pessoaId)
                    .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada"));

            // Converter os bytes da imagem para base64
            String imagemBase64 = Base64.getEncoder().encodeToString(imagem.getBytes());

            // Criar uma nova entidade de imagem e associar à pessoa
            FotoPessoa imagemPessoa = new FotoPessoa();
            imagemPessoa.setImagemBase64(imagemBase64.getBytes());
            imagemPessoa.setPessoa(pessoa);

            // Salvar a imagem no repositório
            fotoPessoaRepository.save(imagemPessoa);

            return imagemPessoa;  // Retorna a entidade de imagem criada
        } catch (IOException e) {
            // Lidar com exceções de IO, logar, etc.
            throw new RuntimeException("Erro ao adicionar imagem", e);
        } catch (Exception e) {
            // Lidar com outras exceções, logar, etc.
            throw new RuntimeException("Erro ao adicionar imagem", e);
        }
    }

    public String obterImagemBase64(Integer pessoaId) {
        List<FotoPessoa> fotosPessoa = fotoPessoaRepository.findAllByPessoaPesId(pessoaId);

        if (!fotosPessoa.isEmpty()) {
            FotoPessoa fotoPessoa = fotosPessoa.get(0);

            if (fotoPessoa.getImagemBase64() != null) {
                // Converter bytes para base64
                return Base64.getEncoder().encodeToString(fotoPessoa.getImagemBase64());
            }
        }

        return null;
    }

    }






