package recipick.servidor.recipickSocialMedia.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String apellidos;
	private String email;
	private String password;
	private String username;
	
	@OneToMany(fetch = FetchType.EAGER) //un usuario puede tener varias recetas
	@JoinColumn(name = "usuarios")
	private List<Receta> recetas;
	
	@OneToMany //una receta puede tener varios likes
	@JoinTable(
		name = "like", 
		joinColumns = @JoinColumn(name ="idUsuario"),
		inverseJoinColumns = @JoinColumn(name ="idReceta")
	)
	private List<Receta> likes;
	
	public Usuario() {}


	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellidos() {
		return apellidos;
	}



	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Receta> getRecetas() {
		return recetas;
	}


	public void setRecetas(List<Receta> recetas) {
		this.recetas = recetas;
	}
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public List<Receta> getLikes() {
		return likes;
	}


	public void setLikes(List<Receta> likes) {
		this.likes = likes;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email
				+ ", password=" + password + ", username=" + username + ", recetas=" + recetas + ", likes=" + likes
				+ "]";
	}





	

}
