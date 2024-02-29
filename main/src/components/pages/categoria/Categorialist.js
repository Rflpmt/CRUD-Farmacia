import React, { useState, useEffect } from 'react';
import categoriaService from '../services/categoriaService';

function CategoriaList() {
  const [categorias, setCategorias] = useState([]);

  useEffect(() => {
    async function fetchData() {
      try {
        const data = await categoriaService.getAll();
        setCategorias(data);
      } catch (error) {
        console.error('Erro ao carregar categorias:', error);
      }
    }
    fetchData();
  }, []);

  return (
    <div>
      <h2>Lista de Categorias</h2>
      <ul>
        {categorias.map((categoria) => (
          <li key={categoria.id}>{categoria.nome}</li>
        ))}
      </ul>
    </div>
  );
}

export default CategoriaList;
