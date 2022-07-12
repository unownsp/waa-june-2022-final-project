package alumnimanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExecutionLogDTO {
    private LocalDateTime date;
    private String operation;
    private long duration;
    private long userId;
    private String entity;
    private String type;
}
