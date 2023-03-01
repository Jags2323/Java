import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        List<String> stringList = Files.lines(Paths.get("URl")) // URL path
                .filter(line->line.contains("names")) //find the string
                .map(line-> line.trim().replaceAll("names", "") //replace the string with another string
                        .replaceAll("<","")
                        .replaceAll(">",""))
                        .toList();  // collect to store the stream
        System.out.println(stringList);  //print the stream
    }
}
