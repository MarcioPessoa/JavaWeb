package com.aliandro.agenda.api;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ws.rs.Path;

import com.aliandro.agenda.model.PetShop;

@Path("clientes")
@Singleton
@Startup
public class ClienteResource {

	@EJB
	private PetShop petShop;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response obterContatos(){
		List<Clientes> clientes = petShop.obterContatos();
		return Response.ok().entity(contatos).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response obterCliente( @PathParam("id") Long id ){
		Cliente cliente = petShop.obterCliente(id);
		return Response.ok().entity(cliente).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response cadastrarCliente( @FormParam("nome") String nome,
										@FormParam("telefone") String telefone,
										@FormParam("endereco") String endereco,
										@Context UriInfo uriInfo) throws URISyntaxException{
		
		Cliente c = new Cliente();
		c.setNome(nome);
		c.setTelefone(telefone);
		
		Cliente cliente = petShop.adicionarCliente(c);

		return Response.seeOther( new URI( uriInfo.getAbsolutePath().toString() + cliente.getId() )).build();
	}
	
	@DELETE
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response removerCliente( @PathParam("id") Long id ){
		
		Cliente cliente = new Cliente();
		contato.setId(id);
		
		petShop.removerCliente(cliente);;
		return Response.noContent().build();
	}
}
