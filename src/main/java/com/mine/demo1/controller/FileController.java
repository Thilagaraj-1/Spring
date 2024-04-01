package com.mine.demo1.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/file")
public class FileController {
	
	@Autowired
	private Environment env;
	
	@PostMapping("/upload")
	public ResponseEntity<?> uploadfile(@RequestParam("file") MultipartFile uploadedFile){
		if(uploadedFile.isEmpty()) {
			return new ResponseEntity<>("Please select a file!", HttpStatus.OK);
		}
		try {
			byte[] bytes = uploadedFile.getBytes();
			
			UUID uuid = UUID.randomUUID();
//			String uploadsLocation = env.getProperty("resource.uploads");
			String uploadsLocation = "C:\\Users\\naresh\\eclipse-springspace\\demo1/src/main/resources/uploads/";
			String fileLocation = uploadsLocation + uuid + uploadedFile.getOriginalFilename();
			Path path = Paths.get(fileLocation);
			Files.write( path, bytes);
			
			File file = new File(fileLocation);
			return ResponseEntity.status(HttpStatus.OK).body(file.getName());
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.CREATED).body(e.getMessage());
		}
	}
}
