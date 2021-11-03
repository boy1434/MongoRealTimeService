package com.ex.realtime.batch;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ex.realtime.domain.NaverNews;
import com.ex.realtime.domain.NaverNewsRepository;
import com.ex.realtime.util.NaverNewsCraw;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class NaverNewsBatch {
	
	private final NaverNewsRepository naverNewsRepository;
	private final NaverNewsCraw naverNewsCraw;
	
	// @Scheduled(cron = "0 0 1 * * *", zone = "Asia/Seoul")
	@Scheduled(fixedDelay = (1000*60*1) ) //
	public void naverNewsSave() {
		List<NaverNews> naverNewsList = naverNewsCraw.newsCraw();
		
		naverNewsRepository.saveAll(naverNewsList);
	}

}
