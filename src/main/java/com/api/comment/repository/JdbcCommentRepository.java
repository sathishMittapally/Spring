package com.api.comment.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.api.comment.model.Comment;

import java.util.List;
import java.util.Optional;

@Repository
public class JdbcCommentRepository implements CommentRepository {


	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int count() {
		return jdbcTemplate.queryForObject("select count(*) from comments", Integer.class);
	}

	@Override
	public int save(Comment comment) {
		return jdbcTemplate.update("insert into comments (comment_date,comment_text, comment_by, topicId) values(?,?,?,?)", comment.getCommentDate(), comment.getCommentText(), comment.getCommentBy(), comment.getTopicId());
	}

	@Override
	public int update(Comment comment) {
		return jdbcTemplate.update("update comments set comment_text = ? where id = ?", comment.getCommentText(), comment.getId());
	}

	@Override
	public int deleteById(Long id) {
		return jdbcTemplate.update("delete from comments where id = ?", id);
	}

	@Override
	public List<Comment> findAll() {
		return jdbcTemplate.query("select * from comments",
				(rs, rowNum) -> new Comment(rs.getLong("id"), rs.getString("comment_by"), rs.getString("comment_date"), rs.getString("comment_text"), rs.getString("topicId")));
	}

	// jdbcTemplate.queryForObject, populates a single object
	@Override
	public Optional<Comment> findById(Long id) {
		return jdbcTemplate.queryForObject("select * from comments where id = ?", new Object[] { id }, (rs,
				rowNum) -> Optional.of(new Comment(rs.getLong("id"), rs.getString("comment_by"), rs.getString("comment_date"), rs.getString("comment_text"), rs.getString("topicId"))));
	}

	@Override
	public List<Comment> findByNameAndComment(String name, String commentText) {
		return jdbcTemplate.query("select * from comments where comment_by like ? and comment_text like ?",
				new Object[] { "%" + name + "%", "%" + commentText + "%" },
				(rs, rowNum) -> new Comment(rs.getLong("id"), rs.getString("comment_by"), rs.getString("comment_date"), rs.getString("comment_text"), rs.getString("topicId")));
	}

	@Override
	public String getCommentById(Long id) {
		return jdbcTemplate.queryForObject("select name from comments where id = ?", new Object[] { id }, String.class);
	}

}