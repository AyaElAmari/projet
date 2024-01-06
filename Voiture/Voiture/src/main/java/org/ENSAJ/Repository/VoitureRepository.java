package org.ENSAJ.Repository;

import org.ENSAJ.Model.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VoitureRepository extends JpaRepository<Voiture, Long> {

    @Query(value = "SELECT u FROM Voiture u WHERE u.id_client IN :clientId")
    List<Voiture> findByClientId(@Param("clientId") Long clientId);
}
