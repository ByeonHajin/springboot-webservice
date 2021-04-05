package com.hajin.springboot.domain.posts;
import com.hajin.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor//기본생성자 자동 추가     public Posts() {}   와 같은 역할
@Entity//Entity(JPA annotation, 테이블과 링크됨을 나타냄) > No~~(lombok annotation), Getter(lombok annotation)
public class Posts extends BaseTimeEntity { //실제 DB의 테이블과 매칭될 클래스, Entity클래스 -> 쿼리를 날리기 보다는 클래스의 수정을 통해 작업
    @Id//해당 테이블의 PK필드(primary key)를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY)//pk생성규칙
    private Long id; // -> 주민등록번호나 복합키 등은 pk로 잡았을 경우 복잡해짐. 유니크키로 별로 추가 권

    @Column(length = 500, nullable = false)//테이블의 칼럼
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
