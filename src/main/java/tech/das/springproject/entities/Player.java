package tech.das.springproject.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "player")
public class Player {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "hp")
  private Long hp;

  @Column(name = "lvl")
  private Long lvl;

  @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
  private List<Weapon> weaponList;


}
