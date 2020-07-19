package com.proyecto.rest.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.proyecto.rest.dao.ComprobanteModel;
import com.proyecto.rest.dao.UsuarioModel;
import com.proyecto.rest.entidades.Comprobante;
import com.proyecto.rest.entidades.Usuario;

@Path("/services")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })


public class ServicioRest {

	private static final Log log = LogFactory.getLog(ServicioRest.class);
	private UsuarioModel daoUser = new UsuarioModel();
	private ComprobanteModel daoCom = new ComprobanteModel();


	@GET
	@Path("/usuario")
	public Response listarTodos() {
		log.info("listarTodos ");
		return Response.ok(daoUser.listarTodos()).build();
	}

	@POST
	@Path("/usuario")
	public Response registraUsuario(Usuario usu) {
		log.info("addUsuario " + usu.getIdUsuario());
		if(daoUser.addUsuario(usu) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}
	
	@PUT
	@Path("/usuario")
	public Response atualizaUsuario(Usuario obj) {
		log.info("actualizaUsuario " + obj.getIdUsuario());
		if (daoUser.actualizaUsuario(obj) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}
	
	@DELETE
	@Path("/usuario/{idUsuario}")
	public Response eliminaUsuario(@PathParam("idUsuario") int id) {
		log.info("eliminaUsuario " + id);
		if (daoUser.eliminaUsuario(id) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}
	
	
	/*----------------------------------------------------------------------*/
	
	
	@GET
	@Path("/comprobante")
	public Response listarComprobante() {
		log.info("ListarComprobante ");
		return Response.ok(daoCom.listaComprobante()).build();
	}
	@POST
	@Path("/comprobante")
	public Response registraComprobante(Comprobante usu) {
		log.info("addComprobante " + usu.getIdcomprobante());
		if(daoCom.addComprobante(usu) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}
	
	@PUT
	@Path("/comprobante")
	public Response atualizaComprobante(Comprobante obj) {
		log.info("actualizaComprobantesuario " + obj.getIdcomprobante());
		if (daoCom.actualizaComprobante(obj) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}
	
	@DELETE
	@Path("/comprobante/{idcomprobante}")
	public Response eliminaComprobante(@PathParam("idcomprobante") int id) {
		log.info("eliminaComprobante " + id);
		if (daoCom.eliminaComprobante(id) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}
	
	
}
