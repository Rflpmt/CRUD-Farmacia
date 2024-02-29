import React, { useState } from 'react';
import categoriaService from '../services/categoriaService';

function CategoriaForm() {
  const [nome, setNome] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await categoriaService.create({ nome });
      alert('Categoria criada com sucesso!');
      setNome('');
    } catch (error) {
      console.error('Erro ao criar categoria:', error);
    }
  };

  return (
    <div>
      <h2>Criar Nova Categoria</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          placeholder="Nome da categoria"
          value={nome}
          onChange={(e) => setNome(e.target.value)}
        />
        <button type="submit">Criar Categoria</button>
      </form>
    </div>
  );
}

export default CategoriaForm;
