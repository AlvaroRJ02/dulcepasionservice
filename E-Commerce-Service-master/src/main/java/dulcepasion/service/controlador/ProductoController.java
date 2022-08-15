package dulcepasion.service.controlador;

import dulcepasion.service.servicio.productoService;
import dulcepasion.service.utlis.GenericResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/producto")
public class ProductoController {
    private final productoService service;

    public ProductoController(productoService service) {
        this.service = service;
    }

    @GetMapping("/recomendado")
    public GenericResponse listarprodcutoRecomendados(){
        return this.service.listarproductoRecomendados();
    }
    
    @GetMapping
	public GenericResponse listarprodcutoRecomendados2(){
        return this.service.listarproducto();
    }
    @GetMapping("/{idC}")
    public GenericResponse listarproductoPorCategoria(@PathVariable int idC){
        return this.service.listarproductoPorCategoria(idC);
    }
}
