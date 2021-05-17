package com.example.Exec1_Todo.domain.comment;

import com.example.Exec1_Todo.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment findById(long id);

}
