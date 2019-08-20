import React, {Component, Fragment} from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import 'materialize-css/dist/css/materialize.min.css';
import 'materialize-css/dist/js/materialize.min.js';

import './App.css';

//Movimentacao
import TabelaMovimentacao from './movimentacao/TabelaMovimentacao.js';


//Cartao
import TabelaCartao from './cartao/TabelaCartao.js';
import CadastroCartao from './cartao/CadastroCartao.js';


import Header from './geral/Header.js';

class App extends Component{

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
        <div className="container">
          <Router>
            <Header/>
            <Route path="/" exact component={TabelaMovimentacao}/>
            <Route path="/cartao" exact component={TabelaCartao}/>
            <Route path="/cartao/novo" exact component={CadastroCartao}/>
          </Router>
        </div>
      </Fragment>
    );
  }
}

export default App;
