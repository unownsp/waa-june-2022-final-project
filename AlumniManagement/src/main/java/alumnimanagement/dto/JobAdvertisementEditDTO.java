package alumnimanagement.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class JobAdvertisementEditDTO {

    private int id;
    private String jobTitle;
    private String jobDesc;
    private String addBenefit;
    private int numOpening;
    private String jobType;
    private float paymentAmount;
    private LocalDateTime publishDate;


}
