package entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Folder {

    @Setter @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Setter private String name;
    @Setter private String description;
}
