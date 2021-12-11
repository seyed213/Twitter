package com.example.twitter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Hashtag extends BaseEntity {

    @Column(unique = true)
    private String text;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Post> posts;

}
