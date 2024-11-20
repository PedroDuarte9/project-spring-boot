package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

@Entity(name = "Medico")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "medicos")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;


    public Medico(DadosCadastroMedico dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosUpdateMedico dadosUpdateMedico) {
        if (dadosUpdateMedico.nome() != null){
            this.nome = dadosUpdateMedico.nome();
        }
        if (dadosUpdateMedico.telefone() != null){
            this.telefone = dadosUpdateMedico.telefone();

        }
        if (dadosUpdateMedico.endereco() != null){
            this.endereco.atualizarInformacoes(endereco);
        }
    }
}
