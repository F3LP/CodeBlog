package br.com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.model.Post;
import br.com.spring.repository.PostRepository;
import br.com.spring.service.interfaces.PostService;

@Service
public class PostServiceImpl implements PostService {

	private PostRepository repository;
	
	@Autowired
	public PostServiceImpl(PostRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<Post> findAll() {
		return repository.findAll();
	}

	@Override
	public Post findById(long id) {
		return repository.findById(id).get();
	}

	@Override
	public Post save(Post post) {
		return repository.save(post);
	}

}
