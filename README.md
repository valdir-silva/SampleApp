SampleApp

Este projeto é um exemplo de aplicativo Android que serve como base para o desenvolvimento de apps modernos e robustos. Ele demonstra a implementação de uma arquitetura moderna utilizando Server-Driven UI (SDUI) para uma interface flexível e dinâmica, MVVM com Clean Architecture para um código modular e testável, e Jetpack Compose para a construção da interface do usuário.
Tecnologias e Padrões:
SDUI: Permite que o servidor defina a estrutura da interface, proporcionando maior flexibilidade e controle.
MVVM + Clean Architecture: Separa as responsabilidades do código em camadas bem definidas, com Use Cases para interação com a camada de domínio, garantindo um código mais limpo, testável e fácil de manter.
Jetpack Compose: Framework moderno de interface do usuário do Android, ideal para a construção de interfaces dinâmicas e reativas, como as utilizadas em SDUI.
Koin: Framework de injeção de dependências para facilitar a gestão das dependências do projeto.
Moshi: Biblioteca para serialização e desserialização JSON, utilizada para converter os dados recebidos da API em objetos Kotlin.
Retrofit e OkHttp3: Bibliotecas para comunicação com APIs REST, responsáveis por realizar as requisições HTTP e tratar as respostas.
Funcionalidades:
O aplicativo demonstra como exibir conteúdo dinâmico definido pelo servidor através do SDUI.
Implementa o mapeamento das respostas da API para modelos de dados utilizados na interface do usuário.
Utiliza mocks para simular o comportamento da API durante o desenvolvimento e testes.
Diferenciais:
Arquitetura robusta e moderna, com foco em modularidade, testabilidade e boas práticas de desenvolvimento.
Implementação de mocks dinâmicos, permitindo a simulação de diferentes cenários e respostas da API.
Próximos Passos:
Implementar a interface do usuário completa com Jetpack Compose, consumindo os dados do SDUI.
Integrar o aplicativo com a API real e implementar a lógica para processar as respostas.
Adicionar tratamento de erros para lidar com problemas de conexão e respostas inválidas da API.
Escrever testes unitários e de integração para garantir a qualidade e o funcionamento correto do código.
Modularizar o projeto em diferentes módulos para melhorar a organização, reutilização de código e escalabilidade.
Substituir o RetroMock por uma implementação própria para mocks, com maior controle e customização.
Criar um módulo que se integra com o Gemini, permitindo solicitar o JSON do SDUI via texto e atualizar a interface do aplicativo dinamicamente.
Configurar um pipeline de CI/CD para automatizar o processo de build, teste e deploy do aplicativo.
Objetivo:
Este projeto tem como objetivo servir como guia e ponto de partida para o desenvolvimento de aplicativos Android modernos, eficientes e escaláveis. Ele demonstra a implementação de uma arquitetura robusta e de fácil manutenção, utilizando tecnologias e padrões amplamente adotados na comunidade Android. Sinta-se à vontade para explorar, modificar e adaptar o código às suas necessidades!
