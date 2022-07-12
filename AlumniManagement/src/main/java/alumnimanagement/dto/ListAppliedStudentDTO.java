package alumnimanagement.dto;

import lombok.Data;

@Data
public class ListAppliedStudentDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String city;
    private String state;
    private String cvLink;
}
