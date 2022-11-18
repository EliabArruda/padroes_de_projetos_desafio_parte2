package one.digitalinnovation.padroes_de_projetos_desafio_parte2.service;

import one.digitalinnovation.padroes_de_projetos_desafio_parte2.model.Cliente;
import org.springframework.stereotype.Service;

@Service
public interface ClienteService {

    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(Long id);

    void salvar(Cliente cliente);

    void salvarClienteComCep(Cliente cliente);

    void atualizar(Long id, Cliente cliente);

    void deletar(Long id);
}
