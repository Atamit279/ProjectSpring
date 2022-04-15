package tech.das.springproject.entities;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "weapon")
public class Weapon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "dmg")
    private Long dmg;

    @Column(name = "name")
    private String name;

    @Column(name = "lvl")
    private Long lvl;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="player_id", referencedColumnName = "id")
    private Player player;

    @OneToOne(mappedBy = "weapon", cascade = CascadeType.ALL)
    private Enchant enchant;

}
