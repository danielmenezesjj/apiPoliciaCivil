# Pré-requisitos

Antes de começar a realizar o teste prático, certifique-se de atender aos seguintes pré-requisitos:

## Leitura deste Documento

a) Antes de iniciar a realização do teste prático, é fundamental que você leia este documento até o final para compreender completamente os requisitos e as diretrizes.

## Linguagem de Programação

b) Utilize a linguagem de programação Java para desenvolver a solução. Você tem a opção de escolher entre Spring Boot ou Quarkus como frameworks para o desenvolvimento.

## Servidor Min.io para Armazenamento S3

c) É necessário executar um servidor Min.io em um contêiner para armazenamento de objetos S3. Você pode encontrar informações sobre como configurar o Min.io em [https://min.io/](https://min.io/).

## Servidor de Banco de Dados PostgreSQL

d) Execute um servidor de banco de dados PostgreSQL em sua versão mais recente em um contêiner. Certifique-se de configurá-lo corretamente para atender às necessidades do teste.

## Conta no Serviço de Versionamento

e) Crie uma conta no serviço de versionamento em [https://git2.pjc.mt.gov.br](https://git2.pjc.mt.gov.br). Todo o código desenvolvido durante o teste prático deve ser versionado neste repositório.

Certifique-se de cumprir todos esses pré-requisitos antes de prosseguir com o teste prático. Isso garantirá uma experiência suave durante o desenvolvimento e avaliação da sua solução.
# Requisitos Gerais:

a) Implementar mecanismo de autorização e autenticação, bem como não permitir acesso ao endpoint a partir de domínios diversos do qual estará hospedado o serviço;

b) A solução de autenticação deverá expirar a cada 5 minutos e oferecer a possibilidade de renovação do período;

c) Implementar pelo menos os verbos post, put, get;

d) Conter recursos de paginação em todas as consultas;

e) Os dados produzidos deverão ser armazenados no servidor de banco de dados previamente criado em container;

f) Armazenar arquivos e imagens no servidor de armazenamento de objetos S3 previamente criado em container;

g) Orquestrar a solução final utilizando Docker Compose de modo que inclua todos os contêineres utilizados (Servidor S3, Banco de Dados, Artefato Java);

h) Utilizar Flyway Migrations para criar e popular tabelas do banco de dados.

# Requisitos Específicos:

a) Implementar uma API Rest para o diagrama de banco de dados acima tomando por base as seguintes orientações:

i) Criar um CRUD para Servidor Efetivo, Servidor Temporário, Unidade e Lotação. Deverá ser contemplada a inclusão e edição dos dados das tabelas relacionadas;

ii) Criar um endpoint que permita consultar os servidores efetivos lotados em determinada unidade parametrizando a consulta pelo atributo unid_id; Retornar os seguintes campos: Nome, idade, unidade de lotação e fotografia;

iii) Criar um endpoint que permita consultar o endereço funcional (da unidade onde o servidor é lotado) a partir de uma parte do nome do servidor efetivo.

