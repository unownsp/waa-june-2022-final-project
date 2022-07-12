package alumnimanagement.services.impl;

import alumnimanagement.dto.AppliedJobDTO;
import alumnimanagement.dto.ListAppliedStudentDTO;
import alumnimanagement.entity.AppliedJob;
import alumnimanagement.entity.authUser.UserAuth;
import alumnimanagement.entity.job.JobAdvertisement;
import alumnimanagement.repo.AppliedJobRepo;
import alumnimanagement.repo.JobRepo;
import alumnimanagement.repo.UserAuthRepo;
import alumnimanagement.services.AppliedJobService;
import alumnimanagement.utility.Helper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class AppliedJobServiceImpl implements AppliedJobService {
    private final AppliedJobRepo appliedJobRepo;
    private final ModelMapper modelMapper;
    private JobRepo jobRepo;
    private UserAuthRepo userAuthRepo;

    @Override
    public void create(AppliedJobDTO appliedJobDTO) {
        UserAuth student = userAuthRepo.findById(appliedJobDTO.getId_student()).get();
        JobAdvertisement jobAdvertisement = jobRepo.findById(appliedJobDTO.getId_job()).get();

        AppliedJob appliedJob = new AppliedJob();
        appliedJob.setAppliedDate(Helper.getCurrentDate());
        appliedJob.setUserAuth(student);
        appliedJob.setAdditionalComment(appliedJobDTO.getAdditionalComment());
        appliedJob.setIsActive(appliedJobDTO.getIsActive());
        appliedJob.setIsDeleted(appliedJobDTO.getIsDeleted());
        appliedJob.setJobAdvertisement(jobAdvertisement);
        appliedJobRepo.save(appliedJob);
    }

    @Override
    public void remove(Long id) {
        appliedJobRepo.deleteById(id);
    }

    @Override
    public List<AppliedJobDTO> findAppliedJobByStudentId(long studentId) {

        return appliedJobRepo.findAllByUserAuthId(studentId).
                stream().map(appliedJob -> modelMapper.map(appliedJob, AppliedJobDTO.class)).toList();
    }

    @Override
    public List<ListAppliedStudentDTO> findStudentsJobAppliedToJob(int jobId, int page, int size, String searchValue) {
        Pageable pageable = PageRequest.of(page, size);
        return appliedJobRepo.findAllByJobAdvertisementId(jobId)
                .stream()
                .map(appliedJob -> {
                    ListAppliedStudentDTO listAppliedStudentDTO = new ListAppliedStudentDTO();
                    listAppliedStudentDTO.setFirstName(appliedJob.getUserAuth().getUsername());
                    listAppliedStudentDTO.setEmail(appliedJob.getUserAuth().getEmail());
                    listAppliedStudentDTO.setCity(appliedJob.getUserAuth().getAddress().getCity());
                    listAppliedStudentDTO.setState(appliedJob.getUserAuth().getAddress().getState());
                    listAppliedStudentDTO.setCvLink(appliedJob.getUserAuth().getRole());
                    return listAppliedStudentDTO;
                })
                .toList();
    }


    @Override
    public Long countById(int id) {
        return appliedJobRepo.countByJobAdvertisementId(id);
    }
}
