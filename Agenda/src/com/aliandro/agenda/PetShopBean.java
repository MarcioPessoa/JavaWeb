package com.aliandro.agenda;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.aliandro.agenda.model.Cliente;
import com.aliandro.agenda.model.PetShop;
import com.aliandro.agenda.model.Pets;

//Classe de controller. Tem que ter dois Bean cliente e Pets

@ManagedBean
@RequestScoped
public class PetShopBean {
	

	private Pets pets;
	private Cliente cliente;
	@EJB
	private PetShop petShop;
		
	public PetShopBean() {
		this.pets = new Pets();
		this.cliente = new Cliente();
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public Pets getPet() {
		return pets;
	}
	
	public String cadastrarCliente(){
		petShop.adicionarCliente(this.cliente);
		return "listarClientes";
	}
	
	public String cadastrarPet(){
		petShop.adicionarPet(this.pets);
		return "listarPets";
	}
	
	public List<Cliente> getClientes(){
		return petShop.obterClientes();
	}
	
	public List<Pets> getPets(){
		return petShop.obterPets();
	}
	
	public String excluirCliente(Cliente cliente){
		petShop.removerCliente(cliente);
		return "qualquercoisapraficarnamesmapagina";
	}
	
	public String excluirPet(Pets pet){
		petShop.removerPet(pet);
		return "qualquercoisapraficarnamesmapagina";
	}
}
