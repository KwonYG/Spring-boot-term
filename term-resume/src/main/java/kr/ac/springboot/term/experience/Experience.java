package kr.ac.springboot.term.experience;

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

import kr.ac.springboot.term.resume.Resume;

@Entity
@Table(name = "tbl_experiences")
public class Experience {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long rno;

	private String title;
	private String position;
	private String content;

	@CreationTimestamp
	private Timestamp regdate;

	@UpdateTimestamp
	private Timestamp updatedate;

	@ManyToOne(fetch = FetchType.LAZY)
	private Resume resume;

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public Experience() {

	}

	public Experience(String title, String position, String content, Resume resume) {
		this.title = title;
		this.position = position;
		this.content = content;
		this.resume = resume;
	}

	public Long getRno() {
		return rno;
	}

	public void setRno(Long rno) {
		this.rno = rno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
