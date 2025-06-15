# Gerenciador de Tarefas (CLI)

Um pequeno sistema em Java para gerenciar tarefas via linha de comando. Os dados são salvos em arquivo `.txt`, e o projeto utiliza princípios de POO, manipulação de arquivos e testes unitários.

## Funcionalidades

- Adição e listagem de tarefas
- Marcação de tarefas como concluídas
- Armazenamento em arquivo local
- Testes unitários com JUnit

## Como executar

```bash
javac src/**/*.java
java src/Main
```

## Como rodar os testes

```bash
javac -cp .:junit-5.7.0.jar test/*.java
java -cp .:junit-5.7.0.jar org.junit.runner.JUnitCore TaskServiceTest
```