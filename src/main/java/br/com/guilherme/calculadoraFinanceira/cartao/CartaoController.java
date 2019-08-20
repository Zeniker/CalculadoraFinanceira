package br.com.guilherme.calculadoraFinanceira.cartao;

import br.com.guilherme.calculadoraFinanceira.cartao.dto.BuscarCartaoResponseDTO;
import br.com.guilherme.calculadoraFinanceira.cartao.dto.CartaoDTO;
import br.com.guilherme.calculadoraFinanceira.cartao.dto.CriarCartaoResponseDTO;
import br.com.guilherme.calculadoraFinanceira.cartao.dto.ListarCartoesContaResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/cartao")
public class CartaoController {

    private final CartaoService cartaoService;

    public CartaoController(CartaoService cartaoService){
        this.cartaoService = cartaoService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public CriarCartaoResponseDTO criarCartao(@Valid @RequestBody CartaoDTO cartaoDTO){
        CriarCartaoResponseDTO responseDTO;
        try{
            cartaoService.criarCartao(cartaoDTO);
            responseDTO = new CriarCartaoResponseDTO();
        }catch (Exception e){
            responseDTO = new CriarCartaoResponseDTO(e);
        }

        return responseDTO;
    }

    @RequestMapping(value = "/{idCartao}", method = RequestMethod.GET)
    public BuscarCartaoResponseDTO getCartao(@PathVariable Integer idCartao){
        BuscarCartaoResponseDTO responseDTO;
        try{
            responseDTO = new BuscarCartaoResponseDTO(
                    cartaoService.buscarCartaoPor(idCartao)
            );
        }catch (Exception e){
            responseDTO = new BuscarCartaoResponseDTO(e);
        }

        return responseDTO;
    }

    @RequestMapping(value = "/listar/{idConta}", method = RequestMethod.GET)
    public ListarCartoesContaResponseDTO listarCartoesConta(@PathVariable Integer idConta){
        ListarCartoesContaResponseDTO responseDTO;
        try {
            responseDTO = new ListarCartoesContaResponseDTO(
                    cartaoService.listaCartoesPor(idConta)
            );
        }catch (Exception e){
            responseDTO = new ListarCartoesContaResponseDTO(e);
        }
        return responseDTO;
    }
}
