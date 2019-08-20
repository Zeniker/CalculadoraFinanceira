import React from 'react';

import FormInputCustomizado from './FormInputCustomizado.js';

class SelectCustomizado extends FormInputCustomizado{

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

}

export default SelectCustomizado;