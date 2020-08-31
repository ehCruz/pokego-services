### Pokego REST API
##

#### Breve Descrição
Code challenge - JUNO

Criação de uma aplicação JAVA para a coleção de Pokemóns!

#### Pontos de Interesse
 - Para simplicidade na hora configuração de ambiente, esta aplicação foi desenvolvida utilizando SpringBoot. 
 - Persistencia de dados é feita através do JPA junto com o banco de dados HSQL(in-memory). 
 - Os endpoints desta REST API foram desenvolvidos com Spring MVC e documentados seguindo a especificação Open API.

#### Diagrama de classe
![alt text](https://github.com/ehCruz/sample-1/blob/master/diagrama.png?raw=true)

#### Configuração do Ambiente

Após baixar o repositório e as dependências do maven antes de rodar o servido TomCat embeded do Spring Boot, é necessário
configurar o banco de dados HSQL(in memory).
Se estiver usando o IntelliJ basta adicionar uma "Application" nova com as seguintes informações:

Main Class: `org.hsqldb.Server`

Program Arguments: `-database.0 myServerDB -dbname.0 myServerDB -port 9137`

Working directory: `<path_projeto>/pokego-services/bancoDados`

Como ilustrado a seguir:
![alt text](https://github.com/ehCruz/sample-1/blob/master/Screenshot%20from%202020-08-30%2015-46-55.png?raw=true)

Configuração de usuário e senha já está presente no arquivo `application.properties` dentro da aplicação.

Para mais informações e também como configurar o HSQL no eclipse leia [este artigo](http://mauda.com.br/?p=495).

Tendo realizado a configuração do HSQL e iniciando-o, podemos startar a aplicação.
Necessário fazer o download da aplicação front end deste desafio([link](https://github.com/ehCruz/pokego-front)).


### Endpoints

Para uma visão geral de todos os endpoint bastar acessar gearada através da Open API, no link `<url>/SAD-Services/swagger-ui.html`.

Dúvidas pode me contatar pelo meu e-mail.
