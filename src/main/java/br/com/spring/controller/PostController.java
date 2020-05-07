package br.com.spring.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.spring.model.Post;
import br.com.spring.service.interfaces.PostService;

@Controller
public class PostController {

	private PostService service;

	public PostController(PostService service) {
		this.service = service;
	}

	@GetMapping("posts")
	public ModelAndView getPosts() {
		ModelAndView mv = new ModelAndView("posts");
		List<Post> posts = service.findAll();
		mv.addObject("posts", posts);

		return mv;
	}

	@GetMapping("posts/{id}")
	public ModelAndView getPostDetails(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("postDetails");
		Post post = service.findById(id);
		mv.addObject("post", post);

		return mv;
	}

	@GetMapping("novo")
	public String getPostForm() {
		return "postForm";
	}

	@PostMapping("novo")
	public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributtes) {
		if (result.hasErrors()) {
			attributtes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos.");
			return "redirect:/novo";
		}

		post.setData(LocalDate.now());
		service.save(post);
		
		return "redirect:/posts";
	}
}
