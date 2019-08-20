import React from 'react';

import FormInputCustomizado from './FormInputCustomizado.js';

class InputCustomizado extends FormInputCustomizado{

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
}

export default InputCustomizado;