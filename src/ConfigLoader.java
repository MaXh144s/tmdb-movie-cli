package src;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

    public static String getApiKey() {
        try (FileInputStream in = new FileInputStream("config.properties")) {
            Properties props = new Properties();
            props.load(in);

            String chave = props.getProperty("TMDB_API_KEY");

            if (chave == null || chave.isBlank()) {
                throw new TmdbException(
                        "TMDB_API_KEY não configurada em config.properties.");
            }

            return chave.trim();
        }

        catch (IOException e) {
            throw new TmdbException(
                    "Arquivo config.properties não encontrado. Copie config.example.properties e preencha sua chave.o. ");
        }
    }

}
