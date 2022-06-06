package recipick.servidor.recipickSocialMedia.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import recipick.servidor.recipickSocialMedia.entity.Receta;
import recipick.servidor.recipickSocialMedia.repository.RecetaRepository;
import recipick.servidor.recipickSocialMedia.service.IRecetaService;



@Service
public class RecetaService implements IRecetaService {

	@Autowired
	private RecetaRepository repoReceta;
	
	@Override
	public List<Receta> buscarTodas(){
		return repoReceta.findAll();
		
	}

	@Override
	public Receta guardar(Receta receta) {
		
		return repoReceta.save(receta);
	}

	@Override
	public void eliminar(int idReceta) {
		repoReceta.deleteById(idReceta);
		
	}

	@Override
	public Receta buscarPorId(int id) {
		return this.repoReceta.findById(id);
	}

	@Override
	public Page<Receta> buscarTodas(Pageable page) {
		
		return this.repoReceta.findAll(page);
	}
	

}
