package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import domain.Board;
import domain.Reply;

@Repository
public interface BoardDomainMapper {
	void addBoard(Board board);
	void editBoard(Board board);
	Board getBoardById(Integer boardId);
	List<Board> getBoards(Map<String, Object> parameters);
	
	List<Reply> getAllReply(Integer boardId);
	List<MultipartFile> getFile(Integer boardId);
}