package recipick.servidor.recipickSocialMedia.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recipick.servidor.recipickSocialMedia.entity.Usuario;
import recipick.servidor.recipickSocialMedia.repository.UsuarioRepository;
import recipick.servidor.recipickSocialMedia.service.IUsuarioService;



@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private UsuarioRepository repoUsuario;
	
	@Override
	public List<Usuario> buscarTodos(){
		return repoUsuario.findAll();
		
	}

	@Override
	public Usuario guardar(Usuario usuario) {
		
		return repoUsuario.save(usuario);
	}

	@Override
	public void eliminar(int isUsuario) {
		repoUsuario.deleteById(isUsuario);
		
	}

	@Override
	public void like(int idReceta, Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dislike(int idReceta, Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario buscarPorUsername(String username) {
		
		return this.repoUsuario.findUsuarioByUsername(username);
	}

}
