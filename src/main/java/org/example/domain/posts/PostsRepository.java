package org.example.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> { // JpaRepository<Entity 클래스, PK 타입> 룰 상속하면 기본적인 CRUD 메소드가 자동 생성된다.


}
