package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.BoardDomainService;
import com.example.demo.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@Autowired
	BoardDomainService boardDomainService;

	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public String write(Model model) {
		boardService.test();

		return "redirect:/list";
	}
	
//	@RequestMapping(value = "/view", method = RequestMethod.GET)
//	public String view(Model model, Integer id) {
//		boardService.viewCount(id);
//
//		Map<String, Object> view = boardService.getBoardById(id);
//		model.addAttribute("board", view);
//
//		List<Map<String, Object>> reply = boardService.getAllReply(id);
//		model.addAttribute("reply", reply);
//		
//		List<Map<String, Object>> file = boardService.getFile(id);
//		model.addAttribute("file", file);
//
//		return "view";
//	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view(Model model, HttpServletRequest request) {
		int id = Integer.parseInt(String.valueOf(request.getParameter("id")));
		model.addAttribute("board", boardDomainService.getBoard(id));
		return "view";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(Model model, @RequestBody HashMap<String, Object> map) {
		Map<String, Object> delete = boardService.getBoardById(Integer.parseInt(String.valueOf(map.get("id"))));

		delete.put("del_yn", map.get("del_yn"));
		boardService.delete(delete);

		return "redirect:/list";
	}

	@RequestMapping(value = "/reply", method = RequestMethod.POST)
	public String writeReply(Model model, @RequestBody HashMap<String, Object> map) {
		Map<String, Object> writeReply = new HashMap<>();
		
		int id = Integer.parseInt(String.valueOf(map.get("id")));

		writeReply.put("parentReplyId", map.get("parentReplyId"));
		writeReply.put("writer", map.get("writer"));
		writeReply.put("content", map.get("content"));
		writeReply.put("id", map.get("id"));

		//System.out.println("writeReply : " + writeReply);
		boardService.addReply(writeReply);

		//System.out.println("addReply : " + boardService.getAllReply(id));
		
		return "view";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String getEdit(Model model, Integer id, HttpServletRequest request) {
		Map<String, Object> edit = boardService.getBoardById(id);
		model.addAttribute("board", edit);
		
		List<Map<String, Object>> file = boardService.getFile(id);
		System.out.println("file : " + file);
		model.addAttribute("file", file);

		return "edit";
	}
	
	@RequestMapping(value = "/deleteFile", method = RequestMethod.POST)
	public String editFile(Model model, @RequestBody HashMap<String, Object> map) {
		Map<String, Object> deleteFile = boardService.getFileByFileNo(Integer.parseInt(String.valueOf(map.get("file_no"))));

		//System.out.println("file_no : " + map.get("file_no"));
		
		deleteFile.put("del_yn", map.get("del_yn"));

		boardService.deleteFile(deleteFile);

		return "redirect:/edit";
	}

//	@RequestMapping(value = "/edit", method = RequestMethod.POST)
//	public String edit(Model model, @RequestBody HashMap<String, Object> map/*, @RequestParam List<MultipartFile> uploadFiles*/) throws IOException {
//		int id = Integer.parseInt(String.valueOf(map.get("id")));
//		Map<String, Object> edit = boardService.getBoardById(Integer.parseInt(String.valueOf(map.get("id"))));
//		Map<String, Object> file = new HashMap<>();
//
//		edit.put("title", map.get("title"));
//		edit.put("content", map.get("content"));
//
//		boardService.edit(edit);
//		
////		for(MultipartFile uploadFile : uploadFiles) {
////			if(!uploadFile.isEmpty()) {
////				String originalName = uploadFile.getOriginalFilename();
////				//String fileName = originalName.substring(originalName.lastIndexOf("//")+1);
////				//System.out.println("originalName : " + originalName);
////		
////				String fullPath = uploadDir + originalName;
////				uploadFile.transferTo(new File(fullPath));
////				
////				file.put("org_file_name", originalName);
////				file.put("board_id", id);
////			
////				System.out.println(file);
////			
////				boardService.fileUpload(file);
////			}
////		}
//		
//
//		return "redirect:/list";
//	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(Model model, HttpServletRequest request, @RequestParam List<MultipartFile> uploadFiles) throws IOException {
		int id = Integer.parseInt(String.valueOf(request.getParameter("id")));
		Map<String, Object> edit = boardService.getBoardById(Integer.parseInt(String.valueOf(request.getParameter("id"))));
		Map<String, Object> file = new HashMap<>();

		edit.put("title", request.getParameter("title"));
		edit.put("content", request.getParameter("content"));

		boardService.edit(edit);
		
		for(MultipartFile uploadFile : uploadFiles) {
			if(!uploadFile.isEmpty()) {
				String originalName = uploadFile.getOriginalFilename();
				//String fileName = originalName.substring(originalName.lastIndexOf("//")+1);
				//System.out.println("originalName : " + originalName);
		
				String fullPath = uploadDir + originalName;
				uploadFile.transferTo(new File(fullPath));
				
				file.put("org_file_name", originalName);
				file.put("board_id", id);
			
				System.out.println(file);
			
				boardService.fileUpload(file);
			}
		}
		

		return "redirect:/view?id="+id;
	}
	
	@RequestMapping(value = "/editUpload", method = RequestMethod.POST)
	public String editUpload(Model model, HttpServletRequest request, @RequestParam List<MultipartFile> uploadFiles) throws IOException {
		int id = Integer.parseInt(String.valueOf(request.getParameter("id")));
		
		Map<String, Object> file = new HashMap<>();
		
		//System.out.println("uploadFiles : " + uploadFiles);

		for(MultipartFile uploadFile : uploadFiles) {
			if(!uploadFile.isEmpty()) {
				String originalName = uploadFile.getOriginalFilename();
				//String fileName = originalName.substring(originalName.lastIndexOf("//")+1);
				//System.out.println("originalName : " + originalName);
		
				String fullPath = uploadDir + originalName;
				uploadFile.transferTo(new File(fullPath));
				
				file.put("org_file_name", originalName);
				file.put("board_id", id);
			
				//System.out.println(file);
			
				boardService.fileUpload(file);
			}
		}

		return "redirect:/edit";
	}


	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getList(Model model, HttpServletRequest request, 
			@RequestParam(defaultValue="1") String num) {
		Map<String, Object> map = new HashMap<>();
		
		String searchType = request.getParameter("searchType");
		String keyword = request.getParameter("keyword");
		
		map.put("searchType", searchType);
		map.put("keyword", keyword);
		
		int n = 0;
		boolean isNumber = true;
		
		for (int i = 0; i < num.length(); i++) {
			if(!Character.isDigit(num.charAt(i))) {
				isNumber =false;
			}
		}

		if(num == "" || !isNumber) {
			n = 1;
		} else {
			n = Integer.parseInt(num);
		}
	
		
		int count = boardService.boardCount(map); 
		int postNum; 
		
		if(request.getParameter("selectSize") != null) {
			postNum = Integer.parseInt(request.getParameter("selectSize"));
		} else {
			postNum = 10;
		}
		  
		int pageNum = (int)Math.ceil((double)count/postNum);
		int postStart = (n - 1) * postNum;
		
		// 한번에 표시할 페이징 번호의 갯수
		int pageNum_cnt = 10;
		
		// 표시되는 페이지 번호 중 마지막 번호
		int endPageNum = (int)(Math.ceil((double)n / (double)pageNum_cnt) * pageNum_cnt);

		// 표시되는 페이지 번호 중 첫번째 번호
		int startPageNum = endPageNum - (pageNum_cnt - 1);
		
		// 마지막 번호 재계산
		int endPageNum_tmp = (int)(Math.ceil((double)count / (double)postNum));
		 
		if(endPageNum > endPageNum_tmp) {
			endPageNum = endPageNum_tmp;
		}

		boolean prev = n == 1 ? false : true;
		boolean next = n == pageNum ? false : true;
		
		// 시작 및 끝 번호
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		
		// 이전 및 다음 
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);
		model.addAttribute("n", n);
		model.addAttribute("num", num);
		
		model.addAttribute("postNum", postNum);
		model.addAttribute("searchType", request.getParameter("searchType"));
		model.addAttribute("keyword", request.getParameter("keyword"));
		
		// 현재 페이지
		model.addAttribute("select", num);
		
		map.put("postStart", postStart); 
		map.put("postNum", postNum);
		
		List<Map<String, Object>> list = boardService.getBoardByKeyword(map);
		model.addAttribute("list", list);
		model.addAttribute("pageNum",pageNum);
		//model.addAttribute("endPageNum",endPageNum);

		return "list";
	}


	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String getWriteView(Model model, HttpServletRequest request) {
		return "write";
	}
	
	private final String uploadDir = "C:\\Users\\user\\Documents\\git\\sample\\attach\\";

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(Model model, HttpServletRequest request, @RequestParam List<MultipartFile> uploadFiles) throws IOException {
		Map<String, Object> map = new HashMap<>();
		Map<String, Object> file = new HashMap<>();

		map.put("title", request.getParameter("title"));
		map.put("writer", request.getParameter("writer"));
		map.put("content", request.getParameter("content"));
		
		boardService.add(map);
		
		int id = (int) map.get("id");
		
		for(MultipartFile uploadFile : uploadFiles) {
			if(!uploadFile.isEmpty()) {
				String originalName = uploadFile.getOriginalFilename();
				//String fileName = originalName.substring(originalName.lastIndexOf("//")+1);
				//System.out.println("originalName : " + originalName);
				//Long fileSize = uploadFile.getSize();
		
				String fullPath = uploadDir + originalName;
				uploadFile.transferTo(new File(fullPath));
				
				file.put("org_file_name", originalName);
				file.put("board_id", id);
			
				//System.out.println(file);
			
				boardService.fileUpload(file);
			}
		}
		
		return "redirect:/list";
	}
	
	@GetMapping("/download/{file_no}")
	public String  download(@PathVariable Integer file_no, Model model, HttpServletResponse response) throws IOException {
		// file search 
		Map<String, Object> fileInfo = boardService.getFileByFileNo(file_no);
		model.addAllAttributes(fileInfo);
		
		return "fileDownloadView";
	}
}
