package recipick.servidor.recipickSocialMedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import recipick.servidor.recipickSocialMedia.entity.Usuario;
import recipick.servidor.recipickSocialMedia.service.IUsuarioService;



@Controller
@RequestMapping("/users")
public class UsuarioController {

    @Autowired
	private IUsuarioService UsuarioService;
    
   //@Autowired
    //private PasswordEncoder passwordEncoder;
    
   @GetMapping("/userslist")
	public String mostrarIndex(Model model) {
    	List<Usuario> lista = UsuarioService.buscarTodos();
    	model.addAttribute("usuarios", lista);
		return "listausuarios";
	}
   
   @GetMapping("users/delete/{id}")
  	public String eliminar(@PathVariable("id") int idUsuario, RedirectAttributes attributes) {		    	
  		// Eliminamos el usuario
      	UsuarioService.eliminar(idUsuario);			
  		attributes.addFlashAttribute("msg", "User deleted!");
  		return "redirect:/listausuarios";
  	}
   
  /* @GetMapping("/demo-bcrypt")
   public String pruebaBcrypt() {
	   String password = "mari123";
	   String encriptado = passwordEncoder.encode(password);
	   System.out.println("Password encriptado: " + encriptado);
	   return "usuarios/demo";
   } */
}
