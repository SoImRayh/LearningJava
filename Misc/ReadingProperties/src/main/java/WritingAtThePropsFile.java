import java.io.*;
import java.time.LocalDate;
import java.util.Properties;

public class WritingAtThePropsFile {
    public static void main(String[] args) {
        final String PATH = WritingAtThePropsFile.class.getClassLoader().getResource("props.properties").getPath();
        File file = new File(PATH);
        Properties props = new Properties();
        System.out.println(file.getName());

        try (
                InputStream in = WritingAtThePropsFile.class.getClassLoader().getResourceAsStream(file.getName());
                OutputStream out = new FileOutputStream(file);
                ) {
            props.load(in);
            System.out.println(props.getProperty("text"));
            props.setProperty("user", "70721433197");


            props.store(out, LocalDate.now().toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
