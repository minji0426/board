package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.repository.BoardDomainMapper;

import domain.Board;
import domain.Reply;

@Service
public class BoardDomainService {
	
	@Autowired
	BoardDomainMapper boardDomainMapper;
	
	
	public Board getBoard(Integer id) {
		//System.out.println("boardId : " + id);
		Board board = boardDomainMapper.getBoardById(id);
		board.read();
		boardDomainMapper.editBoard(board);
		
		System.out.println("board : " + boardDomainMapper.getBoardById(id));
		
		board.setReplies(getReply(id));
		board.setFiles(getFile(id));
		
		return board;
	}
	
	public List<Reply> getReply(Integer id) {	
		List<Reply> reply = boardDomainMapper.getAllReply(id);	
		System.out.println("reply : " + reply);
		
		return reply;
	}
	
	public List<MultipartFile> getFile(Integer id) {	
		List<MultipartFile> file = boardDomainMapper.getFile(id);
		
		return file;
	}
	
}