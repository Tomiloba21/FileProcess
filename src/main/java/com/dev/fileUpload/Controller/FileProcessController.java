package com.dev.fileUpload.Controller;

import com.dev.fileUpload.Service.TextProcessorService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author
 * 8/17/24
 */

@Controller
@AllArgsConstructor

public class FileProcessController {

    private final TextProcessorService textProcessorService;


    @GetMapping("/")
  public String fileUpload() {
      return "index";
  }

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
