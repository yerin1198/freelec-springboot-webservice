package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor //기본생성자 자동추가
@Entity //테이블과 링크될 클래스임을 나타냄
public class Posts extends BaseTimeEntity { //실제 db와 매칭될 클래스 - BaseTimeentity 상속

    @Id //해당테이블의 pk필드를 나타냄.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pk의 생성규칙을 나타냄
    private Long id;

    @Column(length = 500,nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT",nullable = false) //테이블의 칼럼. 굳이 선언아해도 해당 클래스의 필드는 모두 칼럼
    private String content;

    private String author;

    @Builder //빌더 패턴 클래스 생성. 생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함.
    public Posts(String title,String content,String author){
        this.title=title;
        this.content=content;
        this.author=author;
    }

    public void update(String title,String content){
        this.title=title;
        this.content=content;
    }

}
