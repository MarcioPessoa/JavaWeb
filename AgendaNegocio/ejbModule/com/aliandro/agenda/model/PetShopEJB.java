package com.aliandro.agenda.model;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class PetShopEJB implements PetShop {

	@PersistenceContext
	private EntityManager em;
	
	@PostConstruct
	public void depoisDaCriacao(){
		System.out.println("[EJB] PostConstruct!");
	}
	
	@PreDestroy
	public void antesDaDestruicao(){
		System.out.println("[EJB] PreDestroy!");
	}
	
	public PetShopEJB() {
		System.out.println("[EJB] Fui criado!");
		
	}
	
	public Cliente adicionarCliente( Cliente cliente ){
		em.persist(cliente);
		return cliente;
	}
	
	public Pets adicionarPet( Pets pet ){
		em.persist(pet);
		return pet;
	}
	
	public void removerCliente( Cliente cliente ){
		Cliente gerenciado = em.find(Cliente.class, cliente.getId());
		em.remove(gerenciado);
	}
	
	public void removerPet( Pets pet ){
		Pets gerenciado = em.find(Pets.class, pet.getId());
		em.remove(gerenciado);
	}
	
	public void atualizarCliente( Cliente cliente ){
		em.merge(cliente);
	}
	
	public void atualizarPet( Pets pet ){
		em.merge(pet);
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> obterClientes(){
		Query query = em.createQuery("Select c from Cliente c");
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Pets> obterPets(){
		Query query = em.createQuery("Select p from Pets p");
		return query.getResultList();
	}
	
	@Override
	public Cliente obterCliente(Long id) {
		Cliente cliente = em.find(Cliente.class, id);
		return cliente;
	}
	
	@Override
	public Pets obterPet(Long id) {
		Pets pet = em.find(Pets.class, id);
		return pet;
	}
}
