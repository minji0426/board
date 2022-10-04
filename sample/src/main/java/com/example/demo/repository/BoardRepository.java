package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class BoardRepository {
	@Autowired
    SqlSessionTemplate sqlSessionTemplate;

    public List<Map<String, Object>> getBoardById(){
        return sqlSessionTemplate.selectList("board.getBoardById", null);
    }
    public List<Map<String, Object>> getBoardAll(){
        return sqlSessionTemplate.selectList("board.getBoardAll", null);
    }
    public List<Map<String, Object>> getSample(){
        return sqlSessionTemplate.selectList("board.getBoardAll", null);
    }
    public Object add(Map<String, Object> param){
        return sqlSessionTemplate.insert("board.add", param);
    }
    public Object edit(Map<String, Object> param){
        return sqlSessionTemplate.update("board.edit", param);
    }
}
