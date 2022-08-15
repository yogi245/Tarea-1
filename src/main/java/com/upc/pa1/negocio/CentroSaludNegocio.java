package com.upc.pa1.negocio;

import com.upc.pa1.entidades.CentroSalud;
import com.upc.pa1.repositorio.CentroSaludRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CentroSaludNegocio {
    @Autowired
    private CentroSaludRepositorio centroSaludRepositorio;
    public CentroSalud registrar(CentroSalud centroSalud){
        return centroSaludRepositorio.save(centroSalud);
    }
    public CentroSalud buscar(Long codigo) throws Exception{
        CentroSalud centroSalud;
        centroSalud = centroSaludRepositorio.findById(codigo).orElseThrow(() -> new Exception("No se encontró centro de salud"));
        return centroSalud;
    }
    public double calcularCalificacion(CentroSalud centroSalud){
        return (centroSalud.getCalificacionInfraestructura() * 0.35) + (centroSalud.getCalificacionServicio() * 0.65);
    }
    public List<CentroSalud> listado(){
        return centroSaludRepositorio.findAll();
    }
    public List<CentroSalud> listadoCalificacion(){
        List<CentroSalud> lista;
        lista = centroSaludRepositorio.findAll();
        for (CentroSalud centroSalud:lista){
            centroSalud.setCalificacion(calcularCalificacion(centroSalud));
        }
        return lista;
    }
    public List<CentroSalud> listadoTipoCentroSalud(String tipo){
        return centroSaludRepositorio.findByTipoStartingWith(tipo);
    }
    public CentroSalud obtenerCentroSaludAprobacion(Long codigo) throws Exception{
        CentroSalud centroSalud;
        centroSalud = buscar(codigo);
        centroSalud.setCalificacion(calcularCalificacion(centroSalud));
        return centroSalud;
    }
    public CentroSalud actualizarNombre(Long codigo, String nombre) throws Exception{
        CentroSalud centroSalud;
        centroSalud = buscar(codigo);
        centroSalud.setNombre(nombre);
        return centroSaludRepositorio.save(centroSalud);
    }
}
