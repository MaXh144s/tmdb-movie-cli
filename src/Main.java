package src;
public class Main{
    public static void main(String[] args) {

        ConfigLoader cl = new ConfigLoader();

        String apiKey = cl.getApiKey();

        System.out.println("API Key carregada: " + apiKey);

        TmdbService ts = new TmdbService(apiKey);

        
        if ( args.length == 2 && args[0].equals("--type")){
            String type = args[1];
            switch (type) {
                case "popular":
                    System.out.println("-> Filmes populares");
                    System.out.println(ts.mostPopular());
                    break;

                    case "playing":
                    System.out.println("-> Filmes em cartaz");
                    System.out.println(ts.playing()); 
                    break;

                    case "top":
                    System.out.println("-> Filmes mais bem avaliados");
                    System.out.println(ts.top()); 
                    break;

                    case "upcoming":
                    System.out.println("-> próximos filmes");
                    System.out.println(ts.upcoming()); 
                    break;
            
                default:
                    System.out.println("Esse tópico não existe. Tente novamente!");
                    break;
            }

        } else {
            System.out.println("Comando não reconhecido");
        }
    }
}