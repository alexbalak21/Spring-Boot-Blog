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

    public Integer getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getPublishedOn() {
        return publishedOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public AggregateReference<Post, Integer> getPost() {
        return post;
    }

    public AggregateReference<Author, Integer> getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", publishedOn=" + publishedOn +
                ", updatedOn=" + updatedOn +
                ", post=" + post +
                ", author=" + author +
                '}';
    }
}


