package one.digitalinnovation.padroes_de_projetos_desafio_parte2.service;

import one.digitalinnovation.padroes_de_projetos_desafio_parte2.model.Cliente;
import one.digitalinnovation.padroes_de_projetos_desafio_parte2.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

    /**
     * Busca através de uma requisição http GET, pelo valor do Cep passado pelo @Cliente
     * Requisição criada via <b>Open Feign<b/> Consumo da Api do <b>Via Cep<b/>
     * @param cep
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{cep}/json/")
    Endereco consultarCep(@PathVariable("cep") String cep);

}
