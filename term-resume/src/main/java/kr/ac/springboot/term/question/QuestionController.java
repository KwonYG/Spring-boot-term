package kr.ac.springboot.term.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/question/")
public class QuestionController {
	@Autowired
	private QuestionRepository quesRepo;

	@GetMapping("/{qno}")
	public String questionPage(@PathVariable("qno") long qno, Model model) {
		if (quesRepo.findById(qno).isPresent()) {
			model.addAttribute("question", quesRepo.findById(qno).get());
		} else {
			return "error/404";
		}
		return "/question/quesitem";
	}

	@GetMapping("/qregister")
	public void qregisterGet(@ModelAttribute("qo") Question qo) {

	}

	@PostMapping("/qregister")
	public String qregisterPOST(@ModelAttribute("qo") Question qo) {
		quesRepo.save(qo);
		return "redirect:/";
	}

	@GetMapping("{qno}/delete/")
	public String delete(@PathVariable("qno") long qno) {
		if (quesRepo.findById(qno).isPresent()) {
			quesRepo.deleteById(qno);
		} else {
			return "errors/404";
		}
		return "redirect:/";
	}
}
