package med.voll.api.medico;

import org.springframework.data.jpa.repository.Query;

public record DadosRetornoMedico(
        String nome,
        String email,
        String crm,
        Especialidade especialidade) {

        public DadosRetornoMedico(Medico dadosMedico) {
                this(dadosMedico.getNome(), dadosMedico.getEmail(), dadosMedico.getCrm(), dadosMedico.getEspecialidade());
        }
}
