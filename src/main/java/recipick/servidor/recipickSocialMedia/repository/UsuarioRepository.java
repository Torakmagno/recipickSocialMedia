package recipick.servidor.recipickSocialMedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import recipick.servidor.recipickSocialMedia.entity.Usuario;



public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	public Usuario findByUsername(String username);
}
