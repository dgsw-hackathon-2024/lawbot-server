package com.lux.lawbot.domain.petition.domain.entity;

import com.lux.lawbot.domain.user.domain.entity.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "petitions")
public class Petition {
    @Id
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
        좋아요
    */
    @Column
    private Long likes;

    public static Petition postPetition(
            String title,
            String contents) {
        Petition petition = new Petition();
        petition.title = title;
        petition.contents = contents;

        return petition;
    }
}
