package alex.blog.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.time.LocalDateTime;

public class Comment {
    @Id
    private Integer id;
    private String content;
    private LocalDateTime publishedOn;
    private LocalDateTime updatedOn;
    private AggregateReference<Post, Integer> post;
    private AggregateReference<Author, Integer> author;


    public Comment(String content, AggregateReference<Post, Integer> post, AggregateReference<Author, Integer> author) {
        this.content = content;
        this.publishedOn = LocalDateTime.now();
        this.post = post;
        this.author = author;
    }
}


