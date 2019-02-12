package read;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;

import java.io.FileInputStream;
import java.io.InputStream;

public class TiKaRead {
    public static void main(String[] args) {
        String content = readPDF("他不懂.pdf");
        System.out.println(content);
    }

    public static String readPDF(String fileName){
        InputStream inputStream = null;
        String content = "";
        try {
            inputStream = new FileInputStream(fileName);
            // 创建一个自动解析器
            AutoDetectParser parser = new AutoDetectParser();
            // 使用-1表示不对文件内容的大小进行限制
            BodyContentHandler handler = new BodyContentHandler(-1);
            Metadata metaData = new Metadata();
            parser.parse(inputStream, handler, metaData, new ParseContext());
            System.out.println(metaData);
            // 调用Handler对象的toString获取正文内容
            content = handler.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(inputStream != null){
                try{
                    inputStream.close();
                }catch (Exception e){
                    System.out.println("Error Closing input stream.");
                }
            }
        }
        return content;
    }
}
