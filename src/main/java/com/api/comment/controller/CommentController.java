package com.api.comment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import com.api.comment.model.Comment;
import com.api.comment.repository.CommentRepository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sathish
 */
@RestController
@RequestMapping("/api")
public class CommentController {

	private static final Logger log = LoggerFactory.getLogger(CommentController.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired

	@Qualifier("paramJdbcBookRepository") // Test NamedParameterJdbcTemplate
	private CommentRepository commentReprository;

	@GetMapping("/findAllComments")
	public List<Comment> findAll() {
		log.info("Inside findAll");
		return commentReprository.findAll();
	}

	@GetMapping("/findByNameAndComment")
	public List<Comment> findByNameAndComment(@RequestParam String name, @RequestParam String commentText) {
		log.info("Inside getAllComments");
		return commentReprository.findByNameAndComment(name, commentText);
	}

	@PostMapping("/saveComments")
	public List<Comment> saveComments(@RequestBody List<Comment> comments) {
		log.info("Save comments");
		comments.forEach(comment -> {
			log.info("Saving...{}", comment.getCommentText());
			commentReprository.save(comment);
		});
		log.info("[COUNT] Total comments: {}", commentReprository.count());
		return comments;

	}
	
	@PutMapping("/updateComments")
	public List<Comment> updateComments(@RequestBody List<Comment> comments) {
		log.info("Update comments");
		comments.forEach(comment -> {
			log.info("Update...{}", comment.getCommentText());
			commentReprository.update(comment);
		});
		log.info("[COUNT] Total comments: {}", commentReprository.count());
		return comments;

	}
	
	@DeleteMapping("/deleteComments")
	public Comment deleteComments(@RequestBody Comment comment) {
		log.info("Delete comments");
		
			log.info("Deleting comment...{}", comment.getCommentText());
			commentReprository.deleteById(comment.getId());
		
		log.info("[COUNT] Total comments: {}", commentReprository.count());
		return comment;

	}

	

}
