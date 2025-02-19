package com.example.short_url_project_02.domain.article.article.entity;

import com.example.short_url_project_02.global.jpa.entity.BaseTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
public class Article extends BaseTime {
    @Id
    private Long id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String body;


}

