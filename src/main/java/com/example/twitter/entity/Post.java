package com.example.twitter.entity;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Table(name = "post")
public class Post extends BaseEntity {

    @NotBlank
    private String text;

    @NotNull
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    private Date createPost;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "hashtag_post",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "Hashtag_id"))
    private List<Hashtag> hashtag;

}
