package com.infosis.hotel.core.services;


import com.infosis.hotel.core.dto.HabitacionResponse;
import com.infosis.hotel.core.entities.HabitacionEntity;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import com.infosis.hotel.core.services.contract.IHotelService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Johnniray Betancourt
 */

@Service
public class HabitacionServices implements IHotelService {
    
    private static final Logger LOG = Logger.getLogger(HabitacionServices.class);
     
    @Override
    public List<HabitacionResponse> getHabitaciones(String estado, String tipo) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hotel");
        EntityManager em = emf.createEntityManager();
        String consulta = "SELECT H.ID,H.NOMBRE,T.DESCRIPCION TIPO,T.OCUPANTES,E.DESCRIPCION ESTADO FROM PRUEBA_HABITACION H INNER JOIN PRUEBA_ESTADOS E ON H.ESTADO=E.ID INNER JOIN PRUEBA_TIPO T ON H.TIPO=T.ID\n"
                + "WHERE T.ID= V1 AND E.ID= V2 AND  H.ACTIVO = 1 ORDER BY ID ASC";
        consulta = consulta.replace("V1", tipo).replace("V2", estado);
        Query nativeQuery = em.createNativeQuery(consulta);
        List<Object[]> results = nativeQuery.getResultList();
        em.close();
        emf.close();
        return results
                .stream()
                .map(result -> new HabitacionResponse((String) result[0].toString(), (String) result[1], (String) result[2], (String) result[3].toString(), (String) result[4]))
                .collect(Collectors.toList());

    } 

    
    @Override
    public List<HabitacionResponse>  queryHabitacion(String id) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hotel");
        EntityManager em = emf.createEntityManager();
        String consulta = "SELECT H.ID,H.NOMBRE,T.DESCRIPCION TIPO,T.OCUPANTES,E.DESCRIPCION ESTADO FROM PRUEBA_HABITACION H INNER JOIN PRUEBA_ESTADOS E ON H.ESTADO=E.ID INNER JOIN PRUEBA_TIPO T ON H.TIPO=T.ID\n"
                + "WHERE H.ID= V1  AND  H.ACTIVO = 1 ORDER BY ID ASC";
        consulta = consulta.replace("V1", id);
        Query nativeQuery = em.createNativeQuery(consulta);
        List<Object[]> results = nativeQuery.getResultList();
        em.close();
        emf.close();
        if (results.size() > 0) {
            return results
                    .stream()
                    .map(result -> new HabitacionResponse((String) result[0].toString(), (String) result[1], (String) result[2], (String) result[3].toString(), (String) result[4]))
                    .collect(Collectors.toList());
        }else{
            return results
                    .stream()
                    .map(result -> new HabitacionResponse("0", "0", "0","0","0"))
                    .collect(Collectors.toList());
        }
    }

    @Override
    public BigDecimal saveHabitacion(HabitacionEntity entity) {
      
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("hotel");
        EntityManager em = emfactory.createEntityManager();
        BigDecimal valor=BigDecimal.valueOf(0);
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();            
            em.close();
            emfactory.close();
            valor = entity.getId();
            return valor;
        } catch (Exception ex) {            
            LOG.error("error", ex);
            return valor;
        } 
    }

    @Override
    public HabitacionEntity updateHabitacion(HabitacionEntity entity) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("hotel");
        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();
        HabitacionEntity em = entitymanager.find(HabitacionEntity.class, entity.getId());
        try {
            if (em != null) {
                //before update
                System.out.println("inicio");
                em.setEstado(entity.getEstado());
                entitymanager.getTransaction().commit();
            }
            //after update
            System.out.println("fin");
            entitymanager.close();
            emfactory.close();
            return em;
        } catch (Exception ex) {
            LOG.error("error", ex);
            return em;
        }
    }
    
    @Override
    public HabitacionEntity deleteHabitacion(String id) {
        BigDecimal d = new BigDecimal(id);
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("hotel");
        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();
        HabitacionEntity em = entitymanager.find(HabitacionEntity.class, d);
        try {
            if (em != null) {
                entitymanager.remove(em);
                entitymanager.getTransaction().commit();
            }
            
            System.out.println("fin");
            entitymanager.close();
            emfactory.close();
            return em;
        } catch (Exception ex) {
            LOG.error("error", ex);
            return em;
        }
    }
    
    
    @Override
    public String transicionar(String origen, String destino, String id) {
        String val = "";
        try {
            BigDecimal d = new BigDecimal(id);
            BigDecimal des = new BigDecimal(destino);
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("hotel");
            EntityManager em = emf.createEntityManager();
            String consulta = "SELECT COUNT(*) FROM PRUEBA_TRANSICION WHERE ORIGEN=V1 AND DESTINO=V2";
            consulta = consulta.replace("V1", origen).replace("V2", destino);
            Query query = em.createNativeQuery(consulta);
            Number valor = (Number) query.getSingleResult();
            em.close();
            emf.close();
            int flat = Integer.parseInt(String.valueOf(valor));
            HabitacionEntity ha = new HabitacionEntity();
            if (flat > 0) {
                ha.setId(d);
                ha.setEstado(des);
                return updateHabitacion(ha).getNombre();
            }
            return val;
        } catch (Exception ex){
            LOG.error("**************Error clase HabitacionServices************", ex);
            return val;
        }
    }
    
    
    @Override
    public String reservar(String cupos, String id) {
        String val = "";
        try {
            BigDecimal d = new BigDecimal(id);
            BigDecimal des = new BigDecimal(2);
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("hotel");
            EntityManager em = emf.createEntityManager();
            String consulta = "SELECT COUNT(*) FROM PRUEBA_HABITACION H INNER JOIN PRUEBA_TIPO T ON H.TIPO=T.ID WHERE T.OCUPANTES >= V1  AND H.ID= V2 AND H.ACTIVO = 1 ";
            consulta = consulta.replace("V1", cupos).replace("V2", id);
            Query query = em.createNativeQuery(consulta);
            Number valor = (Number) query.getSingleResult();
            em.close();
            emf.close();
            int flat = Integer.parseInt(String.valueOf(valor));
            HabitacionEntity ha = new HabitacionEntity();
            if (flat > 0) {
                ha.setId(d);
                ha.setEstado(des);
                return updateHabitacion(ha).getNombre();
            }
            return val;
        } catch (Exception ex) {
            LOG.error("**************Error clase HabitacionServices************", ex);
            return val;
        }
    }
    
     
    
    @Override
    public String validar(String nombre, String rol) {
        String val = "";
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("hotel");
            EntityManager em = emf.createEntityManager();
            String consulta = "SELECT COUNT(*) FROM PRUEBA_ROL WHERE ID=V1 AND V2=1";
            consulta = consulta.replace("V1", rol).replace("V2",nombre);
            Query query = em.createNativeQuery(consulta);
            Number valor = (Number) query.getSingleResult();
            em.close();
            emf.close();
            val = String.valueOf(valor);            
            return val;
        } catch (Exception ex) {
            LOG.error("**************Error clase HabitacionServices************", ex);
            return val;
        }
    }

}
