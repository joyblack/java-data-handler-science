package list;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class ListFilesWithSimple {
    public static void main(String[] args) {
        // 1.使用java从分层目录中提取所有文件名
        Set<File> files = ListFilesWithSimple.listFiles(new File("D:/hadoop"));
        for (File file : files) {
            System.out.println(file.getPath());
        }
    }

    // 1. 从分层目录中提取所有文件名(注意不包含文件夹)
    public static Set<File> listFiles(File rootDir){
        Set<File> fileSet = new HashSet<File>();
        // when file is null or file is not a directory.
        if(rootDir == null || rootDir.listFiles() == null){
            return fileSet;
        }
        for (File file : rootDir.listFiles()) {
            if(file.isFile()){
                fileSet.add(file);
            }else{
                fileSet.addAll(listFiles(file));
            }
        }
        return fileSet;
    }
}
