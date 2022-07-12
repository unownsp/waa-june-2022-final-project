package alumnimanagement.entity.authUser;

import alumnimanagement.entity.Address;
import alumnimanagement.entity.Comment;
import alumnimanagement.entity.Department;
import alumnimanagement.entity.helper.JobExperience;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
    @DiscriminatorColumn(name = "Role")
    public class UserAuth {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(columnDefinition = "serial")
        private Long id;

    private String username;

    private String password;

    private boolean isActive;
    private String email;
    private String otp;

    private String image;
    private String department;
    private boolean isDeleted;

    @Column(insertable = false, updatable = false)
    private String Role;

    private String cvLink;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_address")
    private Address address;

    @OneToOne
    @JoinColumn(name = "id_major")
    private Department major;

    @OneToMany(mappedBy = "faculty")
    @JsonManagedReference
    private List<Comment> comments;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn
    private List<JobExperience> jobExperienceList;
}

