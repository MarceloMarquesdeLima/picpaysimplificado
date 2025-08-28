package com.picpaysimplificado.domain.user;

import com.picpaysimplificado.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name="users")
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String document;
    @Column(unique = true)
    private  String email;
    private String password;
    private BigDecimal balance;
    @Enumerated(EnumType.STRING)
    private UserType userType;

    public User(UserDTO date) {
        this.firstName = date.firstName();
        this.lastName = date.lastName();
        this.document = date.document();
        this.balance = date.balance();
        this.userType = date.userType();
        this.password = date.password();
        this.email = date.email();
    }
}
