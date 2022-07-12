package alumnimanagement.services.impl;

import alumnimanagement.dto.FacultyDTO;
import alumnimanagement.dto.FacultyListDto;
import alumnimanagement.dto.ReportList;
import alumnimanagement.entity.Address;
import alumnimanagement.entity.authUser.UserAuth;
import alumnimanagement.repo.UserAuthRepo;
import alumnimanagement.services.FacultyService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor

public class FacultyServiceImpl implements FacultyService {
    private final UserAuthRepo userAuthRepo;
    private final ModelMapper modelMapper;

    @Override
    public void create(FacultyDTO facultyDTO) {
        userAuthRepo.save(modelMapper.map(facultyDTO, UserAuth.class));
    }

    @Override
    public void update(long id, FacultyDTO facultyDTO) throws Exception {
        UserAuth userAuth = userAuthRepo.findById(id).orElseThrow(() -> new Exception("Invalid id"));
        userAuth.setId(id);
        userAuth.setAddress(modelMapper.map(facultyDTO.getAddress(), Address.class));
        userAuth.setUsername(facultyDTO.getFirstName());
        userAuth.setEmail(facultyDTO.getEmail());
        userAuthRepo.save(userAuth);

    }

    @Override
    public List<FacultyDTO> findAll() {
        return userAuthRepo.findAll().stream().filter(faculty -> !(faculty.isDeleted())).map(faculty ->
                modelMapper.map(faculty, FacultyDTO.class)).toList();
    }

    @Override
    public void remove(long id) {
        userAuthRepo.findById(id).get().setDeleted(true);

    }

    @Override
    public List<FacultyListDto> findAllByParam(int page, int size, String searchValue) {
        Pageable pageable = PageRequest.of(page, size);
        List<UserAuth> facultyList = userAuthRepo.findAll(pageable).stream().toList();
        List<FacultyListDto> dtos = new ArrayList<>();
        for (UserAuth f : facultyList) {
            if (!f.isDeleted()) {
                FacultyListDto facultyListDto = new FacultyListDto();
                facultyListDto.setCity(f.getAddress().getCity());
                facultyListDto.setEmail(f.getEmail());
                facultyListDto.setId(f.getId());
                facultyListDto.setFirstName(f.getUsername());
                facultyListDto.setState(f.getAddress().getState());
                facultyListDto.setDepartment(f.getDepartment());
                dtos.add(facultyListDto);
            }
        }
        return dtos;
    }

    @Override
    public Long count() {
        return userAuthRepo.count();
    }

    @Override
    public List<ReportList> facultyByDepartment() {
        var result = userAuthRepo.facultyByDepartment();
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
}
