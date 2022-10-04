package com.example.demo.view;

import java.io.File;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

@Component("fileDownloadView")
public class FileDownloadView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
		HttpServletResponse response) throws Exception {
			String originalName = (String) model.get("org_file_name");
		
			String path = "C:\\Users\\user\\Documents\\git\\sample\\attach\\"+originalName;
	    
			byte[] fileByte = FileUtils.readFileToByteArray(new File(path));

			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(originalName, "UTF-8")+"\";");
			response.setHeader("Content-Transfer-Encoding", "binary");

			response.getOutputStream().write(fileByte);
			response.getOutputStream().flush();
			response.getOutputStream().close();
	}

}
