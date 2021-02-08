package JavaSE8的流库.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) throws IOException {
        String contents = Files.readString(Path.of("gutenberg/alice30.txt"));
        List<String> wordList = Arrays.asList(contents.split("\\PL+"));
        Stream<String> longWords = wordList.stream().filter(s -> s.length()>12);
//        longWords.forEach(System.out::println);
//        longWords.map(String::toUpperCase).forEach(System.out::println);
//        Object[] list = Stream.iterate(1, i -> i*2).limit(10).peek(System.out::println).toArray();

        Optional<String> largest = wordList.stream().max(String::compareToIgnoreCase);
//        System.out.println(largest.orElse(""));
//        System.out.println(wordList.stream().filter(s -> s.startsWith("Q")).findFirst());
        Optional<String> optionalString = wordList.stream().max(Comparator.comparingInt(String::length));
        String result = optionalString.orElse("");
        result = optionalString.orElseGet(() -> Locale.getDefault().getDisplayName());
        result = optionalString.orElseThrow(IllegalAccessError::new);
        Optional optional = Optional.of("123");
        System.out.println(result);
    }
}
