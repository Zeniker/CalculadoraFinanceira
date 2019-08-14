package br.com.guilherme.calculadoraFinanceira.movimentacao;

import br.com.guilherme.calculadoraFinanceira.conta.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Interface de repositórios das movimentações
 */
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {

    /**
     *
     * @param conta Conta dona das movimentações
     * @param month Mês das movimentações
     * @param status Status em que as movimentações devem estar
     * @return Retorna a lista de movimentações encontradas baseado nos parâmetros acima
     */
    @Query("select mov from Movimentacao mov where mov.conta = ?1 and mov.status = ?2 and year(mov.dataCobranca) = ?3 and month(mov.dataCobranca) = ?4")
    public List<Movimentacao> getMovimentacaoByContaAndDataCobrancaMonthAndStatus(Conta conta,
                                                                                  Movimentacao.StatusMovimentacao status,
                                                                                  Integer ano,
                                                                                  Integer mes);
}
