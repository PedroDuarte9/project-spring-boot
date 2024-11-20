package med.voll.api.controller;


import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


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

//    @GetMapping("/lista")
//    public List<DadosRetornoMedico> listarMedicos(){
//
//        /*Explicando cada parte do código abaixo, a partir de .stream() o .stream() transforma uma lista para o tipo Stream, para podermos usufruir dos métodos dessa classe
//         sendo assim, utilizaremos o .map() que é um método que pega cada elemento da lista passada e transforma em outro elemento, de acordo com o que for pedido
//          no caso abaixo ele pegou o construtor da record DadosCadastroMedico::new que recebe um tipo Medico que é o que o repository aceita e
//          finaliza, transformando de volta em uma lista com o .toList()*/
//        return medicoRepository.findAll().stream().map(DadosRetornoMedico::new).toList();
//    }

    /*Agora no metodo de recuperação da lista usaremos o tipo Page<T> e como parametro usaremos a Classe Pageable do Spring, para poder manipular a quantidade de páginas mostradas,
    * ou a quantidade de dados por página, assim sucessivamente, retiramos o stream() pois usando o Pageable conseguimos usar esse recurso do .map()
    * IMPORTANTE com os recursos de Pageable a manipulação de pagina e dados como ordenação por exemplo, fica a critério do cliente, passando an URL(size, page, sort=nomeDoCampo,desc)
    * A Anotação @PageableDefault serve para caso o cliente não implemente na url, quando consumir a endpoint*/

    @GetMapping("/lista")
    public Page<DadosRetornoMedico> listarMedicos(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return medicoRepository.findAll(paginacao).map((d) -> new DadosRetornoMedico(d));

    }
//É importante que o Id sempre apareça nas requisções de GEt que possam aparecer para ser passados na hora de atualizar os dados de algo ou alguém
    @PutMapping("/editar")
    @Transactional
     public void atualizarMedicos(@RequestBody @Valid DadosUpdateMedico dadosUpdateMedico){
        Medico medico = medicoRepository.getReferenceById(dadosUpdateMedico.id());
        medico.atualizarInformacoes(dadosUpdateMedico);
    }

//    @GetMapping("/individual/{id}")
//    public Medico getMedicoId(@PathVariable("id") String id){
//         return medicoRepository.findById()
//    }


}
