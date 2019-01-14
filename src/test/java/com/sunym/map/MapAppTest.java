package com.sunym.map;

import org.junit.Test;

import com.sunym.map.utils.HttpRequestUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MapAppTest {

	@Test
	public void testWelcome() {
		String result = HttpRequestUtil.doGet("http://localhost:18081/map/welcomeapi", "UTF-8");
		log.debug(result);
	}
}
