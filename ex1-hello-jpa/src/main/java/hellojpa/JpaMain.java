package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setName("member1");
            em.persist(member);

            //팀 저장
            Team team = new Team();
            team.setName("TeamA");
            //역방향(주인이 아닌 방향)만 연관관계 설정
            team.getMembers().add(member);
            em.persist(team);

            em.flush();
            em.close();


            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
            emf.close();
    }
}
