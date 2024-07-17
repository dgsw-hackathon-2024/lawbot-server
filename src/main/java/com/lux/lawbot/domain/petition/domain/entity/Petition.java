package com.lux.lawbot.domain.petition.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "petitions")
public class Petition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
        제목
    */
    @Column(nullable = false)
    private String title;

    /*
        내용
    */
    @Column(nullable = false)
    private String contents;

    /*
        작성일
    */
    @Column
    private LocalDateTime createdAt;

    /*
        좋아요
    */
    @Column(columnDefinition = "BIGINT default 0")
    private Long likes;

    @Builder
    public Petition(String title, String contents, LocalDateTime createdAt, Long likes) {
        this.title = title;
        this.contents = contents;
        this.createdAt = createdAt;
        this.likes = likes;
    }

    public void like() {
        likes += 1;
    }

    public void unlike() {
        likes -= 1;
    }
}
