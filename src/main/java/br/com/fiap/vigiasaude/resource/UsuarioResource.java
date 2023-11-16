package br.com.fiap.vigiasaude.resource;

import br.com.fiap.vigiasaude.model.Usuario;
import br.com.fiap.vigiasaude.service.UsuarioService;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("vigia-saude")
public class UsuarioResource {
	
	UsuarioService userService = new UsuarioService();
	
	@POST
	@Path("cadastro-usuario")
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastraUsuario(Usuario usuario) {
		if (userService.existeUsuario(usuario)) return Response.status(Response.Status.CONFLICT).entity("Email em uso.").build();
		if (!userService.cadastrarUsuario(usuario)) return Response.status(Response.Status.BAD_REQUEST).entity("Requisição Inválida.").build();
		return Response.ok(usuario).build();
	}
	
	@POST
	@Path("login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(Usuario usuario) {
		userService.validaUsuario(usuario);
		return Response.ok().build();
	}
	
	
	
}
