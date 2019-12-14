package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            //비영속
          /*  Member member = new Member();
            member.setId(101L);
            member.setName("HelloJPA");

            //영속
            System.out.println("=== BEFORE ===");
            em.persist(member);
            System.out.println("=== AFTER ===");*/

         /*   Member findMember = em.find(Member.class,101L);

            System.out.println("findMember.id =" + findMember.getId());
            System.out.println("findMember.name =" + findMember.getName());*/

       /* Member member = em.find(Member.class,150L);
        member.setName("ZZZZZ");*/

       Member member = new Member(200L,"member200");
       em.persist(member);
       em.flush();

       System.out.println("==================");

        tx.commit();
        }catch(Exception e){
            tx.rollback();
        }


        em.close();
        emf.close();
    }
}
