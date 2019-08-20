import React from 'react';
import { Link } from 'react-router-dom';

const Header = () => {
  return (
    <nav>
      <div className="nav-wrapper">
        <a href="/" className="brand-logo">Calculadora Financeira</a>
        <ul className="right">
          <li><a href="/conta">Conta</a></li>
          <li><Link to="/cartao">Cartões</Link></li>
          <li><a href="/movimentacoes">Movimentações</a></li>
          <li><a href="/ajuda">Ajuda</a></li>
        </ul>
      </div>
    </nav>
  );
};

export default Header;
