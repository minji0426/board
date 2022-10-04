package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.repository.BoardDomainMapper;
import com.example.demo.service.BoardDomainService;

import domain.Board;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardDomainServiceTest {

	
	@Autowired
	BoardDomainService boardDomainService;
	
	@Autowired
	BoardDomainMapper boardDomainMapper;
	
	@Test
	public void readTest() {
		Board board = new Board();		
		assertEquals("신규 게시물 생성 테스트", 0, board.getViews());
		board.read();
		assertEquals("신규 게시물 리드 테스트", 1, board.getViews());
	}
	
	
	@Test
	public void readTest2() {
		
		assertNotNull(boardDomainService);
		
		Board board0 = boardDomainMapper.getBoardById(1);
		System.out.println(board0);
		Board board = boardDomainService.getBoard(1);
		
		System.out.println(board);
		assertEquals("게시물 조회 테스트", 1, board.getViews());
		// 실제 DB 저장 확인 
		Board board2 = boardDomainMapper.getBoardById(1);
		
		System.out.println(board2);
		assertEquals("게시물 조회 테스트", 1, board2.getViews());
		
	}
	
}
