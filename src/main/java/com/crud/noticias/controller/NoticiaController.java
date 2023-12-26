package com.crud.noticias.controller;

import com.crud.noticias.model.Noticia;
import com.crud.noticias.service.NoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/noticias")
public class NoticiaController {

    private final NoticiaService noticiaService;

    @Autowired
    public NoticiaController(NoticiaService noticiaService) {
        this.noticiaService = noticiaService;
    }

    @PostMapping
    public Noticia crearNoticia(@RequestBody Noticia noticia) {
        return noticiaService.guardarNoticia(noticia);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Noticia> obtenerNoticiaPorId(@PathVariable Long id) {
        return noticiaService.obtenerNoticiaPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Noticia> listarNoticias() {
        return noticiaService.listarTodasLasNoticias();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Noticia> actualizarNoticia(@PathVariable Long id, @RequestBody Noticia noticia) {
        return noticiaService.obtenerNoticiaPorId(id)
                .map(noticiaExistente -> {
                    noticia.setId(noticiaExistente.getId());
                    return ResponseEntity.ok(noticiaService.actualizarNoticia(noticia));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarNoticia(@PathVariable Long id) {
        return noticiaService.obtenerNoticiaPorId(id)
                .map(noticia -> {
                    noticiaService.eliminarNoticia(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
