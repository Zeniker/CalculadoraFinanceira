import React, {Component, Fragment} from 'react';
import { Link } from 'react-router-dom';
import $ from "jquery";

const TableHead = () =>{
  return (
    <thead>
    <tr>
      <th>Bandeira</th>
      <th>Banco</th>
      <th>Apelido</th>
    </tr>
    </thead>
  );
};

const TableBody = props =>{
  const linhas = props.cartoes.map((linha, index) => {
    return (
      <tr key={linha.id}>
        <td>{linha.bandeira}</td>
        <td>{linha.banco}</td>
        <td>{linha.apelido}</td>
      </tr>
    );
  });

  return (
    <tbody>
    {linhas}
    </tbody>
  );
};

class TabelaCartao extends Component{

  constructor(){
    super();
    this.state = {
      cartoes: []
    }
  }

  //Chama logo após renderizar componente
  componentDidMount(){
    $.ajax({
      url: 'http://localhost:8080/cartao/listar/1',
      type: 'get',
      dataType: 'json',
      success: function(resposta){
        this.setState({cartoes: resposta.cartoes});
      }.bind(this),
      headers: {
        'Access-Control-Allow-Origin': '*'
      }
    });
  }

  render(){
    const { match } = this.props;


    return(
      <Fragment>
        <Link to={`${match.path}/alterar`} >
          <button className="waves-effect waves-light btn mt-10 float-right">
            Novo
          </button>
        </Link>
        <table className="centered highlight">
          <TableHead/>
          <TableBody cartoes = { this.state.cartoes }  />
        </table>
      </Fragment>
    );
  }
}

export default TabelaCartao;