package recipick.servidor.recipickSocialMedia.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConf extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("SELECT username, password,1 as enabled from usuarios where username=?")
				.authoritiesByUsernameQuery("select username,authority "
				        + "from authorities "
				        + "where username = ?");
				//.authoritiesByUsernameQuery("select u.username, p.perfil from UsuarioPerfil up "
						//+ "inner join Usuarios u on u.id = up.idUsuario "
						//+ "inner join Perfiles p on p.id = up.idPerfil " + "where u.username = ?");
	}
	


/*@Override
protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests().antMatchers("/bootstrap/**", 
										"/images/**",
										"/tinymce/**",
										"/logos/**").permitAll().antMatchers("/", 
																			"/signup",														
																			"/bcrypt/**",
																			"/home/recipes/**").permitAll().antMatchers("/recipes/**").hasAnyAuthority("USER","ADMIN")
																											.antMatchers("/users/**").hasAnyAuthority("ADMIN")
																											.antMatchers("/recipes/create/**").hasAnyAuthority("USER","ADMIN")
																											.antMatchers("/recipes/save/**").hasAnyAuthority("USER","ADMIN")
																											.antMatchers("/recipes/delete/**").hasAnyAuthority("ADMIN")
																											.antMatchers("/recipes/edit/**").hasAnyAuthority("USER","ADMIN")
																											
																											.anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll();
}
}


  @Bean
 
public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
}

}
*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
				.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/images/**").permitAll()
				.antMatchers("/css/**").permitAll()
				.antMatchers("/signup/**").permitAll()
				.antMatchers("/users/**").hasAuthority("ADMIN")
				.antMatchers("/**").authenticated()
        		.and().formLogin();
    }

  

    /* @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication()
                    .withUser("usuario1")
                    .password("1234")
                    .authorities("USER")
                    .and()
                    .withUser("usuario2")
                    .password("1234")
                    .authorities("USER");
        }
        */
    @Bean
     public PasswordEncoder passwordEncoder() {
         return NoOpPasswordEncoder.getInstance();
     }
} 