package jpabook.jpashop.domain;


import jakarta.persistence.*;

import static jakarta.persistence.FetchType.LAZY;

@Entity
public class Member extends BaseEntity{

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "USERNAME")
    private String name;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getTeam() {
        return team;
    }

    public void changeTeam(Team team) {

    }

    public void setTeam(Team team) {
    }
}
