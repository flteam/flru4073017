package uril;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtil {

    private FileUtil() {
    }

    public static List<String> getUrlsFromFile(String fileName) {
        List<String> urls = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(FileUtil.class.getResource("/" + fileName).getFile()))) {
            while (scanner.hasNextLine()) {
                String url = scanner.nextLine();
                urls.add(url);
            }
            return urls;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
