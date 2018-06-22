package com.aliandro.agenda.model;

import java.util.List;

//Chama interface de PetShopEJB onde tem os metodos
public interface PetShop {

	public Cliente adicionarCliente( Cliente cliente);
	
	public Pets adicionarPet( Pets pet);
	
	public void removerCliente( Cliente cliente );
	
	public void removerPet( Pets pet );
	
	public void atualizarCliente( Cliente cliente );
	
	public void atualizarPet( Pets pet );

	public List<Cliente> obterClientes();
	
	public List<Pets> obterPets();
	
	public Cliente obterCliente( Long id );
	
	public Pets obterPet( Long id );
}
