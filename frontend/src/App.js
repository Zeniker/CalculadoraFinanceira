import React, {Component, Fragment} from 'react';
import './App.css';
import 'materialize-css/dist/css/materialize.min.css';
import 'materialize-css/dist/js/materialize.min.js';
import $ from 'jquery';

import TabelaMovimentacao from './movimentacao/TabelaMovimentacao.js';
import FormularioMovimentacao from './movimentacao/FormularioMovimentacao.js';
import Header from './geral/Header.js';

class App extends Component{
  
  constructor(){
    super();
  }

  removeMovimentacao = indiceParaRemover => {
    const { movimentacoes } = this.state;

    this.setState(
      {
        movimentacoes : movimentacoes.filter((movimentacao, indiceAtual) => {
          return indiceAtual !== indiceParaRemover;
        })
      }
    );
  };

  adicionaMovimentacao = movimentacao => {
    this.setState({
      movimentacoes: [...this.state.movimentacoes, movimentacao]
    });
  };

  render() {
    return (
      <Fragment>
        <Header />
        <div className="container mb-10">
          <TabelaMovimentacao removeMovimentacao = { this.removeMovimentacao } />
          <FormularioMovimentacao adicionaMovimentacao={this.adicionaMovimentacao}/>
        </div>
      </Fragment>
    );
  }
}

export default App;
