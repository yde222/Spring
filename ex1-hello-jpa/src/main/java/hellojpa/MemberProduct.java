package hellojpa;

import jakarta.persistence.*;

@Entity
public class MemberProduct {


    @Id
    @ManyToOne
    @JoinColumn(name ="MEMBER_ID")
    private Member member;

}
