package com.shubham.mono.assignment;

import reactor.core.publisher.Mono;

public interface FileService {
    Mono<String> readFile(String filePath);

    Mono<Void> writeFile(String filePath, String content);

    Mono<Void> deleteFile(String filePath);
}
