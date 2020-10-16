package br.com.maratona.dev.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path(value = "/inscricao" )
public class InscricaoMaratonaResource {
	//Mock
	List<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	public void init() {
		pessoas.add(new Pessoa("Kleber",1));
		pessoas.add(new Pessoa("Marcus",2));
		pessoas.add(new Pessoa("Stag",3));
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("lista/inscritos")
	public List<Pessoa> matricula() {
		init();
		return pessoas;
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("find/inscrito/{id}")
	public Response matriculaPorId(@PathParam("id") String id) {
		init();
		for (Pessoa indice : pessoas) {
			if(indice.getMatricula().equals(new Integer(id))) {
				return Response.status(Status.OK).entity(indice).build();
			}
		}
		return Response.status(Status.NO_CONTENT).build();
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("remover/inscrito/{id}")
	public Response removerPorId(@PathParam("id") String id) {
		init();
		Pessoa remove = null;
		for (Pessoa indice : pessoas) {
			if(indice.getMatricula().equals(new Integer(id))) {
				remove = indice;
			}
		}
		if(pessoas.remove(remove)) {
			return Response.status(Status.OK).entity("Removido com sucesso!").build();
		}
		return Response.status(Status.NO_CONTENT).build();
	}
	
	
}
