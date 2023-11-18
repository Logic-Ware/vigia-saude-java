package br.com.fiap.vigiasaude.resource;

import br.com.fiap.vigiasaude.model.Unidade;
import br.com.fiap.vigiasaude.service.UnidadeService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("hospital")
public class UnidadeResource {

	UnidadeService service = new UnidadeService();
	
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it! - Unidade";
    }
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarUnidade(@PathParam("id") Long id){
		var hospital = service.buscarPorId(id);
		if (hospital == null) return Response.status(Response.Status.NOT_FOUND).entity("Não Encontrado").build();
		return Response.ok().build();
		
	}
	
	@POST
	@Path("cadastro")
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrar(Unidade unidade) {
		if (service.existeUnidade(unidade)) return Response.status(Response.Status.CONFLICT).entity("Email em uso.").build();
		if (!service.cadastrar(unidade)) return Response.status(Response.Status.BAD_REQUEST).entity("Requisição Inválida.").build();
		return Response.ok(unidade).build();
	}
	
	@POST
	@Path("login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(Unidade unidade) {
		if(!service.validaUnidade(unidade)) 
			return Response.status(Response.Status.NOT_FOUND).entity("Não Encontrado").build();
		return Response.ok().build();
	}
}
