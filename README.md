<div align="center">
  <img width="200" height="200" src="https://img.icons8.com/color/240/star-wars.png" alt="star-wars"/>
  <h1 align="center" id="titulo">Planets Star Wars API </h1> 
</div>

<div align="center" id="badges">

  [![GitHub License](https://img.shields.io/github/license/Joao-Darwin/planets-starwars-api?style=for-the-badge)](https://github.com/Joao-Darwin/parking-api/blob/main/LICENSE)
  ![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=STATUS&message=FINISHED&color=GREEN&style=for-the-badge)
  [![GitHub closed issues](https://img.shields.io/github/issues-closed-raw/Joao-Darwin/planets-starwars-api?style=for-the-badge&color=purple)](https://github.com/Joao-Darwin/parking-api/issues?q=is%3Aissue+is%3Aclosed)
</div>

# Índice 
* [Badges](#badges)
* [Índice](#índice)
* [Sobre o Projeto](#sobreProjeto)
* [Técnologias Usadas](#techs)
* [Executar o Projeto](#execute)
* [Autor](#author)

<h1 id="sobreProjeto">Sobre o Projeto</h1>

O Planet Star Wars API é um projeto que criei para os fãs da saga galáctica. Esta API permite que você armazene e recupere informações detalhadas sobre os planetas do universo Star Wars de forma fácil e precisa. 

Utilizando o framework Spring Boot, implementei conceitos avançados de desenvolvimento de APIs, incluindo negociação de conteúdo para suportar formatos JSON e XML, HATEOAS para tornar as interações mais dinâmicas e CORS para facilitar a integração com diferentes origens. Ao se comunicar diretamente com a API oficial, garantimos que os dados fornecidos sejam sempre atualizados e confiáveis. 

Este projeto é uma homenagem à rica diversidade planetária que enriquece a mitologia de Star Wars, oferecendo aos desenvolvedores uma ferramenta poderosa para explorar e compartilhar informações sobre esses mundos fascinantes. Que a Força esteja com você ao usar o Planet Star Wars API!

## Camadas lógicas
![Modelo Conceitual](https://github.com/Joao-Darwin/repoImgs/blob/main/Imgs%20-%20Web%20Service%20SpringBoot/camadasLogicas.png)

<h1 id="techs">Técnologias Usadas</h1>

### API
  
  ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
  
  ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
  
  ![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
  
  ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
  
### Database
  
  ![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)

<h1 id="execute">Executar o Projeto</h1>
Pré-requisitos: Java 17 e Maven

### Clonar repositório
```bash
git clone https://github.com/Joao-Darwin/planets-starwars-api Planets-StartWars-Api
```

### Entrar na pasta do projeto
```bash
cd Planets-StartWars-Api
```
### Instalar o Maven
```bash
sudo apt-get install maven
```
### Instalar depedências do projeto
```bash
sudo mvn clean install
```
### Executar o projeto
```bash
mvn spring-boot:run
```

<div>
  <h2 id="author">Autor</h2>
  <h3>João Darwin</h3>
  <a href="https://www.linkedin.com/in/joao-darwin/" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" style="border-radius: 30px"></a>
  <a href="https://github.com/Joao-Darwin" target="_blank"><img src="https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white" style="border-radius: 30px"></a>
</div>
