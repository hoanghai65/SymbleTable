import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        // SymbleTable<Student,Double> st = new LinkListSymbleTable<>();
        // st.put(new Student(123, "Nguyen Tung Duong", 20), 8.5);
        // Student s = new Student(456, "Nguyen Anh Tuan", 20);
        // st.put(s, 10.0);
        // st.put(new Student(789, "Hoang Duc Hai", 20), 10.0);
        // st.delete(s);
        // System.out.println(st.Keys());
        SymbleTable<String, Integer> st = new WordCount<>();
        String path = "data\\input.txt";

        List<String> list = Files.readAllLines(Path.of(path));
        List<String> lines = list.stream().filter(line -> line.length() >= 1).toList();
        for (String line : lines) {
            String[] words = line.toLowerCase().split("[\s.,:;)\t\"(]+");
            for (String word : words) {
                if (st.constain(word)) {
                    st.put(word, st.get(word) + 1);
                } else {
                    st.put(word, 1);
                }
            }
        }

        SymbleTable<String,Integer> st2 = new LinkListSymbleTable<>();
        for(String i : st.Keys()){
            if(st.get(i) >= 3){
                st2.put(i, st.get(i));
            }
        }
        for (String i : st2.Keys()) {
            System.out.print(i + "= " + st2.get(i) + " ,");
        }

    }
}
