package org.yuxuan.springmvc.controller;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	@Value("ok")
	private String OK;
	
	@Value("wrong")
	private String WRONG;
	
	/**
	 * 使用MultipartFile接收上传的文件
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody String upload(MultipartFile file) {
		try {
			//	使用FileUtils.writeByteArrayToFile快速写文件到磁盘
			FileUtils.writeByteArrayToFile(new File("D:/temp/" + file.getOriginalFilename()), file.getBytes());
			return OK;
		} catch (IOException e) {
			e.printStackTrace();
			return WRONG;
		}
	}
	
}
