package br.com.guilherme.calculadoraFinanceira.conta;

import br.com.guilherme.calculadoraFinanceira.conta.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/conta")
public class ContaController {

    private final ContaService contaService;

    @Autowired
    public ContaController(ContaService contaService){

        this.contaService = contaService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public CriarContaResponseDTO criarConta(@RequestBody @Valid ContaDTO contaDTO){
        CriarContaResponseDTO responseDTO;
        try{
            contaService.criarConta(contaDTO);
            responseDTO = new CriarContaResponseDTO();
        }catch (Exception e){
            responseDTO = new CriarContaResponseDTO(e);
        }

        return responseDTO;
    }

    @RequestMapping(value = "/{idConta}", method = RequestMethod.GET)
    public BuscarContaResponseDTO buscarConta(@PathVariable Integer idConta){
        BuscarContaResponseDTO responseDTO;
        try{
            Conta conta = contaService.buscarContaPor(idConta);
            responseDTO = new BuscarContaResponseDTO(conta);
        }catch (Exception e){
            responseDTO = new BuscarContaResponseDTO(e);
        }

        return responseDTO;
    }

    @RequestMapping(value = "/{idConta}", method = RequestMethod.PUT)
    public AtualizarContaResponseDTO atualizarConta(@PathVariable Integer idConta, @RequestBody @Valid ContaDTO contaDTO){
        AtualizarContaResponseDTO responseDTO;
        try{
            contaService.atualizarConta(idConta, contaDTO);
            responseDTO = new AtualizarContaResponseDTO();
        }catch (Exception e){
            responseDTO = new AtualizarContaResponseDTO(e);
        }

        return responseDTO;
    }

    @RequestMapping(value = "/{idConta}", method = RequestMethod.DELETE)
    public DeletarContaResponseDTO atualizarConta(@PathVariable Integer idConta){
        DeletarContaResponseDTO responseDTO;
        try{
            contaService.deletarConta(idConta);
            responseDTO = new DeletarContaResponseDTO();
        }catch (Exception e){
            responseDTO = new DeletarContaResponseDTO(e);
        }

        return responseDTO;
    }
}
