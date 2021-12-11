package com.example.twitter.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder

@Table(name = "user")
public class User extends BaseEntity {

    @NotBlank
    @Column(name = "user_name",unique = true)
    private String userName;

    @Size(min = 6, max = 100)
    private String password;

    @Email
    private String email;

    @Size(min = 11, max = 11)
    private String phoneNumber;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Post> posts;

}
