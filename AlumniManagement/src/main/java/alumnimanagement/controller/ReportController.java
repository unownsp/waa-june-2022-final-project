package alumnimanagement.controller;

import alumnimanagement.dto.DropdownDto;
import alumnimanagement.dto.StudentDTO;
import alumnimanagement.entity.Address;
import alumnimanagement.entity.Department;
import alumnimanagement.entity.Student;
import alumnimanagement.services.StudentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reports")
@AllArgsConstructor
@CrossOrigin
public class ReportController {

    StudentService studentService;
    ModelMapper modelMapper;



    @GetMapping("/state")
    public List<DropdownDto> state() {
        List<DropdownDto> list = new ArrayList<>();
        List<StudentDTO> students=studentService.findAll();
        for(StudentDTO s: students){
            DropdownDto dto=new DropdownDto();
            dto.setTitle(s.getAddress().getState());
            list.add(dto);
        }
        return list.stream().distinct().collect(Collectors.toList());
    }

    @GetMapping("/city")
    public List<DropdownDto> city() {
        List<DropdownDto> list = new ArrayList<>();
        List<StudentDTO> students=studentService.findAll();
        for(StudentDTO s: students){
            DropdownDto dto=new DropdownDto();
            dto.setTitle(s.getAddress().getCity());
            list.add(dto);
        }
        return list.stream().distinct().collect(Collectors.toList());
    }

    @GetMapping("/major")
    public List<DropdownDto> major() {
        List<DropdownDto> list = new ArrayList<>();
        List<StudentDTO> students=studentService.findAll();
        for(StudentDTO s: students){
            DropdownDto dto= new DropdownDto();
            dto.setTitle(s.getMajor().getDepartmentName());
            list.add(dto);
        }

        return list.stream().distinct().collect(Collectors.toList());
    }

    @GetMapping("/studentName")
    public List<DropdownDto> studentName() {
        List<DropdownDto> list = new ArrayList<>();
        List<StudentDTO> students=studentService.findAll();
        for(StudentDTO s: students){
            DropdownDto dto= modelMapper.map(s,DropdownDto.class);
            dto.setTitle(s.getFirstName()+" "+s.getLastName());
            list.add(dto);

        }
        return list;
    }
}