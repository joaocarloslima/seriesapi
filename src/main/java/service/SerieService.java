package service;

import java.util.List;

import br.com.fiap.seriesapi.data.SerieDao;
import br.com.fiap.seriesapi.model.Serie;

public class SerieService {
	
	private SerieDao dao = new SerieDao();

	public List<Serie> findAll() {
		
		return dao.findAll();
	}

	public Serie findById(Long id) {
		return dao.findById(id);
	}

	public void delete(Serie serie) {
		// apagar do BD
		
	}

	public boolean save(Serie serie) {
		//validação
		if (serie.id() == 0) return false;
		if (serie.titulo().length() < 5) return false;
		if (serie.sinopse().length() < 10) return false;
		
		//inserir no BD
		return true;
		
	}

	public boolean update(Serie serie) {
		// atualizar no BD
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
