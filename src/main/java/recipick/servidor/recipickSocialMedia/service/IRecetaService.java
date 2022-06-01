package recipick.servidor.recipickSocialMedia.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import recipick.servidor.recipickSocialMedia.entity.Receta;



public interface IRecetaService {
	List<Receta> buscarTodas();
	Receta guardar(Receta receta);
	void eliminar(int idReceta);
	Receta buscarPorId(int id);
	Page<Receta> buscarTodas(Pageable page);
}
	
	
	
