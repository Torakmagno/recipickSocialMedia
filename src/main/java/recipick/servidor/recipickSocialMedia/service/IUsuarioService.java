package recipick.servidor.recipickSocialMedia.service;

import java.util.List;

import recipick.servidor.recipickSocialMedia.entity.Usuario;



public interface IUsuarioService {
	List<Usuario> buscarTodos();

	Usuario guardar(Usuario usuario);
	void eliminar(int idUsuario);
	
	void like(int idReceta, Usuario usuario);
	void dislike(int idReceta, Usuario usuario);

	Usuario buscarPorUsername(String username);
	
}

