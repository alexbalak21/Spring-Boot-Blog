package alex.blog;

import alex.blog.model.Post;
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
	CommandLineRunner commandLineRunner(PostRepository posts) {
		return args -> {
			posts.save(new Post("My first post", "This is my first post."));
			posts.save(new Post("My second post", "This is my second post."));
		};
	}
}
