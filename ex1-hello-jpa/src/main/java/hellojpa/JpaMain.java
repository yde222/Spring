package hellojpa;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //code
        try {
//             update 쿼리가 조회되지 않을 경우 삽입
            Member member = new Member();
            member.setId(11);
            member.setName("jieun");

            //등록
            em.persist(member);
          
            member.setName("지은");


            Member findMember = em.find(Member.class,1L);

            findMember.setName("HelloJPA");

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
            emf.close();
    }
}
