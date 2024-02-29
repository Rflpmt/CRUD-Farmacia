import axios from 'axios';

const API_URL = 'http://localhost:';

const categoriaService = {
  getAll: async () => {
    try {
      const response = await axios.get(`${API_URL}/categorias`);
      return response.data;
    } catch (error) {
      console.error('Erro ao obter categorias:', error);
      throw error;
    }
  },
  create: async (categoria) => {
    try {
      const response = await axios.post(`${API_URL}/categorias`, categoria);
      return response.data;
    } catch (error) {
      console.error('Erro ao criar categoria:', error);
      throw error;
    }
  },
  update: async (id, categoria) => {
    try {
      const response = await axios.put(`${API_URL}/categorias/${id}`, categoria);
      return response.data;
    } catch (error) {
      console.error('Erro ao atualizar categoria:', error);
      throw error;
    }
  },
  delete: async (id) => {
    try {
      const response = await axios.delete(`${API_URL}/categorias/${id}`);
      return response.data;
    } catch (error) {
      console.error('Erro ao deletar categoria:', error);
      throw error;
    }
  }
};

export default categoriaService;
