package com.api.comment.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.api.comment.model.Comment;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public class ParamJdbcBookRepository extends JdbcCommentRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public int update(Comment comment) {
        return namedParameterJdbcTemplate.update(
                "update comments set comment_text = :commentText where id = :id",
                new BeanPropertySqlParameterSource(comment));
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return namedParameterJdbcTemplate.queryForObject(
                "select * from comments where id = :id",
                new MapSqlParameterSource("id", id),
                (rs, rowNum) ->
                        Optional.of(new Comment(
                                rs.getLong("id"),
                                rs.getString("comment_by"),
                                rs.getString("comment_date"),
                                rs.getString("comment_text"),
                                rs.getString("topicId")
                                
                        ))
        );
    }

    @Override
    public List<Comment> findByNameAndComment(String name, String commentText) {

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("name", "%" + name + "%");
        mapSqlParameterSource.addValue("commentText", "%" + commentText + "%");

        return namedParameterJdbcTemplate.query(
                "select * from comments where comment_by like :name and comment_text like :commentText",
                mapSqlParameterSource,
                (rs, rowNum) ->
                        new Comment(
                        		 rs.getLong("id"),
                                 rs.getString("comment_by"),
                                 rs.getString("comment_date"),
                                 rs.getString("comment_text"),
                                 rs.getString("topicId")
                        )
        );
    }

}

