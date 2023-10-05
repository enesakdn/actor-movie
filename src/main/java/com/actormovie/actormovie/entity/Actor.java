package com.actormovie.actormovie.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name="actor",schema="spring")
public class Actor {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
    private int id;
@Column(name = "first_name")
private String firstName;
 @Column(name = "last_name")
 private String lastName;
 @Column(name="age")
    private int age;
@Enumerated(EnumType.STRING)
    private Gender gender;
@Column(name="birth_date")
    private LocalDate birthDate;

@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,})
@JoinTable(name="movie_actor",schema = "spring",
joinColumns = @JoinColumn(name="actor_id"),
inverseJoinColumns = @JoinColumn(name="movie_id"))
    private List<Movie> movie;
}
