package recipick.servidor.recipickSocialMedia.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/*@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	@Value("${springMVC.ruta.imagenes}")
	private String rutaImagenes;
	
	public void addResourceHandlers (ResourceHandlerRegistry registry) {
		//registry.addResourceHandler("/logos/**").addResourceLocations("file:/empleos/img-vacantes/"); //Linux & iOs
		registry.addResourceHandler("/logos/**").addResourceLocations("file:c:/empleos/img-vacantes/"); //Windows
		//registry.addResourceHandler("/logos/**").addResourceLocations("file:"+rutaImagenes); //Windows
	}
}
//Si por ejemplo, tenemos la imagen de nombre logo.png en el directorio c:/empleos/img-vacantes, podríamos acceder a ella
//mediante la URL http:/localhost:8080/logos/logo.png */