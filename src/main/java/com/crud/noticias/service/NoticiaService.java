package com.crud.noticias.service;

import com.crud.noticias.model.Noticia;
import java.util.List;
import java.util.Optional;

public interface NoticiaService {
    Noticia guardarNoticia(Noticia noticia);
    Optional<Noticia> obtenerNoticiaPorId(Long id);
    List<Noticia> listarTodasLasNoticias();
    Noticia actualizarNoticia(Noticia noticia);
    void eliminarNoticia(Long id);
}
