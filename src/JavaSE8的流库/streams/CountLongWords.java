package JavaSE8的流库.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CountLongWords {
    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("./gutenberg/alice30.txt")));
        List<String> words = Arrays.asList(contents.split("\\PL+"));
        //传统方式
        long count = 0;
        long t = System.currentTimeMillis();
        for (String w : words) {
            if (w.length() > 12) count++;
        }
        System.out.println(count);
        System.out.println((System.currentTimeMillis())-t);
        //流
        t = System.currentTimeMillis();
        count = words.stream().filter(s -> s.length()>12).count();
        System.out.println(count);
        System.out.println((System.currentTimeMillis())-t);
        //并行流
        t = System.currentTimeMillis();
        count = words.parallelStream().filter(s -> s.length()>12).count();
        System.out.println(count);
        System.out.println((System.currentTimeMillis())-t);
    }
}
