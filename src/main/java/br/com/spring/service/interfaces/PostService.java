package br.com.spring.service.interfaces;

import java.util.List;

import br.com.spring.model.Post;

public interface PostService {

	List<Post> findAll();
	Post findById(long id);
	Post save(Post post);
}
