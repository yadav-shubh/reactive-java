package com.shubham.mono.assignment;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        FileService fileService = new FileServiceImpl();
        fileService.writeFile("test1.txt", "Hello World").subscribe();
//        fileService.readFile("test.txt").subscribe(System.out::println);
//        fileService.deleteFile("test.txt").subscribe();
        System.in.read();
    }
}
