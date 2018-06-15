package kr.ac.springboot.term.experience;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.springboot.term.resume.Resume;
import kr.ac.springboot.term.resume.ResumeRepository;

@Controller
@RequestMapping("/experience/")
public class ExperienceController {
	@Autowired
	private ResumeRepository resRepo;

	@Autowired
	private ExperienceRepository expRepo;

	@GetMapping("/")
	public String experienceIndex(Model model) {
		Resume resume = resRepo.findById((long) 1).get();
		model.addAttribute("resume", resume);
		model.addAttribute("result", expRepo.findAllByOrderByRegdateDesc());
		return "experience";
	}

	@GetMapping("/register")
	public void registerGET(@ModelAttribute("vo") Experience vo) {

	}

	@PostMapping("/register")
	public String registerPOST(@ModelAttribute("vo") Experience vo) {
		vo.setResume(resRepo.findById((long) 1).get());
		expRepo.save(vo);

		return "redirect:/experience/";
	}

	@GetMapping("/{rno}")
	public String view(@PathVariable("rno") long rno, Model model) {
		if (expRepo.findById(rno).isPresent()) {
			model.addAttribute("result", expRepo.findById(rno).get());
		} else {
			return "errors/404";
		}
		return "/experience/item";
	}

	@GetMapping("{rno}/delete/")
	public String delete(@PathVariable("rno") long rno) {
		if (expRepo.findById(rno).isPresent()) {
			expRepo.deleteById(rno);
		} else {
			return "errors/404";
		}
		return "redirect:/experience/";
	}

	@GetMapping("/{rno}/update") // 수정기능
	public String editGet(@PathVariable("rno") long rno, @ModelAttribute("vo") Experience vo, Model model) {
		if (expRepo.findById(rno).isPresent()) {
			model.addAttribute("vo", expRepo.findById(rno).get());// 현재 id의 입력 정보들을 가져온다
		} else {
			return "errors/404";
		}
		return "/experience/update";
	}

	@PostMapping("/update")
	public String editPost(@ModelAttribute("vo") Experience vo) {// 새롭게 수정한 Experience
		Optional<Experience> exp = expRepo.findById(vo.getRno());// 데이터 베이스에서 가져온 Experience
		if (exp.isPresent()) {
			exp.get().setTitle(vo.getTitle());
			exp.get().setPosition(vo.getPosition());
			exp.get().setContent(vo.getContent());
			expRepo.save(exp.get());// 싹다 가져와서 넣기
		} else {
			expRepo.save(vo);
		}
		return "redirect:/experience/";
	}

}
