package filter;

import com.univocity.parsers.common.processor.RowListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class UnivocityTest {
    public static void main(String[] args) throws Exception{
        String fileName = "模块表.csv";
        parseCSV(fileName);
    }

    public static void parseCSV(String fileName) throws Exception {
        // 创建一个配置对象，并配置
        CsvParserSettings csvParserSettings = new CsvParserSettings();
        // 自动检测输入中的分隔符序列
        csvParserSettings.setLineSeparatorDetectionEnabled(true);
        // 指定把每个解析的行存储在列表中，写入配置：使用rowListProcessor配置解析器，用来对每个解析行的值进行处理
        RowListProcessor processor = new RowListProcessor();
        csvParserSettings.setProcessor(processor);
        // 若CSV文件包含标题头，则可以把第一行看做文件中每个列的标题;否则无需设置。
        //csvParserSettings.setHeaderExtractionEnabled(true);
        // 使用给定的配置创建一个parser实例
        CsvParser csvParser = new CsvParser(csvParserSettings);
        csvParser.parse(new File(fileName));

        // 默认将第一行看做头
        String[] headers = processor.getHeaders();
        System.out.println(Arrays.asList(headers));

        List<String[]> rows = processor.getRows();
        for (String[] row : rows) {
            System.out.println(Arrays.asList(row));
        }


    }
}
