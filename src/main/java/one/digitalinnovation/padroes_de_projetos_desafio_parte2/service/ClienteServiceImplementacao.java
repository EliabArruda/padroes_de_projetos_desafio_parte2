package one.digitalinnovation.padroes_de_projetos_desafio_parte2.service;

import one.digitalinnovation.padroes_de_projetos_desafio_parte2.model.Cliente;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImplementacao implements ClienteService{

    @Override
    public Iterable<Cliente> buscarTodos() {
        return null;
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return null;
    }

    @Override
    public void salvar(Cliente cliente) {

    }

    @Override
    public void atualizar(Long id, Cliente cliente) {

    }

    @Override
    public void deletar(Long id) {

    }
}
