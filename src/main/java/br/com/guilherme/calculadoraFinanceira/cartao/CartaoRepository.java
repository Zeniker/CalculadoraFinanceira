package br.com.guilherme.calculadoraFinanceira.cartao;

import br.com.guilherme.calculadoraFinanceira.conta.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartaoRepository extends JpaRepository<Cartao, Integer> {

    List<Cartao> findByConta(Conta conta);

}
