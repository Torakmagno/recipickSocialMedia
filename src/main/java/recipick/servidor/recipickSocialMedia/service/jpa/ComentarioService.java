package recipick.servidor.recipickSocialMedia.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import recipick.servidor.recipickSocialMedia.entity.Comentario;
import recipick.servidor.recipickSocialMedia.repository.ComentarioRepository;
import recipick.servidor.recipickSocialMedia.service.IComentarioService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



@Service
@Primary
public class ComentarioService implements IComentarioService{

	@Autowired
	ComentarioRepository comentarioRepo;
	
	@Override
	public List<Comentario> buscarTodos() {
		
		return comentarioRepo.findAll();
	}

	@Override
	public Comentario buscarPorId(Integer idComentario) {
		Optional<Comentario> optional = comentarioRepo.findById(idComentario);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void guardar(Comentario comentario) {
		comentarioRepo.save(comentario);
		
	}


	@Override
	public void eliminar(Integer idComentario) {
		comentarioRepo.deleteById(idComentario);
	}

	
	
	
	

}
