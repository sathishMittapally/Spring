package com.api.comment.model;

import java.math.BigDecimal;

/**
 * Created by Sathish
 */
public class Comment {
	private Long id;
	private String commentBy;
	private String commentDate;
	private String commentText;
	private String topicId;

	public Comment() {

	}

	public Comment(Long id, String commentBy, String commentDate, String commentText, String topicId) {
		super();
		this.id = id;
		this.commentBy = commentBy;
		this.commentDate = commentDate;
		this.commentText = commentText;
		this.topicId = topicId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCommentBy() {
		return commentBy;
	}

	public void setCommentBy(String commentBy) {
		this.commentBy = commentBy;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

}
