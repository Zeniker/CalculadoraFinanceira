import React, { Component } from 'react';

class SelectCustomizado extends Component{


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
          {this.montaOpcoes(opcoes)}
        </select>
        <label htmlFor={id}>{label}</label>
      </div>
    );
  }

}

export default SelectCustomizado;