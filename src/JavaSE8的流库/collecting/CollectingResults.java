package JavaSE8的流库.collecting;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingResults {
    public static Stream<String> noVowels() throws IOException {
        String contents = Files.readString(Paths.get("gutenberg/alice30.txt"), StandardCharsets.UTF_8);
        List<String> wordList = Arrays.asList(contents.split("\\PL+"));
        Stream<String> words = wordList.stream();
        return words.map(s -> s.replaceAll("[aeiouAEIOU]", ""));
    }

    public static <T> void show(String label, Set<T> set) {
        System.out.print(set.getClass().getName() + "  ");
        System.out.println(set.stream().limit(10).map(Objects::toString).collect(Collectors.joining(",")));
    }

    public static void main(String[] args) throws IOException {
        Iterator<Integer> iter = Stream.iterate(0, n -> n + 1).limit(10).iterator();
        while (iter.hasNext())
            System.out.println(iter.next());

        Object[] numbers = Stream.iterate(0, n -> n + 1).limit(10).toArray();
        System.out.println(numbers);

        try {
            Integer number = (Integer) numbers[0];
            System.out.println(number);
            System.out.println((Integer[]) numbers);
        } catch (Exception exception) {
            System.out.println(exception);
        }

        Object[] numbers3 = Stream.iterate(0, n -> n + 1).limit(10).toArray(Integer[]::new);
        System.out.println(Arrays.toString(numbers3));

        Set<String> noVowelSet = noVowels().collect(Collectors.toSet());
        show("noVowelSet", noVowelSet);

        TreeSet<String> noVowelTreeSet = noVowels().collect(Collectors.toCollection(TreeSet::new));
        show("noVowelTreeSet", noVowelTreeSet);

        String result = noVowels().limit(10).collect(Collectors.joining());
        System.out.println(result);

        result = noVowels().limit(10).collect(Collectors.joining(","));
        System.out.println(result);

        IntSummaryStatistics summary = noVowels().collect(Collectors.summarizingInt(String::length));
        System.out.println(summary.getAverage());
        System.out.println(summary.getMax());

        noVowels().limit(10).forEach(System.out::print);
    }
}
