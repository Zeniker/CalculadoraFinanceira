import React, { Component } from 'react';

class InputCustomizado extends Component{

  render(){
    const { id, label, onChange, colClass, valor, tipo } = this.props;

    return (
      <div className={ "input-field col " + colClass }>
        <input id={id} type={tipo} name={id} value={valor} onChange={onChange}/>
        <label htmlFor={id}>{label}</label>
      </div>
    );
  }

}

export default InputCustomizado;