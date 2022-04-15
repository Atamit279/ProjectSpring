/**
 * Account
 *
 * Version 1.2
 *
 * Hanbecov Dmitrii / Daimanroyal@gmail.com
 */
package tech.das.springproject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private  String password;

    @Column(name = "conpassword")
    private  String conpassword;

    @Column(name = "email")
    private String email;

}
