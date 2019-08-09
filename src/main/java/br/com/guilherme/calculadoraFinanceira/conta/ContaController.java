package br.com.guilherme.calculadoraFinanceira.conta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController(value = "/conta")
public class ContaController {

    @Autowired
    private ContaRepository contaRepository;

    @RequestMapping(method = RequestMethod.GET)
    @Transactional
    public Conta teste(){

        Conta conta = new Conta();
        conta.setNomePessoa("Guilherme");

        contaRepository.save(conta);

        return conta;
    }
}
