package recipick.servidor.recipickSocialMedia.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="recetas")
public class Receta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String descripcion;
	private String ingredientes;
	private String imagen;
	@Transient
	private int idRecetaOriginal;
	
	@ManyToOne(fetch = FetchType.EAGER) //una receta puede tener varias recetas derivadas pero una receta solo puede derivar de una original
	@JoinColumn(name="recetaOriginal")
	private Receta recetaOriginal;
	
	@ManyToOne(fetch = FetchType.EAGER) //un usuario puede tener varias recetas pero una receta solo pertenece a un usuario
	@JoinColumn(name="usuarios")
	private Usuario usuario;
	
	//@OneToMany(fetch = FetchType.EAGER) //una receta puede tener varios comentarios
	//@JoinColumn(name = "idReceta")
	//private List<Comentario> comentarios;
	
	@OneToMany //una receta puede tener varios likes
	@JoinTable(
		name = "likes", 
		joinColumns = @JoinColumn(name ="idReceta"),
		inverseJoinColumns = @JoinColumn(name ="idUsuario")
	)
	private List<Usuario> likes;
	
	public Receta() {}


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


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Receta getRecetaOriginal() {
		return recetaOriginal;
	}


	public void setRecetaOriginal(Receta recetaOriginal) {
		this.recetaOriginal = recetaOriginal;
	}

	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/*public List<Comentario> getComentarios() {
		return comentarios;
	}


	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	} */

	public List<Usuario> getLikes() {
		return likes;
	}


	public void setLikes(List<Usuario> likes) {
		this.likes = likes;
	}


	public int getIdRecetaOriginal() {
		return idRecetaOriginal;
	}


	public void setIdRecetaOriginal(int idRecetaOriginal) {
		this.idRecetaOriginal = idRecetaOriginal;
	}


	public String getIngredientes() {
		return ingredientes;
	}


	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}


	

	@Override
	public String toString() {
		return "Receta [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", ingredientes="
				+ ingredientes + ", imagen=" + imagen + ", idRecetaOriginal=" + idRecetaOriginal + ", recetaOriginal="
				+ recetaOriginal + ", usuario=" + usuario + ", likes=" + likes + "]";
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	

}
