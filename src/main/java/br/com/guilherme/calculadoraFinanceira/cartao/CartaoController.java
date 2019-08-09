package br.com.guilherme.calculadoraFinanceira.cartao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cartao")
public class CartaoController {

    private final CartaoService cartaoService;

    @Autowired
    public CartaoController(CartaoService cartaoService){
        this.cartaoService = cartaoService;
    }

    @RequestMapping(value = "/{idCartao}", method = RequestMethod.GET)
    public Cartao getCartao(@PathVariable Integer idCartao){
        return cartaoService.getCartaoBy(idCartao);
    }
}
