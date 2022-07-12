package alumnimanagement.entity;

import alumnimanagement.entity.authUser.UserAuth;
import alumnimanagement.repo.UserAuthRepo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String comment;
    private boolean isActive;
    private boolean isDeleted;

    @ManyToOne
    @JsonBackReference
    private UserAuth faculty;

    @ManyToOne
    private UserAuth student;
}
