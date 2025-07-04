package hellojpa;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
          Member member1 = new Member();
          member1.setUsername("hello");
          em.persist(member1);

          em.flush();
          em.clear();

            Member reMember = em.getReference(Member.class, member1.getId());
            System.out.println("reMember.getClass() = " + reMember.getClass()); //proxy
            reMember.getUsername();
            System.out.println("isLoaded = " +emf.getPersistenceUnitUtil().isLoaded(reMember));


            tx.commit();
        } catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
            emf.close();
    }
}
