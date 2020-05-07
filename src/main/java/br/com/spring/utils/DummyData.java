package br.com.spring.utils;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.spring.model.Post;
import br.com.spring.repository.PostRepository;

@Component
public class DummyData {

	private PostRepository repository;
	
	@Autowired
	public DummyData(PostRepository repository) {
		this.repository = repository;
	}
	
//	@PostConstruct
	public void save() {
		
		Post post = new Post();
		post.setAutor("Felipe");
		post.setData(LocalDate.now());
		post.setTitulo("Teste");
		post.setTexto("Incluindo registro no BD");
		
		repository.save(post);
		
		Post post2 = new Post();
		post2.setAutor("Felipe");
		post2.setData(LocalDate.now());
		post2.setTitulo("Teste");
		post2.setTexto("Incluindo registro no BD");
		
		repository.save(post2);
	}
}
