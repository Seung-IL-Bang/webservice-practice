package org.example.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.domain.BaseTimeEntity;

import javax.persistence.*;

@Getter
@NoArgsConstructor // 기본 생성자 자동 추가, public Posts() {} 와 같은 효과이다.
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    /* UPDATE */
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

// @Entity
// 테이블과 링크될 클래스임을 나타낸다.
// 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭한다. ex) SalesManager.java -> sales_manager table

// @Id
// 해당 테이블의 PK 필드를 나타낸다.

// @GeneratedValue
// PK 의 생성 규칙을 나타낸다.
// 스프링 부트 2.0 에서는 GenerationType.IDENTITY 옵션을 추가해야만 auto_increment 가 된다.

// @Column
// 테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 된다.
// 사용하는 이유는, 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용한다.
// 문자열의 경우 VARCHAR(255) 가 기본값인데, 사이즈를 500으로 늘리고 싶거나, 타입을 TEXT 로 변경하고 싶을 때 사용된다.

// @Builder
// 해당 클래스의 빌더 패턴 클래스를 생성한다.
// 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함된다.