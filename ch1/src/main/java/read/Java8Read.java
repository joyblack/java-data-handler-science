package read;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Java8Read {
    public static void main(String[] args) {
        // 文件
        String file = "锦瑟.poetry";
        try {
            Stream<String> lines = Files.lines(Paths.get(file));
            // 显示每一行数据
            lines.forEach(line -> System.out.println(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
