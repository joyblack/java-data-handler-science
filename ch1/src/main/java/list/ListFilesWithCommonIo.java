package list;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

import java.io.File;
import java.util.List;

public class ListFilesWithCommonIo {
    public static void main(String[] args) {
        List<File> files = ListFilesWithCommonIo.listFiles(new File("D:/hadoop"));
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }

    }

    public static List<File> listFiles(File rootDir){
        return (List<File>)FileUtils.listFiles(rootDir, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
        // 若需要返回目录
        //return (List<File>)FileUtils.listFilesAndDirs(rootDir, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
    }


}
