package com.example.demo.service;

import com.example.demo.repository.BoardMapper;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("boardService")
@Transactional
public class BoardService {
	@Autowired
	BoardMapper boardMapper;
	

	public Map<String, Object> getBoardById(Integer boardId) {
        return boardMapper.getBoardById(boardId);
    }
    
    public List<Map<String, Object>> getBoardAll() {
        return boardMapper.getBoardAll();
    }
    
    public List<Map<String, Object>> getBoardByKeyword(Map<String, Object> param) {
        return boardMapper.getBoardByKeyword(param);
    }
    
    public List<Map<String, Object>> getReply(Integer boardId) {
        return boardMapper.getReply(boardId);
    }
    
    public List<Map<String, Object>> getAllReply(Integer boardId) {
        return boardMapper.getAllReply(boardId);
    }
    
    public void addReply(Map<String, Object> param) {
    	boardMapper.addReply(param);
    }

    public int add(Map<String, Object> param) {
    	return boardMapper.add(param);
    }
    public void fileUpload(Map<String, Object> param) {
    	boardMapper.fileUpload(param);
    	//throw new RuntimeException("test");   	
    }
    
    public List<Map<String, Object>> getFile(Integer boardId) {
        return boardMapper.getFile(boardId);
    }
    
    public Map<String, Object> getFileByFileNo(Integer fileNo) {
        return boardMapper.getFileByFileNo(fileNo);
    }
    
    public void deleteFile(Map<String, Object> param) {
    	boardMapper.deleteFile(param);
    }
    
    public void test() {
    	boardMapper.test();
    }
    
    public void edit(Map<String, Object> param) {
    	boardMapper.edit(param);
    }
    
    public void delete(Map<String, Object> param) {
    	boardMapper.delete(param);
    }

    public void viewCount(Integer boardId) {
    	boardMapper.viewCount(boardId);
    }
    
    public int boardCount(Map<String, Object> param) {
    	return boardMapper.boardCount(param);
    }
    
    public int replyCount(Integer boardId) {
    	return boardMapper.replyCount(boardId);
    }
}
