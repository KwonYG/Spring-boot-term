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

import kr.ac.springboot.term.answer.Answer;
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
	@OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
	private List<Answer> answers;

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

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

}
