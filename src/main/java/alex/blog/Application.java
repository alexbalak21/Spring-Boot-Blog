package alex.blog;

import alex.blog.model.Author;
import alex.blog.model.Post;
import alex.blog.repository.AuthorRepository;
import alex.blog.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(PostRepository posts, AuthorRepository authors) {
		return args -> {
			authors.save(new Author(null, "John", "Doe", "2Zk4S@example.com", "john_doe"));
			posts.save(new Post("My first post", "This is my first post."));
			posts.save(new Post("My second post", "This is my second post."));
		};
	}
}
