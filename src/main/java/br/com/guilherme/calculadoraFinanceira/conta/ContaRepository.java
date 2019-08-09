package br.com.guilherme.calculadoraFinanceira.conta;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Integer> {

}
