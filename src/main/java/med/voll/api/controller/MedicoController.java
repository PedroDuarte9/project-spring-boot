package med.voll.api.controller;


import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;


    @PostMapping("/cria")
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        medicoRepository.save(new Medico(dados));
    }

    @GetMapping("/lista")
    public List<DadosRetornoMedico> listarMedicos(){

        /*Explicando cada parte do código abaixo, a partir de .stream() o .stream() transforma uma lista para o tipo Stream, para podermos usufruir dos métodos dessa classe
         sendo assim, utilizaremos o .map() que é um método que pega cada elemento da lista passada e transforma em outro elemento, de acordo com o que for pedido
          no caso abaixo ele pegou o construtor da record DadosCadastroMedico::new que recebe um tipo Medico que é o que o repository aceita e
          finaliza, transformando de volta em uma lista com o .toList()*/
        return medicoRepository.findAll().stream().map(DadosRetornoMedico::new).toList();
    }

//  '  @GetMapping("/individual/{id}")
//    public Medico getMedicoId(@PathVariable("id") String id){
//         return medicoRepository.findById()
//    }


}
