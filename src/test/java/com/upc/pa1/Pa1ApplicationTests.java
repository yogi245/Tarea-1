package com.upc.pa1;

import com.upc.pa1.entidades.CentroSalud;
import com.upc.pa1.negocio.CentroSaludNegocio;
import com.upc.pa1.repositorio.CentroSaludRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Pa1ApplicationTests {
    @Autowired
    private CentroSaludNegocio centroSaludNegocio;

    @Test
    void contextLoads() {
    }

    @Test
    public void probarRegistro(){
        CentroSalud centroSalud = new CentroSalud();
        centroSalud.setNombre("Hospital 2 de Mayo");
        centroSalud.setTipo("Hospital");
        centroSalud.setCalificacionInfraestructura(65);
        centroSalud.setCalificacionServicio(50);
        centroSalud.setAmbulancia("SI");
        centroSaludNegocio.registrar(centroSalud);
    }

    @Test
    public void probarListado(){
        List<CentroSalud> listado;
        listado = centroSaludNegocio.listado();
        for (CentroSalud centroSalud:listado){
            System.out.println(centroSalud.getCodigo()+" "+centroSalud.getNombre());
        }
        Assertions.assertNotNull(listado);
    }

    @Test
    public void probarListadoCalificacion(){
        List<CentroSalud> listado;
        listado = centroSaludNegocio.listadoCalificacion();
        for (CentroSalud centroSalud:listado){
            System.out.println(centroSalud.getCodigo()+" "+centroSalud.getNombre()+" "+centroSalud.getCalificacion());
        }
        Assertions.assertNotNull(listado);
    }

    @Test
    public void probarListadoTipoCentroSalud(){
        List<CentroSalud> listado;
        listado = centroSaludNegocio.listadoTipoCentroSalud("Hospital");
        for (CentroSalud centroSalud:listado){
            System.out.println(centroSalud.getCodigo()+" "+centroSalud.getNombre()+" - "+centroSalud.getTipo());
        }
        Assertions.assertNotNull(listado);
    }

    @Test
    public void probarObtenerCentroSaludAprobacion(){
        try {
            CentroSalud centroSalud;
            centroSalud = centroSaludNegocio.obtenerCentroSaludAprobacion(3L);
            System.out.println(centroSalud.getCodigo());
            System.out.println(centroSalud.getNombre());
            System.out.println(centroSalud.getCalificacion());
            if(centroSalud.getCalificacion() > 80) {
                System.out.println("Aprobado");
            } else {
                System.out.println("Rechazado");
            }

            Assertions.assertNotNull(centroSalud);
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }

    @Test
    public void probarActualizarNombre(){
        try {
            CentroSalud centroSalud;
            centroSalud = centroSaludNegocio.actualizarNombre(1L, "Hospital Vitarte");
            System.out.println(centroSalud.getCodigo()+" "+centroSalud.getNombre());
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
}
