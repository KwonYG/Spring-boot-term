package kr.ac.springboot.term.question;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kr.ac.springboot.term.resume.Resume;

@Entity
@Table(name = "tbl_questions")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long qno;

	private String questioner;
	private String questionContent;

	@JsonIgnore
	@OneToMany(mappedBy = "questions", fetch = FetchType.LAZY)
	private List<Question> questions;

	@ManyToOne(fetch = FetchType.LAZY)
	private Resume resume;

	public Question() {

	}

	public Question(String questioner, String questionContent, Resume resume) {
		this.questioner = questioner;
		this.questionContent = questionContent;
		this.resume = resume;
	}

	public Long getQno() {
		return qno;
	}

	public void setQno(Long qno) {
		this.qno = qno;
	}

	public String getQuestioner() {
		return questioner;
	}

	public void setQuestioner(String questioner) {
		this.questioner = questioner;
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

}
