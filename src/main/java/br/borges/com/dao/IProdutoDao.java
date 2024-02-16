package br.borges.com.dao;

import java.util.List;

import br.borges.com.domain.Produto;

public interface IProdutoDao {
   
	Produto cadastrar (Produto prod);
	
	void excluir(Produto prod);
	
	List<Produto>buscarTodos();
}
