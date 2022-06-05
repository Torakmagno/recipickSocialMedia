package recipick.servidor.recipickSocialMedia.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import recipick.servidor.recipickSocialMedia.entity.Receta;
import recipick.servidor.recipickSocialMedia.entity.Usuario;
import recipick.servidor.recipickSocialMedia.service.IRecetaService;
import recipick.servidor.recipickSocialMedia.service.IUsuarioService;



@Controller
@RequestMapping("/home")
public class RecetaController {
	
	@Autowired
   	private IRecetaService RecetaService;
	
	@Autowired
   	private IUsuarioService UsuarioService;
	
	//@Value("${recipick.ruta}")
	//private String ruta;
	
	/*@PostMapping("/recipes")
	public String mostrarIndex(Model model) {
		List<Receta> lista = RecetaService.buscarTodas();
    	model.addAttribute("receta", lista);
		return "listarecetas";		
	}*/
	
	@GetMapping("/recipes/create")
	public String crear(Receta receta) {
		return "crearrecetas";
	}
	
	@PostMapping("/recipes/save")
	public String guardar(Receta receta, BindingResult result, RedirectAttributes attributes,Authentication auth) {
		Usuario usuario=UsuarioService.buscarPorUsername(auth.getName());
		if (result.hasErrors()){		
			System.out.println("Existing errors!");
			return "redirect :/recipes";
		}	
		
		Receta recetaOriginal= RecetaService.buscarPorId(receta.getIdRecetaOriginal());
		receta.setRecetaOriginal(recetaOriginal);
		receta.setUsuario(usuario);
		
		// Guadamos el objeto receta en la bd
		RecetaService.guardar(receta);
		attributes.addFlashAttribute("msg", "Correctly saved!!");		
		return "redirect :/recipes";
	}
	
	@GetMapping("/recipes/delete/{id}")
	public String eliminar(@PathVariable("id") int idReceta, RedirectAttributes attributes) {
		System.out.println("Deleting recipe with id: " + idReceta);
		RecetaService.eliminar(idReceta);
		attributes.addFlashAttribute("msg","Recipe correctly deleted");
		return "redirect :/recipes";
	}
	
	@GetMapping("/recipes/edit/{id}")
	public String editar(@PathVariable("id") int idReceta, Model model) {
		System.out.println("Editing recipe with id: " + idReceta);
		//Obtenemos el objeto que queremos editar
		Receta receta = RecetaService.buscarPorId(idReceta);
		//referenciamos la receta original
		receta.setIdRecetaOriginal(receta.getId());
		//metemos el objeto receta en el modelo para enviárselo al formulario
		model.addAttribute("receta",receta);
		//devolvemos el formulario con la información de la receta escogida
		return "editarreceta";
	}
	
	@GetMapping("/recipes")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Receta> lista = RecetaService.buscarTodas(page);
		model.addAttribute("recetas", lista);
		return "listarecetas";
	}
	
	
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	
	}
	
}
