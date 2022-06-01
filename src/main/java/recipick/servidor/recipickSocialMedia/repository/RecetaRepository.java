package recipick.servidor.recipickSocialMedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import recipick.servidor.recipickSocialMedia.entity.Receta;



public interface RecetaRepository extends JpaRepository<Receta, Integer> {

	
}
