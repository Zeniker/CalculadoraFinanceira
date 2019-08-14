import React, {Component} from 'react';

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
          <td>{linha.tipo}</td>
          <td>{linha.data}</td>
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
  render(){
    const { movimentacoes, removeMovimentacao } = this.props;

    return(
        <table className="centered highlight">
          <TableHead/>
          <TableBody movimentacoes = { movimentacoes } removeMovimentacao = {removeMovimentacao} />
        </table>
    );
  }
}

export default TabelaMovimentacao;