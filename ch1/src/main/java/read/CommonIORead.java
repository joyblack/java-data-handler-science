package read;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class CommonIORead {
    public static void main(String[] args) {
        String file = "天净沙-秋思.poetry";
        try {
            String content = FileUtils.readFileToString(new File(file), "UTF-8");
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
