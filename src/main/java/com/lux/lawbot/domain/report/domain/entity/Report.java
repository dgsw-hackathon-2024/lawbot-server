package com.lux.lawbot.domain.report.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "reports")
public class Report {
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

    @Builder
    public Report(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
