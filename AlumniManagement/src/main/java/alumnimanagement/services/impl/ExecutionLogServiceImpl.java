package alumnimanagement.services.impl;

import alumnimanagement.dto.ExecutionLogDTO;
import alumnimanagement.entity.helper.ActivityLog;
import alumnimanagement.repo.ExecutionLogRepo;
import alumnimanagement.services.ExecutionLogService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ExecutionLogServiceImpl implements ExecutionLogService {

    private final ExecutionLogRepo executionLogRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<ExecutionLogDTO> findAllLogs() {
        return executionLogRepo.findAll()
                .stream()
                .map(activityLog -> modelMapper.map(activityLog, ExecutionLogDTO.class))
                .toList();
    }

    @Override
    public void createLog(ExecutionLogDTO dto) {
        executionLogRepo.save(modelMapper.map(dto, ActivityLog.class));
    }

    @Override
    public void updateLog(ExecutionLogDTO dto, int id) {
        executionLogRepo.save(modelMapper.map(dto, ActivityLog.class));
    }

    @Override
    public void deleteLog(int id) {
        executionLogRepo.deleteById(id);
    }

    public ActivityLog findById(int id) {
        return executionLogRepo.findById(id).isPresent() ? executionLogRepo.findById(id).get() : null;
    }
}
