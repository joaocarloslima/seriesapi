package br.com.fiap.seriesapi;

import java.util.List;

import br.com.fiap.seriesapi.model.Serie;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import service.SerieService;

@Path("serie")
public class SerieResource {
	
	private SerieService service = new SerieService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Serie> listAll() {
        return service.findAll(); 
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
    	var serie = service.findById(id);
    	    	
    	if (serie == null) {
    		return Response.status(404).build();
    	}
    	
    	return Response.ok(serie).build();
    }
    
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
    	var serie = service.findById(id);
    	
    	if(serie == null)
    		return Response.status(404).build();
    	
    	service.delete(serie);
    	return Response.status(Response.Status.NO_CONTENT).build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastrar(Serie serie){
    	if (!service.save(serie)) {
    		return Response.status(Response.Status.BAD_REQUEST).build();
    	}
    	
    	return Response.ok(serie).build();
    	
    }
    
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(@PathParam("id") Long id, Serie serie) {
    	var serieEncontrada = service.findById(id);
    	
    	if(serieEncontrada == null)
    		return Response.status(Response.Status.NOT_FOUND).build();
    			
    			
    	if (!service.update(serie))
    		return Response.status(Response.Status.BAD_REQUEST).build();
    	
    	return Response.ok(serie).build();
    	
    }
    
    
    
    
    
    
    
    
    
    
    
}
