package com.magnavalor.login.user.domain.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "users")
public class User {

    // TODO convert sequenceGenerated value
    @Id
    @GeneratedValue
    private Long Id;

    @NotEmpty(message = "user name does not empty")
    @NotNull(message = "User name does not null")
    private String userName;

    @NotNull(message = "email doe not null")
    @NotEmpty(message = "email does not empty")
    private String email;

    private String password;


}
