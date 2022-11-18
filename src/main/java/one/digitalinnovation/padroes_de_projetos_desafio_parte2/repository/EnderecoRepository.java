package one.digitalinnovation.padroes_de_projetos_desafio_parte2.repository;

import one.digitalinnovation.padroes_de_projetos_desafio_parte2.model.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {
}
