package kr.ac.springboot.term.answer;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import kr.ac.springboot.term.question.Question;

public interface AnswerRepository extends CrudRepository<Answer, Long> {
	List<Answer> findAllByQuestionOrderByAnoAsc(Question question);
}
