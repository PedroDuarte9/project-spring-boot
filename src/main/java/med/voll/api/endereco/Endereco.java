package med.voll.api.endereco;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Endereco {
        private String logradouro;
        private String cep;
        private String cidade;
        private String uf;
        private String complemento;
        private String numero;

}
