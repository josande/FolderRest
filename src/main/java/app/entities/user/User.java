package app.entities.user;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private String firstName;
    private String lastName;
}
