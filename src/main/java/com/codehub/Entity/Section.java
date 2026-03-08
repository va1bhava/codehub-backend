package com.codehub.Entity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.engine.internal.Cascade;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="section")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(nullable = false,name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "section",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Post> posts;
}
