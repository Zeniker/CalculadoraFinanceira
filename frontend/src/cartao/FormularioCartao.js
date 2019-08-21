import React, {Component} from 'react';
import M from 'materialize-css';

//Componentes
import InputCustomizado from '../componentes/InputCustomizado.js';
import SelectCustomizado from '../componentes/SelectCustomizado.js';

class FormularioMovimentacao extends Component {
  constructor(props){
    super(props);

    this.stateInicial = {
      idConta: 1,
      bandeira: '',
      banco: '',
      apelido: ''
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
    this.props.funcaoSubmit(this.state);
  };

  componentDidMount() {
    let elementos = document.querySelectorAll('select');
    M.FormSelect.init(elementos, {});
  };

  render() {

    const { bandeira, banco, apelido } = this.state;

    let opcoes = [
      {
        valor: 'MASTERCARD',
        descricao: 'Mastercard'
      },
      {
        valor: 'VISA',
        descricao: 'Visa'
      }
    ];

    return (
      <form>
        <div className="row">
          <InputCustomizado id="apelido" label="Apelido" onChange={this.escutadorDeInput} colClass="s4"
                            valor={apelido} tipo="text"/>

          <InputCustomizado id="banco" label="Banco" onChange={this.escutadorDeInput} colClass="s4"
                            valor={banco} tipo="text"/>

          <SelectCustomizado id="bandeira" label="Bandeira" onChange={this.escutadorDeInput} colClass="s4"
                             valor={bandeira} opcoes={opcoes} />
        </div>
        <button className="btn"
                onClick={this.submitFormulario} type="button">Salvar</button>
      </form>
    );
  };
}

export default FormularioMovimentacao;