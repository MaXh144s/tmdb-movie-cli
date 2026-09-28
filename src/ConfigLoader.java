package src;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

    public String getApiKey(){
        try(FileInputStream in = new FileInputStream("config.properties")){
        Properties props = new Properties();
        props.load(in);
        
        String chave = props.getProperty("TMDB_API_KEY");
        
        if (chave == null || chave.isEmpty()){
            System.out.println("Chave não encontrada ou inexistente.");
        }

        return chave;
        } 

        catch (IOException e){
            System.err.println("Erro ao carregar o arquivo de configurações: " + e.getMessage());
            return null;
        } 
    }

}
