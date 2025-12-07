package com.shubham.mono.assignment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileServiceImpl implements FileService {
    private static final Logger log = LogManager.getLogger(FileServiceImpl.class);

    @Override
    public Mono<String> readFile(String filePath) {
        log.info("read file");
        return Mono.fromCallable(() -> Files.readString(Path.of(filePath)))
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Mono<Void> writeFile(String filePath, String content) {
        log.info("write file");
        return Mono.fromRunnable(() -> {
            try {
                Files.writeString(Path.of(filePath), content);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).subscribeOn(Schedulers.boundedElastic()).then();
    }

    @Override
    public Mono<Void> deleteFile(String filePath) {
        log.info("delete file");
        return Mono.fromRunnable(() -> {
            try {
                Files.delete(Path.of(filePath));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).subscribeOn(Schedulers.boundedElastic()).then();
    }
}
