package com.gls.gs.rest.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.gls.gs.file.FileService;
import com.gls.gs.persistent.entity.FileEntity;

@Controller
public class FileRestService
{
    private static final Logger logger = LoggerFactory.getLogger(FileRestService.class);

    @Autowired
    private FileService dbFileStorageService;

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public ResponseEntity<FileEntity> uploadFile(@RequestParam("file") MultipartFile file)
    {
        FileEntity fileEntity = dbFileStorageService.store(file);
        return new ResponseEntity<>(fileEntity, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/uploadMultipleFiles", method = RequestMethod.POST)
    public ResponseEntity<List<FileEntity>> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files)
    {
        List<FileEntity> fileEntities = Arrays.asList(files).stream().map(file -> dbFileStorageService.store(file)).collect(Collectors.toList());

        return new ResponseEntity<>(fileEntities, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/downloadFile/{fileId}", method = RequestMethod.GET)
    public ResponseEntity<Resource> downloadFile(@PathVariable Long id)
    {
        FileEntity fileEntity = dbFileStorageService.findById(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(fileEntity.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileEntity.getFilename() + "\"")
                .body(new ByteArrayResource(fileEntity.getData()));
    }
}
