package com.vn.green.rest.controller;

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

import com.vn.green.document.DocumentService;
import com.vn.green.persistent.entity.DocumentEntity;

@Controller
public class DocumentRestService
{
    private static final Logger logger = LoggerFactory.getLogger(DocumentRestService.class);

    @Autowired
    private DocumentService documentService;

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public ResponseEntity<DocumentEntity> uploadFile(@RequestParam("file") MultipartFile file)
    {
        DocumentEntity documentEntity = documentService.store(file);
        return new ResponseEntity<>(documentEntity, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/uploadMultipleFiles", method = RequestMethod.POST)
    public ResponseEntity<List<DocumentEntity>> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files)
    {
        List<DocumentEntity> fileEntities = Arrays.asList(files).stream().map(file -> documentService.store(file)).collect(Collectors.toList());

        return new ResponseEntity<>(fileEntities, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/downloadFile/{fileId}", method = RequestMethod.GET)
    public ResponseEntity<Resource> downloadFile(@PathVariable Long id)
    {
        DocumentEntity documentEntity = documentService.findById(id);

        return null;
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(documentEntity.getFileType()))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + documentEntity.getFilename() + "\"")
//                .body(new ByteArrayResource(documentEntity.getData()));
    }
}
