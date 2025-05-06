package uz.usmon.renthouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.usmon.renthouse.model.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
}
