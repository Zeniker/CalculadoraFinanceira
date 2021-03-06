import React, {Component} from 'react';

class FormularioMovimentacao extends Component {
  constructor(props){
    super(props);

    this.stateInicial = {
      valor: '',
      tipoMovimentacao: '',
      dataOperacao: '',
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

    const { valor, tipoMovimentacao, dataOperacao } = this.state;

    return (
      <form>
        <div className="row">
          <div className="input-field col s4">
            <input id="valor" type="text" name="valor" value={valor} onChange={this.escutadorDeInput}/>
            <label htmlFor="valor">Valor</label>
          </div>

          <div className="input-field col s4">
            <label htmlFor="tipo">Tipo</label>
            <input id="tipo" type="text" name="tipoMovimentacao" value={tipoMovimentacao} onChange={this.escutadorDeInput}/>
          </div>

          <div className="input-field col s4">
            <label htmlFor="data">Data</label>
            <input id="data" type="text" name="dataOperacao" value={dataOperacao} onChange={this.escutadorDeInput}/>
          </div>
        </div>
        <button className="waves-effect waves-light btn"
                onClick={this.submitFormulario} type="button">Salvar</button>
      </form>
    );
  }
}

export default FormularioMovimentacao;