package kr.ac.springboot.term.answer;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kr.ac.springboot.term.question.Question;

@Entity
@Table(name = "tbl_answers")
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ano;

	private String replyer;
	private String replyText;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Question question;

	@CreationTimestamp
	private Timestamp regdate;

	@UpdateTimestamp
	private Timestamp updatedate;

	public Answer() {

	}

	public Answer(String replyText, String replyer, Question question) {
		this.replyer = replyer;
		this.replyText = replyText;
		this.question = question;
	}

	public Long getAno() {
		return ano;
	}

	public void setAno(Long ano) {
		this.ano = ano;
	}

	public String getReplyer() {
		return replyer;
	}

	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}

	public String getReplyText() {
		return replyText;
	}

	public void setReplyText(String replyText) {
		this.replyText = replyText;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public Timestamp getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
	}

}
