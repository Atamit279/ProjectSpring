package tech.das.springproject.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "enchant")
public class Enchant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "element")
    private String element;

    @Column(name = "debuff")
    private  String debuff;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="weapon_id", referencedColumnName = "id")
    private Weapon weapon;

}
