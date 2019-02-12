package filter;

import com.univocity.parsers.common.processor.RowListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import com.univocity.parsers.tsv.TsvParser;
import com.univocity.parsers.tsv.TsvParserSettings;

import java.io.File;
import java.util.Arrays;
import java.util.List;


public class UnivocityTest2 {
    public static void main(String[] args) {
        String fileName = "模块表.tsv";
        parseTSV(fileName);
    }

    public static void parseTSV(String fileName){
        // 创建一个配置对象，并配置
        TsvParserSettings settings = new TsvParserSettings();
        // 设置行分隔符
        settings.getFormat().setLineSeparator("\n");
        // 使用配置创建一个parser
        TsvParser parser = new TsvParser(settings);
        // 将文件内容一次性解析出来
        List<String[]> rows = parser.parseAll(new File(fileName));
        for (String[] row : rows) {
            System.out.println(Arrays.asList(row));
        }

    }
}
