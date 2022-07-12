package alumnimanagement.entity.helper;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "ActivityLog")
@Data
@ToString
public class ActivityLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private LocalDateTime date;
    private String operation;
    private long duration;
    private long userId;
    private String entity;
    private String type;
}
