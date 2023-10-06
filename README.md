# Pré-requisitos

Antes de começar a realizar o teste prático, certifique-se de atender aos seguintes pré-requisitos:

## Leitura deste Documento

* Antes de iniciar a realização do teste prático, é fundamental que você leia este documento até o final para compreender completamente os requisitos e as diretrizes.

## Linguagem de Programação

* Utilize a linguagem de programação Java para desenvolver a solução. Você tem a opção de escolher entre Spring Boot ou Quarkus como frameworks para o desenvolvimento.

# Requisitos Gerais:

- [X] Implementar mecanismo de autorização e autenticação, bem como não permitir acesso ao
endpoint a partir de domínios diversos do qual estará hospedado o serviço

- [X] A solução de autenticação deverá expirar a cada 5 minutos e oferecer a possibilidade de
renovação do período

- [X] Implementar pelo menos os verbos post, put, get

- [X] Conter recursos de paginação em todas as consultas

- [X] Os dados produzidos deverão ser armazenados no servidor de banco de dados
previamente criado em container

- [X] Orquestrar a solução final utilizando Docker Compose de modo que inclua todos os
contêineres utilizados (Servidor S3, Banco de Dados, Artefato Java)


# Requisitos Específicos:

* Implementar uma API Rest para o diagrama de banco de dados acima tomando por base as seguintes orientações:

* Criar um CRUD para Servidor Efetivo, Servidor Temporário, Unidade e Lotação. Deverá ser contemplada a inclusão e edição dos dados das tabelas relacionadas;

* Criar um endpoint que permita consultar os servidores efetivos lotados em determinada unidade parametrizando a consulta pelo atributo unid_id; Retornar os seguintes campos: Nome, idade, unidade de lotação e fotografia;

* Criar um endpoint que permita consultar o endereço funcional (da unidade onde o servidor é lotado) a partir de uma parte do nome do servidor efetivo.

## :link: Dependencias 
![SpringBoot](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![MySql](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=Swagger&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)

# Iniciar Projeto
## :desktop_computer: Start
```
mvn package
docker-compose up
```



