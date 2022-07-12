package alumnimanagement.services.impl;


import alumnimanagement.dto.CommentDTO;
import alumnimanagement.entity.Comment;
import alumnimanagement.entity.authUser.UserAuth;
import alumnimanagement.repo.CommentRepo;
import alumnimanagement.repo.FacultyRepo;
import alumnimanagement.repo.UserAuthRepo;
import alumnimanagement.services.CommentService;
import alumnimanagement.utility.Helper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final ModelMapper modelMapper;
    private final CommentRepo commentRepo;
    private final UserAuthRepo userAuthRepo;

    @Override
    public void create(CommentDTO comment) {
        Comment comment1 = new Comment();
        comment1.setId(comment.getId());
        comment1.setComment(comment.getComment());
        long userID = Helper.getLoggedUserId();
        Optional<UserAuth> result = userAuthRepo.findById(userID);
        //Comment comment1=modelMapper.map(comment, Comment.class);
        UserAuth stu = userAuthRepo.findById(comment.getStudentId()).get();
        comment1.setFaculty(stu);
        if (result.isPresent()) {
            UserAuth faculty = result.get();
            comment1.setFaculty(faculty);
        }

        commentRepo.save(comment1);
    }

    @Override
    public List<CommentDTO> getComment(long id) {
        return commentRepo.findById(id).stream()
                .map(item -> modelMapper.map(item, CommentDTO.class))
                .toList();
    }

    @Override
    public void update(CommentDTO commentDTO, long id) {
        commentDTO.setId(id);
        commentRepo.save(modelMapper.map(commentDTO, Comment.class));
    }

    @Override
    public void delete(long id) {
        commentRepo.deleteById(id);
    }

    @Override
    public List<CommentDTO> commentByStudentId(long id) {

        List<Comment> comments = commentRepo.commentByStudentId(id);
        List<CommentDTO> result = new ArrayList<>();
        for (Comment c : comments) {
            CommentDTO commentDTO = modelMapper.map(c, CommentDTO.class);
            commentDTO.setCommentedBy(c.getFaculty().getUsername());
            result.add(commentDTO);
        }
        return result;
//        var result= commentRepo.commentByStudentId(id).stream().map(comment -> modelMapper.map(comment, CommentDTO.class)).toList();
//        return result;
    }

    @Override
    public Long count(long id) {
        return commentRepo.countById(id);
    }


}
