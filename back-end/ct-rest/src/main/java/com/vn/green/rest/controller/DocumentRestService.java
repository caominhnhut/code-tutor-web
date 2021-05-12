package com.vn.green.rest.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vn.green.document.DocumentService;
import com.vn.green.persistent.entity.DocumentEntity;
import com.vn.green.validation.ValidationException;

@RestController
public class DocumentRestService {

    @Autowired
    private DocumentService documentService;

    @PostMapping(value = "/document/upload")
    @PreAuthorize("hasRole('ROLE_GUESS') or hasRole('ROLE_STUDENT') or hasRole('ROLE_TEACHER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<DocumentEntity> uploadFile(@RequestParam("file") MultipartFile file) throws ValidationException {

        DocumentEntity documentEntity = documentService.storeImage(file);
        return new ResponseEntity<>(documentEntity, HttpStatus.CREATED);
    }

    @PostMapping(value = "/document/upload-files")
    @PreAuthorize("hasRole('ROLE_GUESS') or hasRole('ROLE_STUDENT') or hasRole('ROLE_TEACHER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<DocumentEntity>> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {

//        List<DocumentEntity> fileEntities = Arrays.asList(files).stream().map(file -> {
//            try {
//                return documentService.storeImage(file);
//            } catch (ValidationException e) {
//                return new ResponseEntity<>(String.format("File not found: [%s]", e.getMessage()), HttpStatus.NOT_FOUND);
//            }
//        }).collect(Collectors.toList());
//
//        return new ResponseEntity<>(fileEntities, HttpStatus.CREATED);
        return null;
    }

    @GetMapping(value = "/no-auth/document/file-content")
    public ResponseEntity downloadFile(@RequestParam("filename") String filename) {

        byte[] content;

        try {
            content = documentService.loadFileByName(filename);
        } catch (IOException e) {
            return new ResponseEntity<>(String.format("File not found: [%s]", e.getMessage()), HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"").body(new ByteArrayResource(content));
    }
}
