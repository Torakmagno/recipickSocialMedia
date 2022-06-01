package recipick.servidor.recipickSocialMedia.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import recipick.servidor.recipickSocialMedia.entity.Receta;
import recipick.servidor.recipickSocialMedia.entity.Usuario;
import recipick.servidor.recipickSocialMedia.service.IRecetaService;
import recipick.servidor.recipickSocialMedia.service.IUsuarioService;
import recipick.servidor.recipickSocialMedia.service.jpa.RecetaService;
import recipick.servidor.recipickSocialMedia.service.jpa.UsuarioService;



@Controller
@RequestMapping
public class HomeController {
	
	@Autowired
	private RecetaService recetaService;
	
	@Autowired
	private UsuarioService usuarioService;
	

	
	/*@Autowired
	private PasswordEncoder passwordEncoder;*/
	
	@GetMapping("/")
	public String mostrarHome(Model model) {
		return "home";
	}
	

	
	@GetMapping("/users")
	public String mostrarUsuarios(Model model) {
		List<Usuario> lista = usuarioService.buscarTodos();
		model.addAttribute("usuarios", lista);
		
		return "listausuarios";
	}
	
	/* no se si va en home o en recetas, me imagino que en recetas para que podamos acceder una vez estemos en la lista
	@GetMapping("/detalle")
	public String mostrarDetalle(Model model) {
		Receta receta = new Receta();
		receta.setNombre("");
		receta.setDescripcion("");
		model.addAttribute("receta", receta);
		return "detalle";
	}*/
	
	/*@GetMapping("/userslist")
	public String mostrarListado(Model model) {
		List<String> lista = new LinkedList<String>();
		model.addAttribute("usuarios", lista);
		
		return "listausuarios";
	}*/
	
	@GetMapping("/signup")
	public String signup(Usuario usuario) {
		return "formRegistro";
	}
	
	/*@PostMapping("/signup")
	public String guardarRegistro(Usuario usuario, RedirectAttributes attributes) {
		
		String pwdPlano = usuario.getPassword();
		String psdEncriptado = passwordEncoder.encode(pwdPlano);
		usuario.setPassword(psdEncriptado);
		
		
		/**
		 * Guardamos el usuario en la base de datos.
		 
		UsuarioService.guardar(usuario);
				
		attributes.addFlashAttribute("msg", "El registro fue guardado correctamente!");
		
		return "redirect:/usuarios/index";
	}
	
	@GetMapping("/bcrypt/{texto}")
	@ResponseBody
	public String encriptar(@PathVariable("texto") String texto) {
		return texto + "Encriptado en Bcrypt: " + passwordEncoder.encode(texto);
		
	}*/
	
	@GetMapping("/login")
	public String mostrarLogin() {
		return "formLogin";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		SecurityContextLogoutHandler logoutHandler = 
		new SecurityContextLogoutHandler();
		
		logoutHandler.logout(request, null, null);
		
		return "redirect:/login";
	}
	
	
	/*@GetMapping("/index")
	public String mostrarIndex(Authentication auth, HttpSession session) {
		String username = auth.getName();
		System.out.println("Nombre de usuario:" + username);
		
		for(GrantedAuthority rol: auth.getAuthorities()) {
			System.out.println("Rol:" + rol.getAuthority());
		}
		Usuario usuario = UsuarioService.buscarPorUsername(username);
		
		if(session.getAttribute("usuario") == null) {
			Usuario usuario1 = UsuarioService.buscarPorUsername(username);
			usuario1.setPassword(null);
			System.out.println("Objeto usuario" + usuario1);
			session.setAttribute("usuario", usuario1);
			
		}
		
		return "redirect:/";
	}*/
	
	//con InitBinder, si detecta strings vacíos en el data binding los seteará a NULL
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
	
	

	
}
