package com.example.Exec1_Todo.domain.post;

import com.example.Exec1_Todo.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByEmail(String email);
    List<Post> findByEmailAndIsDone(String email, boolean isDone);
    Post findById(long id);

}
