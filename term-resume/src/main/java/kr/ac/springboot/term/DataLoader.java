package kr.ac.springboot.term;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import kr.ac.springboot.term.experience.Experience;
import kr.ac.springboot.term.experience.ExperienceRepository;
import kr.ac.springboot.term.question.Question;
import kr.ac.springboot.term.question.QuestionRepository;
import kr.ac.springboot.term.resume.Resume;
import kr.ac.springboot.term.resume.ResumeRepository;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private ResumeRepository resRepo;

	@Autowired
	private ExperienceRepository expRepo;

	@Autowired
	private QuestionRepository quesRepo;

	@Override
	public void run(ApplicationArguments args) {
		resRepo.save(new Resume("권영근", "2012951014", "경성대학교 소프트웨어학과", "andamirocll@gmail.com","부산에 살고 나이는 26살 이름은 권영근입니다."));
		quesRepo.save(new Question("질문자 1", "몇살이세요?"));
		quesRepo.save(new Question("질문자 2", "어디 사세요?"));

		expRepo.save(new Experience("부스트 에이스 2기", "멘티", "네이버 커넥트 재단에서 진행하는 부스트 에이스 2기 활동 중",
				resRepo.findById((long) 1).orElse(null)));
		expRepo.save(new Experience("고등학생 코딩 교육봉사 ", "보조 강사", "약 5개월 간 파이썬 프로그래밍 교육 봉사 활동을 함",
				resRepo.findById((long) 1).orElse(null)));
		expRepo.save(new Experience("자기 소개 앱", "1인 개발", "모바일 웹 ,제이쿼리를 이용해 자기 소개 앱을 만들어봄",
				resRepo.findById((long) 1).orElse(null)));
		expRepo.save(new Experience("가고 싶은 회사 소개 앱", "1인 개발", "모바일 웹 ,제이쿼리를 이용해 가고싶은 회사 소개 앱을 만들어봄",
				resRepo.findById((long) 1).orElse(null)));
		expRepo.save(new Experience("vue.js TODO앱 ", "1인 개발", "vue.js 책에 있는 todo앱 만들기",
				resRepo.findById((long) 1).orElse(null)));
	}

}