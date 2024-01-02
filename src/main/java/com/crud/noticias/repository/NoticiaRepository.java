package com.crud.noticias.repository;

import com.crud.noticias.model.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;



@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, Long> {
    // Aquí puedes definir métodos de búsqueda personalizados si es necesario
    // Utiliza JPQL o SQL para obtener el primer registro
    @Query("SELECT n FROM Noticia n ORDER BY n.id ASC")
    List<Noticia> findFirstByOrderByIdAsc(Pageable pageable);

    // Utiliza JPQL o SQL para obtener el siguiente registro
    @Query(value = "SELECT n FROM Noticia n WHERE n.id > :id ORDER BY n.id ASC")
    List<Noticia> findNextById(Long id, Pageable pageable);
}
