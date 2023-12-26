package com.crud.noticias.service;

import com.crud.noticias.model.Noticia;
import com.crud.noticias.repository.NoticiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoticiaServiceImpl implements NoticiaService {

    private final NoticiaRepository noticiaRepository;

    @Autowired
    public NoticiaServiceImpl(NoticiaRepository noticiaRepository) {
        this.noticiaRepository = noticiaRepository;
    }

    @Override
    public Noticia guardarNoticia(Noticia noticia) {
        return noticiaRepository.save(noticia);
    }

    @Override
    public Optional<Noticia> obtenerNoticiaPorId(Long id) {
        return noticiaRepository.findById(id);
    }

    @Override
    public List<Noticia> listarTodasLasNoticias() {
        return noticiaRepository.findAll();
    }

    @Override
    public Noticia actualizarNoticia(Noticia noticia) {
        return noticiaRepository.save(noticia);
    }

    @Override
    public void eliminarNoticia(Long id) {
        noticiaRepository.deleteById(id);
    }
}
