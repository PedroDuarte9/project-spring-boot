package med.voll.api.medico;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.Query;

public record DadosRetornoMedico(
        @NotNull
        Long id,
        String nome,
        String email,
        String crm,
        Especialidade especialidade) {

        public DadosRetornoMedico(Medico dadosMedico) {
                this(dadosMedico.getId(), dadosMedico.getNome(), dadosMedico.getEmail(), dadosMedico.getCrm(), dadosMedico.getEspecialidade());
        }
}
