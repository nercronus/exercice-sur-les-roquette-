/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.test;


import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.data.domain.Persistable;
import streaming.entity.Film;

/**
 *
 * @author Formation
 */
public class ExerciceTest {
    @Test
    public void req7(){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        Query query = em.createQuery("select count(f) from Film join f.acteur a join f.realisateurs r where a.nom='polanski and r.nom='polanski");
        
    }
    
    @Test
    public void req6(){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        Query query = em.createQuery("select count(f) from Film f join f.acteurs a where a.nom='Polanski'");
        long nbfilm = (long) query.getSingleResult();
        
        assertEquals(1L, nbfilm);
    }
    
    @Test
    public void req5(){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        Query query = em.createQuery("select count(f) from Film f join f.realisateurs r where r.nom='Polanski'");
        long nbfilm = (long) query.getSingleResult();
        
        assertEquals(2L, nbfilm);
    }
    
    @Test
    public void req4(){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        Query query = em.createQuery("select count(l) from Lien l join l.film f where f.titre='Big Lebowski (The)'");
        long nbliens = (long) query.getSingleResult();
        
        assertEquals(1L, nbliens);
    }
    
    @Test
    public void req3(){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        Query query = em.createQuery("select min (f.annee) from Film f");
        int i = (int) query.getSingleResult();
        
        assertEquals(1968, i);
    }
    
    @Test
    public void req2(){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        Query query = em.createQuery("select count (f) from Film f");
        
        long r = (long) query.getSingleResult();
        
        assertEquals(4l, r);
    }
    
    @Test
    public void req1() {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        Query query = em.createQuery("select f from Film f where f.id=4");
        Film film = (Film) query.getSingleResult();
        
        System.out.println(film.getTitre());
    }
    
}
