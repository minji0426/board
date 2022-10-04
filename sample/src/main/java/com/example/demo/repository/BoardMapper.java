package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface BoardMapper {
	List<Map<String, Object>> getSample();
	
	Map<String, Object> getBoardById(Integer boardId);
	List<Map<String, Object>> getBoardAll();
	List<Map<String, Object>> getBoardByKeyword(Map<String, Object> param);
	
	
	List<Map<String, Object>> getFile(Integer boardId);
	Map<String, Object> getFileByFileNo(Integer fileNo);
	void deleteFile(Map<String, Object> param);
	
	List<Map<String, Object>> getReply(Integer boardId);
	List<Map<String, Object>> getReReply(Integer boardId);
	List<Map<String, Object>> getAllReply(Integer boardId);
	
    int add(Map<String, Object> param);
    void edit(Map<String, Object> param);
    void delete(Map<String, Object> param);
    
    void fileUpload(Map<String, Object> param);
    
    void addReply(Map<String, Object> param);
    
    void viewCount(Integer boardId);
    int boardCount(Map<String, Object> param);
    int replyCount(Integer boardId);
    
    void test();
}