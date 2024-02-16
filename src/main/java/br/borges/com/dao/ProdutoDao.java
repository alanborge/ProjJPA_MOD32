package br.borges.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.borges.com.domain.Produto;

public class ProdutoDao implements IProdutoDao {

	@Override
	public Produto cadastrar(Produto prod) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("JPA_MOD32");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(prod);
		entityManager.getTransaction().commit();
		 
		entityManager.close();
		entityManagerFactory.close();
		
		
		return prod;
	}

	@Override
	public void excluir(Produto prod) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("JPA_MOD32");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		prod = entityManager.merge(prod);
		entityManager.remove(prod);
		entityManager.getTransaction().commit();
		 
		entityManager.close();
		entityManagerFactory.close();
		
	}

	@Override
	public List<Produto> buscarTodos() {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("JPA_MOD32");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
		Root<Produto> root = query.from(Produto.class);
		query.select(root);
		
		TypedQuery<Produto> tpQuery = 
				entityManager.createQuery(query);
		List<Produto> list = tpQuery.getResultList();  
		
		entityManager.close();
		entityManagerFactory.close();
		return list;
	}
  
}
