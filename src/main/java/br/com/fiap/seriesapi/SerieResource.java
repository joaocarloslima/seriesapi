package br.com.fiap.seriesapi;

import java.util.List;

import br.com.fiap.seriesapi.model.Serie;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import service.SerieService;

@Path("serie")
public class SerieResource {
	
	private SerieService service = new SerieService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Serie> listAll() {
        return service.findAll(); 
    }
}
