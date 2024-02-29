import React from 'react';
import './NavBar.css';

function NavBar() {
  return (
    <nav className="navbar">
      <ul>
        <li><a href="/">Home</a></li>
        <li><a href="/categorias">Categorias</a></li>
        {/* Adicione outras rotas conforme necessário */}
      </ul>
    </nav>
  );
}

export default NavBar;