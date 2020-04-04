# Desafio Codenation

    <p>A proposta do Desafio é Criar uma pequena rotina onde se recebe um Json com uma mensagem</br> encriptografada utilizando a Cifra de Cesar, essa mensagem deverá sofrer um "decripty" e ser enviada com a resposta.</p>

# Cifra de Cesar

    <p>Segundo o Wikipedia, criptografia ou criptologia (em grego: kryptós, “escondido”, e gráphein, “escrita)</br> é o estudo e prática de princípios e técnicas para comunicação segura na presença de terceiros, chamados “adversários”.</br>
    Mas geralmente, a criptografia refere-se à construção e análise de protocolos que impedem terceiros, ou o</br> público, de lerem mensagens privadas. Muitos aspectos em segurança da informação, como </br>confidencialidade, integridade de dados, autenticação e não-repúdio são centrais à criptografia </br>moderna. Aplicações de criptografia incluem comércio eletrônico, cartões de pagamento baseados em chip, </br>moedas digitais, senhas de computadores e comunicações militares. Das Criptografias mais curiosas na </br>história da humanidade podemos citar a criptografia utilizada pelo grande líder militar romano Júlio César para comunicar com os seus generais. Essa criptografia se baseia na substituição da letra do </br>alfabeto avançado um determinado número de casas. Por exemplo, considerando o número de casas = 3:</p>

    Normal: a ligeira raposa marrom saltou sobre o cachorro cansado

    Cifrado: d oljhlud udsrvd pduurp vdowrx vreuh r fdfkruur fdqvdgr

# Projeto

    O Projeto foi criado em Java (8), utilizando maven para gerenciamento de dependência, utiliza algumas libs</br> para determinados processos:

        #org.json - Conversão do Json para Objeto
        <dependency>
            <groupId>org.json</groupId>
            <artifactId>json</artifactId>
            <version>20190722</version>
        </dependency>

        #com.google.code.gson - Manipulação do Json
        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.8.6</version>
        </dependency>

        #org.slf4j - Manipulação dos Logs
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>1.7.25</version>
        </dependency>

# Rotina

    A rotina se excuta nas seguintes etapas:

        * 1 - Envia-se um get para a Api
        * 2 - Converte-se o Json recebido no objeto 'Answer'
        * 3 - Decodifica a mensagem
        * 4 - Salva o arquivo 'answer.json'
        * 5 - Envia-se um post para Api com o arquivo 'answer.json' no formato 'multipart/form-data'