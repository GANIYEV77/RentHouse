package uz.usmon.renthouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.usmon.renthouse.dto.CartDto;
import uz.usmon.renthouse.dto.CommentDto;
import uz.usmon.renthouse.model.Cart;
import uz.usmon.renthouse.model.Comment;
import uz.usmon.renthouse.model.Profile;
import uz.usmon.renthouse.model.Result;
import uz.usmon.renthouse.repository.CommentRepo;
import uz.usmon.renthouse.repository.ProfileRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    CommentRepo commentRepo;
    @Autowired
    ProfileRepo profileRepo;

    public List<Comment> findAll() {
        return commentRepo.findAll();
    }

    public Comment findById(Integer id) {
        return commentRepo.findById(id).get();
    }

    public Result create(CommentDto commentDto) {
        boolean exists = commentRepo.existsById(commentDto.getProfile_id());
        Comment comment = new Comment();
        comment.setGrade(commentDto.getGrade());
        comment.setDescription(commentDto.getDescription());
        comment.setText(commentDto.getText());
        comment.setLike_count(commentDto.getLike_count());

        Optional<Profile> profile = profileRepo.findById(commentDto.getProfile_id());
        Profile profile1 = profile.get();
        comment.setProfile_id(profile1);
        return new Result(true, "Comment created");
    }

    public Result update(Integer id, CommentDto commentDto) {
        Optional<Comment> comment = commentRepo.findById(id);
        if (comment.isPresent()) {
            Comment comment1 = new Comment();
            comment1.setGrade(commentDto.getGrade());
            comment1.setDescription(commentDto.getDescription());
            comment1.setText(commentDto.getText());
            comment1.setLike_count(commentDto.getLike_count());

            Optional<Profile> profile = profileRepo.findById(commentDto.getProfile_id());
            Profile profile1 = profile.get();
            comment1.setProfile_id(profile1);
            return new Result(true, "Comment updated");
        }
        return new Result(false, "Comment not found");
    }

    public Result delete(Integer id) {
        Optional<Comment> comment = commentRepo.findById(id);
        if (comment.isPresent()) {
            commentRepo.delete(comment.get());
            return new Result(true, "Comment deleted");
        }
        return new Result(false, "Comment not found");
    }
}
