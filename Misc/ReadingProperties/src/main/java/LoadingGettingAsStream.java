import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadingGettingAsStream {
    public static void main(String[] args) {
        try (InputStream inputStream = LoadingGettingAsStream.class.getClassLoader().getResourceAsStream("props.properties")){
            Properties props = new Properties();

            if (inputStream == null){
                System.out.println("deu algo errado");
            }
            props.load(inputStream);

            System.out.println(props.getProperty("text"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
