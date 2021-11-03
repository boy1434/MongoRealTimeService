package com.ex.realtime.domain;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;

import reactor.core.publisher.Flux;

public interface NaverNewsRepository extends ReactiveMongoRepository<NaverNews, String>{

	@Tailable // 리얼 타임을 하려면 연결이 끊기지 않게 계속 연결 되어있어야함
	@Query("{}")
	Flux<NaverNews>mFindAll();
}
