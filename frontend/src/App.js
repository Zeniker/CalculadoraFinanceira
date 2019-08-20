import React, {Component, Fragment} from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import 'materialize-css/dist/css/materialize.min.css';
import 'materialize-css/dist/js/materialize.min.js';

import './App.css';

//Movimentacao
import TabelaMovimentacao from './movimentacao/TabelaMovimentacao.js';


//Cartao
import TabelaCartao from './cartao/TabelaCartao.js';
import FormularioCartao from './cartao/FormularioCartao.js';


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
            <Route path="/cartao/alterar" exact component={FormularioCartao}/>
          </Router>
        </div>
      </Fragment>
    );
  }

  // render() {
  //   return (
  //     <Fragment>
  //       <Header />
  //       <div className="container mb-10">
  //         <TabelaMovimentacao removeMovimentacao = { this.removeMovimentacao } />
  //         <FormularioMovimentacao adicionaMovimentacao={this.adicionaMovimentacao}/>
  //       </div>
  //     </Fragment>
  //   );
  // }
}

export default App;
