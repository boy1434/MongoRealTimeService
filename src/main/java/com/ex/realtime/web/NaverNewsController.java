package com.ex.realtime.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ex.realtime.domain.NaverNews;
import com.ex.realtime.domain.NaverNewsRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RequiredArgsConstructor
@RestController
public class NaverNewsController {
	private final NaverNewsRepository naverNewsRepository;
	
	@CrossOrigin // 모든 도메인, 모든 요청방식에 대해 허용한다.
	@GetMapping(value = "/naverNews", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<NaverNews> findAll(){
		
		return naverNewsRepository.mFindAll()
				.subscribeOn(Schedulers.boundedElastic());
	}
	
	@PostMapping("/naverNews")
	public Mono<NaverNews> save(@RequestBody NaverNews naverNews){
		return naverNewsRepository.save(naverNews);
	}
}
