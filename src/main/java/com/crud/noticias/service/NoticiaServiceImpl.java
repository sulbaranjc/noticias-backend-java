package com.crud.noticias.service;

import com.crud.noticias.model.Noticia;
import com.crud.noticias.repository.NoticiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

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
    @Override
    public boolean existeNoticiaPorId(Long id) {
        return noticiaRepository.existsById(id);
    }

    @Override
    public Optional<Noticia> obtenerPrimerRegistro() {
        Pageable limit = PageRequest.of(0, 1);
        List<Noticia> noticias = noticiaRepository.findFirstByOrderByIdAsc(limit);
        if (!noticias.isEmpty()) {
            return Optional.of(noticias.get(0));
        } else {
            return Optional.empty();
        }
    }


    @Override
    public Optional<Noticia> obtenerSiguienteRegistro(Long id) {
        Pageable limit = PageRequest.of(0, 1);
        List<Noticia> noticiasSiguientes = noticiaRepository.findNextById(id, limit);
        if (noticiasSiguientes.isEmpty()) {
            // Si no hay registros siguientes, obtener el primer registro
            return obtenerPrimerRegistro();
        } else {
            // Devuelve el siguiente registro
            return Optional.of(noticiasSiguientes.get(0));
        }
    }


}