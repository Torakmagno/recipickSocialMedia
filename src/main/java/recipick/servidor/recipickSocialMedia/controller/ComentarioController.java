package recipick.servidor.recipickSocialMedia.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import recipick.servidor.recipickSocialMedia.entity.Comentario;
import recipick.servidor.recipickSocialMedia.entity.Receta;
import recipick.servidor.recipickSocialMedia.service.IComentarioService;
import recipick.servidor.recipickSocialMedia.service.IRecetaService;

@Controller
@RequestMapping("/text")
public class ComentarioController {
	
	@Autowired
   	private IComentarioService ComentarioService;
	
	@PostMapping("/commentslist")
	public String mostrarIndex(Model model) {
		List<Comentario> lista = ComentarioService.buscarTodos();
    	model.addAttribute("comentario", lista);
		return "listacomentarios";		
	}
	
	@PostMapping("/comments/create")
	public String crear(Receta receta) {
		return "crearrecetas";
	}
	
	@PostMapping("/comments/save")
	public String guardar(Comentario comentario, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()){		
			System.out.println("Existing errors!");
			return "crearcomentario";
		}	
		
		// Guadamos el objeto receta en la bd
		ComentarioService.guardar(comentario);
		attributes.addFlashAttribute("msg", "Comment saved");		
		return "redirect:/recipes";
	}
	
	@GetMapping("/comments/delete/{id}")
	public String eliminar(@PathVariable("id") int idComentario, RedirectAttributes attributes) {
		System.out.println("Deleting comment with id: " + idComentario);
		ComentarioService.eliminar(idComentario);
		attributes.addFlashAttribute("msg","Comment correctly deleted");
		return "redirect:/recetas";
	}
	
	@GetMapping("/recipes/edit/{id}")
	public String editar(@PathVariable("id") int idComentario, Model model) {
		System.out.println("Editing recipe with id: " + idComentario);
		//Obtenemos el objeto que queremos editar
		Comentario comentario = ComentarioService.buscarPorId(idComentario);
		//metemos el objeto receta en el modelo para enviárselo al formulario
		model.addAttribute("comentario",comentario);
		//devolvemos el formulario con la información de la receta escogida
		return "editarcomentario";
	}
	
	
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	
	}
	
}


