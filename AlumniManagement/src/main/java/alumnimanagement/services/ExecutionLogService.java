package alumnimanagement.services;


import alumnimanagement.dto.ExecutionLogDTO;

import java.util.List;

public interface ExecutionLogService {

    List<ExecutionLogDTO> findAllLogs();

    void createLog(ExecutionLogDTO dto);

    void updateLog(ExecutionLogDTO dto, int id);

    void deleteLog(int id);
}
