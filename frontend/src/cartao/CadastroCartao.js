import React, {Component, Fragment} from 'react';
import { Redirect } from 'react-router-dom';
import PubSub from 'pubsub-js';

//Componentes
import FormularioCartao from './FormularioCartao.js';
import TratadorErroValidacao from '../erros/TratadorErroValidacao.js';

//Service
import FetchPost from '../service/FetchPost.js';

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

  }

  salvaDadosCartao = dados => {
    let fetchPost = new FetchPost();
    PubSub.publish("limpar-erros-validacao", {});
    fetchPost.realizarRequest('http://localhost:8080/cartao', dados)
      .then(resolveResponse => {
        this.finalizaCadastro();
      }, rejectResponse => {
        if(rejectResponse.status === 400){
          new TratadorErroValidacao().publicaErros(rejectResponse);
        }else{
          console.log(rejectResponse.error);
        }
      });
  };

  finalizaCadastro = () => {
    this.setState({redirect: true});
  };

  renderRedirect = () => {
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