package com.example.short_url_project_02.domain.surl.entity;

import com.example.short_url_project_02.global.jpa.entity.BaseTime;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import com.example.short_url_project_02.domain.member.member.entity.Member;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Surl extends BaseTime {

    @ManyToOne
    @JsonIgnore
    private Member author;

    private String body;
    private String url;

    @Setter(AccessLevel.NONE)
    private long count;

    public void increaseCount() {
        count++;
    }
}