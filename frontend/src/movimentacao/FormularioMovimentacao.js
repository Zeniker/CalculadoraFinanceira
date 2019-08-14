import React, {Component} from 'react';

class FormularioMovimentacao extends Component {
  constructor(props){
    super(props);

    this.stateInicial = {
      valor: '',
      tipo: '',
      data: '',
    };

    this.state = this.stateInicial;
  }

  escutadorDeInput = event => {
    const { name, value } = event.target;

    this.setState({
      [name] : value
    });
  };

  submitFormulario = () => {
    this.props.adicionaMovimentacao(this.state);
    this.setState(this.stateInicial);
  };

  render(){

    const { valor, tipo, data } = this.state;

    return (
      <form>
        <label htmlFor="valor">Valor</label>
        <input id="valor" type="text" name="valor" value={valor} onChange={this.escutadorDeInput}/>

        <label htmlFor="tipo">Tipo</label>
        <input id="tipo" type="text" name="tipo" value={tipo} onChange={this.escutadorDeInput}/>

        <label htmlFor="data">Data</label>
        <input id="data" type="date" name="data" value={data} onChange={this.escutadorDeInput}/>

        <button onClick={this.submitFormulario} type="button">Salvar</button>
      </form>
    );
  }
}

export default FormularioMovimentacao;