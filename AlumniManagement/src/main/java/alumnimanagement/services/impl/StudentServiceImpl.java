package alumnimanagement.services.impl;

import alumnimanagement.dto.ReportList;
import alumnimanagement.dto.StudentDTO;
import alumnimanagement.dto.StudentListDto;
import alumnimanagement.dto.UpdateCVDTO;
import alumnimanagement.entity.Address;
import alumnimanagement.entity.Student;
import alumnimanagement.entity.authUser.UserAuth;
import alumnimanagement.repo.StudentRepo;
import alumnimanagement.repo.UserAuthRepo;
import alumnimanagement.services.StudentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class StudentServiceImpl implements StudentService {
    private UserAuthRepo userAuthRepo;
    private ModelMapper modelMapper;

    @Override
    public void create(StudentDTO studentDTO) {
        userAuthRepo.save(modelMapper.map(studentDTO, UserAuth.class));
    }

    @Override
    public void update(long id, StudentDTO studentDTO) throws Exception {
        UserAuth student = userAuthRepo.findById(id).orElseThrow(() -> new Exception("Student id is invalid"));
        student.setAddress(modelMapper.map(studentDTO.getAddress(), Address.class));
        student.setUsername(studentDTO.getFirstName());
        student.setEmail(studentDTO.getEmail());
        student.setId(id);
        userAuthRepo.save(student);

    }

    @Override
    public List<StudentDTO> findAll() {
        List<StudentDTO> studentDTOS = userAuthRepo.findAll().stream().filter(student -> !(student.isDeleted())).map(student -> {
            return modelMapper.map(student, StudentDTO.class);
        }).toList();

        return studentDTOS;

    }

    @Override
    public Long totalStudents(String state, String city, String major, String studentName, long id) {
        Long count = userAuthRepo.count();
        if (id != 0 || !state.equals("''") || !city.equals("''") || !major.equals("''") || !studentName.equals("''")) {
            return findByFilter(state, city, major, studentName, id).stream().count();
        }
        return count;
    }

    @Override
    public StudentDTO findStudentById(long id) {
        UserAuth s = userAuthRepo.findById(id).get();
        return modelMapper.map(s, StudentDTO.class);
    }

    @Override
    public List<ReportList> StudentByState() {
        var result = userAuthRepo.StudentByState();
        List<ReportList> result2 = new ArrayList<>();
        for (Object[] d : result) {
            Long id = (Long) d[1];
            ReportList dto = new ReportList();
            dto.value = id;
            dto.name = (String) d[0];
            result2.add(dto);
        }
        return result2;
    }

    @Override
    public void updateStudentCV(long id, UpdateCVDTO updateCVDTO) {
        UserAuth s = userAuthRepo.findById(id).get();
        s.setCvLink(updateCVDTO.getCvLink());
        s.setJobExperienceList(updateCVDTO.getJobExperienceList());
        System.out.println(s);
        userAuthRepo.save(s);
    }

    @Override
    public List<ReportList> findByStateCity(String state) {

        var result = userAuthRepo.StudentByCity(state.toUpperCase());
        List<ReportList> result2 = new ArrayList<>();
        for (Object[] d : result) {
            Long id = (Long) d[1];
            ReportList dto = new ReportList();
            dto.value = id;
            dto.name = (String) d[0];
            result2.add(dto);
        }
        return result2;
    }


    @Override
    public List<StudentListDto> findAllByParam(int page, int size, String state, String city, String major, String studentName, long id) {
        if (id != 0 || !state.equals("''") || !city.equals("''") || !major.equals("''") || !studentName.equals("''")) {
            return findByFilter(state, city, major, studentName, id).stream().skip(page * size).limit(5).toList();
        }
        Pageable pageable = PageRequest.of(page, size);
        List<UserAuth> student = userAuthRepo.findAll(pageable).stream().toList();
        List<StudentListDto> studentListDtos = new ArrayList<>();
        for (UserAuth r : student) {
            if (!r.isDeleted()) {
                StudentListDto dtp = new StudentListDto();
                dtp.setEmail(r.getEmail());
                dtp.setFirstName(r.getUsername());
                dtp.setCity(r.getAddress().getCity());
                dtp.setState(r.getAddress().getState());
                dtp.setId(r.getId());
                studentListDtos.add(dtp);
            }
        }
        return studentListDtos;
    }

    public List<StudentListDto> findByFilter(String state, String city, String major, String studentName, long id) {
        List<UserAuth> students = userAuthRepo.findAll().stream().toList();
        List<StudentListDto> dto = new ArrayList<>();

        for (UserAuth s : students) {
            String sName = s.getUsername();
            if (!s.isDeleted()) {
                if (s.getId() == id
                        || s.getAddress().getState().equals(state)
                        || s.getAddress().getCity().equals(city)
                        || s.getMajor().getDepartmentName().equals(major)
                        || sName.equalsIgnoreCase(studentName)) {
                    StudentListDto dto1 = modelMapper.map(s, StudentListDto.class);
                    dto1.setState(s.getAddress().getState());
                    dto1.setCity(s.getAddress().getCity());
                    dto.add(dto1);
                }
            }
        }
        return dto;
    }

    @Override
    public void remove(long id) {
        UserAuth target = userAuthRepo.findById(id).get();
        target.setDeleted(true);
    }
}
