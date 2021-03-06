import { Component } from 'react';
import PubSub from "pubsub-js";

class FormInputCustomizado extends Component{

  constructor(){
    super();
    this.state = {
      msgErro: ''
    };
  }

  render(){
    return;
  }

  componentDidMount(){
    this.subscribeMensagemErro();
    this.subscribeLimpaErros();
  }

  subscribeMensagemErro(){
    PubSub.subscribe("erro-validacao", function (topico, erro) {
      if(erro.field === this.props.id){
        this.setState({msgErro: erro.defaultMessage});
      }
    }.bind(this));
  }

  subscribeLimpaErros(){
    PubSub.subscribe("limpar-erros-validacao", function(topico, erro){
      this.setState({msgErro: ''});
    }.bind(this));
  }

}

export default FormInputCustomizado;