import React, { Component } from 'react';
import PubSub from "pubsub-js";

class SelectCustomizado extends Component{

  constructor(){
    super();
    this.state = {
      msgErro: ''
    };
  }

  montaOpcoes = opcoes => {
    return opcoes.map((opcao) => {
      return (
        <option key={opcao.valor} value={opcao.valor}>{opcao.descricao}</option>
      );
    });
  };

  render(){
    const { id, label, onChange, colClass, valor, opcoes } = this.props;

    return (
      <div className={ "input-field col " + colClass }>
        <select id={id} name={id} onChange={onChange} value={valor}>
          <option value="">Selecione</option>
          {this.montaOpcoes(opcoes)}
        </select>
        <label htmlFor={id}>{label}</label>
        <span>{this.state.msgErro}</span>
      </div>
    );
  }

  componentDidMount(){
    PubSub.subscribe("erro-validacao", function (topico, erro) {
      if(erro.field === this.props.id){
        this.setState({msgErro: erro.defaultMessage});
      }
    }.bind(this));

    PubSub.subscribe("limpar-erros-validacao", function(topico, erro){
      this.setState({msgErro: ''});
    }.bind(this));
  }

}

export default SelectCustomizado;