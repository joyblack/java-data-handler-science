package filter;

import com.sun.media.jfxmedia.track.Track;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class FilterASCII {
    public static void main(String[] args) {
        try {
            System.out.println(cleanText("this s a 赵义    text."));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String cleanText(String text){
        // 1.去除所有非ASCII字符
        text = text.replaceAll("[^\\p{ASCII}]","");
        // 2.去除多余的空格
        text = text.replaceAll("\\s+"," ");
        // 3.清除ASCII控制字符
        text = text.replaceAll("[\\p{Cntrl}]","");
        // 4.清除非打印字符
        text = text.replaceAll("[^\\p{Print}]","");
        return text;
    }
}
