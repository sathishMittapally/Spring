package com.api.comment.repository;

import java.util.List;
import java.util.Optional;

import com.api.comment.model.Comment;

public interface CommentRepository {

	int count();

	int save(Comment comment);

	int update(Comment comment);

	int deleteById(Long id);

	List<Comment> findAll();

	List<Comment> findByNameAndComment(String name, String commentText);

	Optional<Comment> findById(Long id);

	String getCommentById(Long id);

}