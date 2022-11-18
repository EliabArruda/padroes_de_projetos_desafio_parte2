package one.digitalinnovation.padroes_de_projetos_desafio_parte2.service;

import one.digitalinnovation.padroes_de_projetos_desafio_parte2.model.Cliente;
import one.digitalinnovation.padroes_de_projetos_desafio_parte2.model.Endereco;
import one.digitalinnovation.padroes_de_projetos_desafio_parte2.repository.ClienteRepository;
import one.digitalinnovation.padroes_de_projetos_desafio_parte2.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Optional;

/** Objetivo - Implementar os Padrões de Projeto 'Singleton', 'Strategy' e 'Facade'
 *
 */

@Service
public class ClienteServiceImplementacao implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;


    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(@PathVariable Long id) {
        Optional<Cliente> busca = clienteRepository.findById(id);
        return busca.get();
    }

    @Override
    public void salvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();

        /**Verifica se CEP do cliente já existe*/
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {

            /**Se não existir, integrar com o ViaCEP e retornar novo endereço*/
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });

        cliente.setEndereco(endereco);

        /**Insere Cliente com o novo endereço */
        clienteRepository.save(cliente);
    }


    @Override
    public void salvar(Cliente cliente) {
    salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        /**Busca cliente por ID, caso exista*/
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if(clienteBd.isPresent()) {
            salvarClienteComCep(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
}
