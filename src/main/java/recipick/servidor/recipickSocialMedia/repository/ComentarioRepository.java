package recipick.servidor.recipickSocialMedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import recipick.servidor.recipickSocialMedia.entity.Comentario;



public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {

}
