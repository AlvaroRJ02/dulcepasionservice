package dulcepasion.service.controlador;

import dulcepasion.service.modelo.Usuario;
import dulcepasion.service.servicio.UsuarioService;
import dulcepasion.service.utlis.GenericResponse;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }
    //inicio de sesión
    @PostMapping("/login")
    public GenericResponse<Usuario> login(HttpServletRequest request){
        String email = request.getParameter("email");
        String contrasenia = request.getParameter("pass");
        return this.service.login(email, contrasenia);
    }
    //Guardar nuevo usuario
    @PostMapping
    public GenericResponse save(@RequestBody Usuario u){
        return this.service.guardarUsuario(u);
    }
    //actualizar usuario
    @PutMapping("/{id}")
    public GenericResponse update(@PathVariable int id, @RequestBody Usuario u){
        return this.service.guardarUsuario(u);
    }
}
