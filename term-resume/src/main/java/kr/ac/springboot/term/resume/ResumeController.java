package kr.ac.springboot.term.resume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.ac.springboot.term.question.QuestionRepository;

@Controller
public class ResumeController {
	@Autowired
	private ResumeRepository resRepo;

	@Autowired
	private QuestionRepository quesRepo;

	@GetMapping("/")
	public String resumeIndex(Model model) {
		Resume resume = resRepo.findById((long) 1).get();
		model.addAttribute("resume", resume);
		model.addAttribute("question", quesRepo.findAll());
		return "resume";
	}
}
