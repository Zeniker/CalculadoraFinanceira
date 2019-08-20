import React, {Component, Fragment} from 'react';
import $ from "jquery";
import { Redirect } from 'react-router-dom';
import PubSub from 'pubsub-js';

//Componentes
import FormularioCartao from './FormularioCartao.js';
import TratadorErroValidacao from '../erros/TratadorErroValidacao.js';

class CadastroCartao extends Component {
  constructor(props){
    super(props);

    this.state = {
      idConta: 1,
      bandeira: '',
      banco: '',
      apelido: '',
      redirect: false
    };

    this.salvaDadosCartao = this.salvaDadosCartao.bind(this);
    this.finalizaCadastro = this.finalizaCadastro.bind(this);
  }

  salvaDadosCartao(dados){
    $.ajax({
      url: 'http://localhost:8080/cartao',
      type: 'post',
      contentType: 'application/json',
      data: JSON.stringify(dados),
      dataType: 'json',
      success: function (resposta) {
        this.finalizaCadastro();
      }.bind(this),
      error: function(resposta){
        if(resposta.status === 400){
          new TratadorErroValidacao().publicaErros(resposta.responseJSON);
        }
      },
      headers: {
        'Access-Control-Allow-Origin': '*'
      },
      beforeSend: function(){
        PubSub.publish("limpar-erros-validacao", {});
      }
    });
  };

  finalizaCadastro(){
    this.setState({redirect: true});
  }

  renderRedirect(){
    if(this.state.redirect === true){
      return (
        <Redirect to="/cartao" />
      );
    }
  };

  render(){

    return (
      <Fragment>
        <FormularioCartao funcaoSubmit={this.salvaDadosCartao} />
        { this.renderRedirect() }
      </Fragment>

    );
  }
}

export default CadastroCartao;