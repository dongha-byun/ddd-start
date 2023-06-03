package hello.ddd.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class ArticleContent {
    private String content;
    private String contentType;
}
