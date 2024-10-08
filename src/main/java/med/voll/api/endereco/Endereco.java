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
        private String bairro;
        private String cep;
        private String cidade;
        private String uf;
        private String complemento;
        private String numero;

        public Endereco(DadosEndereco dados) {
                this.logradouro = dados.logradouro();
                this.bairro = dados.bairro();
                this.cep = dados.cep();
                this.cidade = dados.cidade();
                this.uf = dados.uf();
                this.complemento = dados.complemento();
                this.numero = dados.numero();
        }
}
