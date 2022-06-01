package recipick.servidor.recipickSocialMedia.service;

import java.util.List;

import recipick.servidor.recipickSocialMedia.entity.Comentario;



public interface IComentarioService {
	
	void guardar(Comentario comentario);
	
	List<Comentario> buscarTodos();
	
	Comentario buscarPorId(Integer idComentario);	
	
	void eliminar(Integer idComentario);
}