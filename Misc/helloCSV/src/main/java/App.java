import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvBindAndJoinByName;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class App {

    record CsvObject (
            @CsvBindByName String nome,
            @CsvBindByName int jan,
            @CsvBindByName int fev,
            @CsvBindByName int mar,
            @CsvBindByName int abr
    ){}
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\Coordenador\\IdeaProjects\\LearningJava\\Misc\\helloCSV\\src\\main\\resources\\base.csv");

        try {
            List<String[]> list = readAllLines(path);

            list.forEach(strings -> {
                for (String s :
                        strings) {
                    System.out.println(s);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    static public List<String[]> readAllLines(Path path) throws IOException {
        try (Reader reader = Files.newBufferedReader(path)){

            CSVParser parser = new CSVParserBuilder()
                    .withSeparator(',')
                    .withIgnoreQuotations(true)
                    .build();

            try (CSVReader csvReader = new CSVReaderBuilder(reader)
                    .withSkipLines(0)
                    .withCSVParser(parser)
                    .build()){

                return csvReader.readAll();
            } catch (CsvException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
