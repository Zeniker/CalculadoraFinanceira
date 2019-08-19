import React, {Component} from 'react';
import $ from "jquery";

const TableHead = () =>{
  return (
      <thead>
        <tr>
          <th>Valor</th>
          <th>Tipo</th>
          <th>Data</th>
        </tr>
      </thead>
  );
};

const TableBody = props =>{
  const linhas = props.movimentacoes.map((linha, index) => {
      return (
        <tr key={index}>
          <td>{linha.valor}</td>
          <td>{linha.tipoMovimentacao}</td>
          <td>{linha.dataOperacao}</td>
          <td><button
            onClick = {() => { props.removeMovimentacao(index) } }
            className="waves-light btn"
            >remover</button>
          </td>
        </tr>
      );
    });

  return (
    <tbody>
      {linhas}
    </tbody>
  );
};

class TabelaMovimentacao extends Component{

  constructor(){
    super();
    this.state = {
      movimentacoes: []
    }
  }

  //Chama logo após renderizar componente
  componentDidMount(){
    let requestData = {
      ano: 2019,
      mes: 8,
      idConta: 1
    };

    $.ajax({
      url: 'http://localhost:8080/movimentacao/listar',
      type: 'get',
      data: requestData,
      dataType: 'json',
      success: function(resposta){
        this.setState({movimentacoes: resposta.movimentacoes});
      }.bind(this),
      headers: {
        'Access-Control-Allow-Origin': '*'
      }
    });
  }

  render(){
    const { removeMovimentacao } = this.props;

    return(
        <table className="centered highlight">
          <TableHead/>
          <TableBody movimentacoes = { this.state.movimentacoes } removeMovimentacao = {removeMovimentacao} />
        </table>
    );
  }
}

export default TabelaMovimentacao;