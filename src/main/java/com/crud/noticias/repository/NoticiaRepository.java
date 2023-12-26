package com.crud.noticias.repository;

import com.crud.noticias.model.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, Long> {
    // Aquí puedes definir métodos de búsqueda personalizados si es necesario
}
