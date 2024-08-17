package com.dev.fileUpload.Service.ServiceImpl;

import com.dev.fileUpload.Service.TextProcessorService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author tomiloba
 * 8/17/24
 */

@Service
public class TextProcessorServiceImpl implements TextProcessorService {
    @Override
    public String processText(String text) {
        String[] words = text.split("\\W+");
        Map<String, Long> wordCountMap = Arrays.stream(words)
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

        String mostUsedWord = Collections.max(wordCountMap.entrySet(), Map.Entry.comparingByValue()).getKey();
        return text.replace("\\b" +mostUsedWord+"\\b","foo" + mostUsedWord + "bar");
    }
}
