package com.dev.fileUpload.Controller;

import com.dev.fileUpload.Service.TextProcessorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author tomiloba
 * 8/17/24
 */

@RestController
@AllArgsConstructor
@CrossOrigin
public class FileProcessController {

    private final TextProcessorService textProcessorService;

    @PostMapping("/process-file")
    public ResponseEntity<String> processFile(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("File is empty");
        }

        String contents = new String(file.getBytes());
        String processedText = textProcessorService.processText(contents);

        return ResponseEntity.ok().body(processedText);

    }
}
