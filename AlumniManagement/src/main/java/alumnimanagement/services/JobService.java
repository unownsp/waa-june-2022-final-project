package alumnimanagement.services;

import alumnimanagement.dto.*;
import alumnimanagement.entity.job.JobAdvertisement;

import java.util.List;
import java.util.Map;

public interface JobService {

    void create(JobAdvertisementDTO job);

    List<JobAdvertisementDTO> getAll();
    List<String>findAllCompany();

    void update(JobAdvertisementDTO jobAdvertisementDTO, int id);

    void delete(int id);

    List<JobAdvertisementDTO> findLastTop10Advertisement();

    List<JobAdvertisementListDTO> findAllByParam(int page, int size, String state, String city, String tag, String name);
    Long count(String state, String city, String tag, String name);

    JobAdvertisementDTO findById(int id);
    List<ReportList> JobByState();

    List<JobAdvertisementEditDTO> findStudentJobList(int page, int size, String searchValue);
    Long countById(long id);

    List<ReportList>findByTags();

    List<ReportList> jobsByStateTag(String state);
}
