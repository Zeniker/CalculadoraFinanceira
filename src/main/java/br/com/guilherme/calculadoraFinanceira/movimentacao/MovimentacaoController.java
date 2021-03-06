package br.com.guilherme.calculadoraFinanceira.movimentacao;

import br.com.guilherme.calculadoraFinanceira.conta.dto.CriarContaResponseDTO;
import br.com.guilherme.calculadoraFinanceira.geral.DefaultResponseDTO;
import br.com.guilherme.calculadoraFinanceira.movimentacao.dto.BuscarMovimentacaoResponseDTO;
import br.com.guilherme.calculadoraFinanceira.movimentacao.dto.CriarMovimentacaoRequestDTO;
import br.com.guilherme.calculadoraFinanceira.movimentacao.dto.CriarMovimentacaoResponseDTO;
import br.com.guilherme.calculadoraFinanceira.movimentacao.dto.ListarMovimentacaoAnoMesResponseDTO;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/movimentacao")
public class MovimentacaoController {

    private final MovimentacaoService movimentacaoService;

    public MovimentacaoController(MovimentacaoService movimentacaoService) {
        this.movimentacaoService = movimentacaoService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public CriarMovimentacaoResponseDTO criarMovimentacao(@RequestBody @Valid CriarMovimentacaoRequestDTO requestDTO){
        CriarMovimentacaoResponseDTO responseDTO;
        try{
            movimentacaoService.criarMovimentacao(requestDTO);
            responseDTO = new CriarMovimentacaoResponseDTO();
        }catch (Exception e){
            responseDTO = new CriarMovimentacaoResponseDTO(e);
        }

        return responseDTO;
    }

    @RequestMapping(value = "/{idMovimentacao}", method = RequestMethod.GET)
    public BuscarMovimentacaoResponseDTO buscarMovimentacao(@PathVariable Integer idMovimentacao){
        BuscarMovimentacaoResponseDTO responseDTO;
        try{
            Movimentacao movimentacao = movimentacaoService.buscarMovimentacao(idMovimentacao);
            responseDTO = new BuscarMovimentacaoResponseDTO(movimentacao);
        }catch (Exception e){
            responseDTO = new BuscarMovimentacaoResponseDTO(e);
        }

        return responseDTO;
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public ListarMovimentacaoAnoMesResponseDTO listarAnoMes(@RequestParam Integer idConta,
                                                            @RequestParam Integer ano,
                                                            @RequestParam Integer mes){
        ListarMovimentacaoAnoMesResponseDTO responseDTO;
        try{
            responseDTO = new ListarMovimentacaoAnoMesResponseDTO(
                    movimentacaoService.listarPorAnoMes(idConta, ano, mes)
            );
        }catch (Exception e){
            responseDTO = new ListarMovimentacaoAnoMesResponseDTO(e);
        }

        return responseDTO;
    }
}
