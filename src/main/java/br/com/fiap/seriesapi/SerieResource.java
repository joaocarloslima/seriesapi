package br.com.fiap.seriesapi;

import java.util.List;

import br.com.fiap.seriesapi.model.Serie;
import jakarta.ws.rs.GET;
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
    
    
    
    
    
    
    
    
    
    
}
