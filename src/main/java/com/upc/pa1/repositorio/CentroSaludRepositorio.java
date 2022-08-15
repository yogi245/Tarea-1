package com.upc.pa1.repositorio;

import com.upc.pa1.entidades.CentroSalud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CentroSaludRepositorio extends JpaRepository<CentroSalud, Long> {
    public List<CentroSalud>findByTipoStartingWith(String tipo);
}
