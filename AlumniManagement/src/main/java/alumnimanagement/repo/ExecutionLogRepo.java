package alumnimanagement.repo;

import alumnimanagement.entity.helper.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExecutionLogRepo extends JpaRepository<ActivityLog, Integer> {
}
