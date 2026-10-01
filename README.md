# TMDB Movie CLI

Ferramenta de linha de comando em Java que consulta a API do [The Movie Database (TMDB)](https://www.themoviedb.org/) e exibe no terminal listas de filmes: populares, em cartaz, mais bem avaliados e próximos lançamentos.

## Tecnologias

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Gson](https://img.shields.io/badge/Gson-2.14.0-4285F4?style=for-the-badge&logo=google&logoColor=white)
![TMDB](https://img.shields.io/badge/TMDB-API%20v3-01B4E4?style=for-the-badge&logo=themoviedatabase&logoColor=white)
![Windows](https://img.shields.io/badge/Script-.bat-0078D6?style=for-the-badge&logo=windows&logoColor=white)

- Java 21
- [Gson 2.14.0](https://github.com/google/gson), para converter o JSON da API em objetos Java
- `java.net.http.HttpClient`, para as requisições
- API do TMDB, versão 3

## Pré-requisitos

- JDK instalado (o projeto foi desenvolvido com Java 21)
- Uma conta no TMDB e uma **API Key (v3)**

## Instalação

1. Clone o repositório:

```bash
git clone <url-do-repositorio>
cd <pasta-do-projeto>
```

2. Confirme que o jar do Gson está em `lib/` (`lib/gson-2.14.0.jar`). Se não estiver, baixe-o no [Maven Central](https://central.sonatype.com/artifact/com.google.code.gson/gson) e coloque lá.

3. Gere sua chave no TMDB (https://developer.themoviedb.org/docs/getting-started). Use a **API Key**, e não o *API Read Access Token*, que é outra credencial e não funciona neste projeto.

4. Copie o arquivo de exemplo e coloque sua chave:

```bash
copy config.example.properties config.properties
```

Edite o `config.properties`:

```properties
TMDB_API_KEY=sua_chave_aqui
```

> O `config.properties` está no `.gitignore` e não deve ser enviado ao repositório.

## Compilação

```bash
javac -cp "lib/gson-2.14.0.jar" -d bin src/*.java
```

## Uso

Execute a partir da raiz do projeto, **pelo terminal** (não funciona por duplo clique):

```bash
tmdb-app --type <tipo>
```

| Tipo       | O que mostra                  | Endpoint TMDB |
|------------|-------------------------------|---------------|
| `popular`  | Filmes populares              | `popular`     |
| `playing`  | Filmes em cartaz              | `now_playing` |
| `top`      | Filmes mais bem avaliados     | `top_rated`   |
| `upcoming` | Próximos lançamentos          | `upcoming`    |

Exemplos:

```bash
tmdb-app --type popular
tmdb-app --type upcoming
```

Sem o `.bat` (ou fora do Windows), rode direto com o Java.

Windows:

```bash
java -cp "bin;lib/gson-2.14.0.jar" src.Main --type popular
```

Linux/Mac:

```bash
java -cp "bin:lib/gson-2.14.0.jar" src.Main --type popular
```

### Exemplo de saída

```
<cole aqui um trecho real da saída do terminal>
```

## Tratamento de erros

As mensagens de erro vão para `System.err` e o programa encerra com código de saída 1.

| Situação                             | Mensagem                                   |
|--------------------------------------|--------------------------------------------|
| Argumentos ausentes ou incorretos    | Exibe o uso correto do comando             |
| Tipo inexistente                     | Tipo de filme inválido                     |
| `config.properties` ausente          | Orienta a criar o arquivo a partir do exemplo |
| `TMDB_API_KEY` vazia ou ausente      | Informa que a chave não foi configurada    |
| Chave rejeitada pela API             | API key inválida                           |
| Limite de requisições                | Limite de requisições atingido             |
| Sem conexão ou tempo esgotado        | Erro de conexão com o TMDB                 |
| Resposta fora do formato esperado    | Resposta inesperada da API                 |

## Estrutura do projeto

```
├── bin/                         classes compiladas (gerada, fora do Git)
├── lib/                         gson-2.14.0.jar
├── src/
│   ├── Main.java                lê os argumentos e coordena o fluxo
│   ├── ConfigLoader.java        lê a chave do config.properties
│   ├── TmdbService.java         faz as requisições HTTP
│   ├── TmdbException.java       exceção própria da aplicação
│   ├── MovieJsonParser.java     converte JSON em lista de filmes
│   ├── MovieResponse.java       modelo da resposta da API
│   ├── Movie.java               modelo de um filme
│   └── MoviePrinter.java        formata a saída no terminal
├── config.example.properties    modelo do arquivo de configuração
├── tmdb-app.bat                 atalho para Windows
└── README.md
```

## Limitações

- Mostra apenas a primeira página de resultados (20 filmes).
- As sinopses e títulos vêm em inglês, que é o idioma padrão da API.
- O `tmdb-app.bat` funciona apenas no Windows.

## Créditos

Este produto usa a API do TMDB, mas não é endossado nem certificado pelo TMDB.