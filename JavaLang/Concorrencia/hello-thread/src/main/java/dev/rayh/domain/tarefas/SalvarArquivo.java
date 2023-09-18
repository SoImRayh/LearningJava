package dev.rayh.domain.tarefas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SalvarArquivo implements Runnable {

    private String name;
    private String text;

    
    @Override
    public void run() {
        try(
            FileOutputStream out = new FileOutputStream(name);
        ){
            List<String> lines;

            if (Files.exists(Paths.get("./testando"))){
                lines = Files.readAllLines(Paths.get("./testando"));
            }else{
                lines = new ArrayList<>(10);
            }
                
            
            lines.add(text);

            Files.write(Paths.get("./testando"), lines);

        }catch(FileNotFoundException e) {
            System.out.println("deu ruim");
        }catch(IOException e){
            System.out.println("deu mais ruim ainda");        
        }

    }
    
}
