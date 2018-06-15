package kr.ac.springboot.term.answer;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.springboot.term.question.Question;

@RestController
@RequestMapping("/replies/*")
public class AnswerController {

	@Autowired
	private AnswerRepository ansRepo;

	@GetMapping("/{qno}")
	public ResponseEntity<List<Answer>> getAnswers(@PathVariable("qno") Long qno) {
		Question question = new Question();
		question.setQno(qno);
		return new ResponseEntity<>(getListByQuestion(question), HttpStatus.OK);
	}

	@Transactional
	@PostMapping("/{qno}")
	public ResponseEntity<List<Answer>> addAnswer(@PathVariable("qno") Long qno, @RequestBody Answer answer) {
		Question question = new Question();
		question.setQno(qno);

		answer.setQuestion(question);
		ansRepo.save(answer);

		return new ResponseEntity<>(getListByQuestion(question), HttpStatus.CREATED);
	}

	@Transactional
	@DeleteMapping("/{qno}/{ano}")
	public ResponseEntity<List<Answer>> removie(@PathVariable("qno") Long qno, @PathVariable("ano") Long ano) {
		ansRepo.deleteById(ano);

		Question question = new Question();
		question.setQno(qno);

		return new ResponseEntity<>(getListByQuestion(question), HttpStatus.OK);
	}

	@Transactional
	@PutMapping("/{qno}")
	public ResponseEntity<List<Answer>> modify(@PathVariable("qno") Long qno, @RequestBody Answer answer) {
		ansRepo.findById(answer.getAno()).ifPresent(origin -> {
			origin.setReplyText(answer.getReplyText());
			ansRepo.save(origin);
		});

		Question question = new Question();
		question.setQno(qno);

		return new ResponseEntity<>(getListByQuestion(question), HttpStatus.OK);
	}

	private List<Answer> getListByQuestion(Question question) throws RuntimeException {
		return ansRepo.findAllByQuestionOrderByAnoAsc(question);
	}
}
