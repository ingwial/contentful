package alvarez.wilfredo.contenful.controllers;

import com.contentful.java.cda.CDAArray;
import com.contentful.java.cda.CDAResource;
import alvarez.wilfredo.contenful.deliveries.ContenfulDelivery;
import alvarez.wilfredo.contenful.models.PeliculaEntryModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PeliculaController {
    private final Logger log = LoggerFactory.getLogger(PeliculaController.class);
    private final ContenfulDelivery delivery;

    public PeliculaController(ContenfulDelivery delivery) {
        this.delivery = delivery;
    }

    @GetMapping(value = "/peliculas")
    public ResponseEntity<Object> getAll() {
        CDAArray all = this.delivery.all();
        log.info("data: {}", all);
        List<String> stringList = new ArrayList<>();
        for (CDAResource resource : all.items()) {
            log.info("resource: {}", resource.type().toString());
            stringList.add(resource.id());
        }
        return ResponseEntity.ok(stringList);
    }

    @GetMapping(value = "/peliculas/{id}")
    public ResponseEntity<PeliculaEntryModel> getOne(@PathVariable("id") String id) {
        PeliculaEntryModel one = this.delivery.one(id);
        log.info("getTitulo: {}", one.getTitulo());
        return ResponseEntity.ok(one);
    }

}
