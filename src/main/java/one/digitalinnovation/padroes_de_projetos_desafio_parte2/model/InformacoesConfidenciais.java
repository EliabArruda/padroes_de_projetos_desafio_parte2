package one.digitalinnovation.padroes_de_projetos_desafio_parte2.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Cpf {


    @Id
    private String cpf;

    public boolean validaCpf(String cpf){
        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.assertValid(cpf);
    }
}
