package br.com.borges;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Test;

import br.borges.com.dao.IProdutoDao;
import br.borges.com.dao.ProdutoDao;
import br.borges.com.domain.Produto;

public class ProdutoTest {

	 private IProdutoDao produtoDao;
	 
	 public ProdutoTest() {
		 produtoDao = new ProdutoDao();
	 }
	 
	 
	 @Test
	 public void cadastrar() {
		   
		 Produto prd = new Produto();
		 prd.setCodigo("A256");
		 prd.setNome("TV Samsung");
		 prd.setValor(3000d);
		 prd = produtoDao.cadastrar(prd);
		 
		 assertNotNull(prd);
		 assertNotNull(prd.getId());
		 
		 List<Produto> list = produtoDao.buscarTodos();
		 list.forEach(produto -> produtoDao.excluir(produto));
		 
	}
}
