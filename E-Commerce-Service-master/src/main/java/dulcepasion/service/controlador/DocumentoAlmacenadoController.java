package dulcepasion.service.controlador;

import dulcepasion.service.modelo.DocumentoAlmacenado;
import dulcepasion.service.servicio.DocumentoAlmacenadoService;
import dulcepasion.service.utlis.GenericResponse;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/documento-almacenado")
public class DocumentoAlmacenadoController {
    private DocumentoAlmacenadoService service;

    public DocumentoAlmacenadoController(DocumentoAlmacenadoService service) {
        this.service = service;
    }
    //listar archivos almacenados
    @GetMapping
    public GenericResponse list() {
        return service.list();
    }
    //listar archivo por id
    @GetMapping("/{id}")
    public GenericResponse find(@PathVariable Long id) {
        return null;
    }
    //descargar archivo
    @GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> download(@PathVariable String fileName, HttpServletRequest request) {
        return service.downloadByFileName(fileName, request);
    }
    //guardar archivo
    @PostMapping
    public GenericResponse save(@ModelAttribute DocumentoAlmacenado obj) {
        return service.save(obj);
    }
    //actualizar archivo
    public GenericResponse update(Long aLong, DocumentoAlmacenado obj) {
        return null;
    }
    
    public GenericResponse delete(Long aLong) {
        return null;
    }
}
