package dulcepasion.service.servicio;

import dulcepasion.service.Interfaces.UsuarioRepository;
import dulcepasion.service.modelo.Usuario;
import dulcepasion.service.utlis.BCrypt;
import dulcepasion.service.utlis.GenericResponse;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

import static dulcepasion.service.utlis.Global.*;

@Service
@Transactional
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }
    //iniciar sesión
    public GenericResponse<Usuario> login(String email, String contrasenia){
        
    	
    	 Optional<Usuario> optU1=this.repository.findByEmail(email);
    	 String contra=optU1.get().getClave();
    	 System.out.println(contra);
    	 if(BCrypt.checkpw(contrasenia, contra)){
    		 
    	Optional<Usuario> optU = this.repository.login(email, contra);
        if(optU.isPresent()){
            return new GenericResponse<Usuario>(TIPO_AUTH, RPTA_OK, "Has iniciado sesión correctamente", optU.get());
        }else{
            return new GenericResponse<Usuario>(TIPO_AUTH, RPTA_WARNING, "Datos incorrectos", new Usuario());
        }}
    	 else{
             return new GenericResponse<Usuario>(TIPO_AUTH, RPTA_WARNING, "Lo sentimos, ese usuario no existe",
            		 new Usuario());
         }
    	
    }
    //Registrar usuario y actualizar usuario
    public GenericResponse guardarUsuario(Usuario u){

        Optional<Usuario> optU = this.repository.findById(u.getId());
     
        u.setClave(BCrypt.hashpw(u.getClave(), BCrypt.gensalt()));
     
       
        int idf = optU.isPresent() ? optU.get().getId() : 0;        
        if(idf == 0){
            return new GenericResponse(TIPO_DATA, RPTA_OK, "Usuario Registrado Correctamente", this.repository.save(u));
        }else{
            return new GenericResponse(TIPO_DATA, RPTA_OK, "Datos del usuario actualizados", this.repository.save(u));
        }
    }
}
