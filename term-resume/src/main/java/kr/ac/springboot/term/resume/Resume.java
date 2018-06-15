package kr.ac.springboot.term.resume;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import kr.ac.springboot.term.experience.Experience;
import kr.ac.springboot.term.question.Question;

@Entity
@Table(name = "tbl_resumes")
public class Resume {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long rno;

	private String name;
	private String studentNumber;
	private String schoolMajor;
	private String email;
	private String introduction;

	@OneToMany(mappedBy = "resume", fetch = FetchType.LAZY)
	private List<Experience> exp;

	@OneToMany(mappedBy = "resume", fetch = FetchType.LAZY)
	private List<Question> question;

	public List<Experience> getExp() {
		return exp;
	}

	public void setResume(List<Experience> exp) {
		this.exp = exp;
	}

	public Resume() {

	}

	public Resume(String name, String studentNumber, String schoolMajor, String email, String introduction) {
		this.name = name;
		this.studentNumber = studentNumber;
		this.schoolMajor = schoolMajor;
		this.email = email;
		this.introduction = introduction;
	}

	public Long getRno() {
		return rno;
	}

	public void setRno(Long rno) {
		this.rno = rno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getSchoolMajor() {
		return schoolMajor;
	}

	public void setSchoolMajor(String schoolMajor) {
		this.schoolMajor = schoolMajor;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public List<Question> getQuestion() {
		return question;
	}

	public void setQuestion(List<Question> question) {
		this.question = question;
	}

}
