package alumnimanagement.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Address {
    @Id
    private long id;
    private String state;
    private String city;
}
