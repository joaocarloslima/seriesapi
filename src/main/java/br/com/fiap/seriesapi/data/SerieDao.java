package br.com.fiap.seriesapi.data;

import java.util.List;

import br.com.fiap.seriesapi.model.Serie;

public class SerieDao {
	
	public List<Serie> findAll(){
		return List.of(
				new Serie(1, "Lost", "Um aviao cai", "http.."),
				new Serie(1, "Os outros", "Só tratamento top", "http.."),
				new Serie(1, "Treata", "Começa batendo", "http..")
			);
	}

}
