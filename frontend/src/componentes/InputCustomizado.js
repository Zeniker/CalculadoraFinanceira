import React, { Component } from 'react';
import PubSub from 'pubsub-js';

class InputCustomizado extends Component{

  constructor(){
    super();
    this.state = {
      msgErro: ''
    };
  }

  render(){
    const { id, label, onChange, colClass, valor, tipo } = this.props;

    return (
      <div className={ "input-field col " + colClass }>
        <input id={id} type={tipo} name={id} value={valor} onChange={onChange}/>
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

export default InputCustomizado;