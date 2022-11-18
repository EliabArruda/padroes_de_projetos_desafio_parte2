package one.digitalinnovation.padroes_de_projetos_desafio_parte2.controller;

import one.digitalinnovation.padroes_de_projetos_desafio_parte2.model.Cliente;
import one.digitalinnovation.padroes_de_projetos_desafio_parte2.service.ClienteService;
import one.digitalinnovation.padroes_de_projetos_desafio_parte2.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    /**
     * Singleton
     */
    @Autowired
    private ClienteService clienteService;


    @GetMapping
    public ResponseEntity<Iterable<Cliente>> buscarTodos(){
        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente){
        clienteService.salvar(cliente);
        return ResponseEntity.ok(cliente);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente){
        clienteService.atualizar(id, cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deletar(Long id){
       clienteService.deletar(id);
       return ResponseEntity.ok().build();
    }


}
