# TrabalhoFinalJava
-----------------------------------------------Requisitos-----------------------------------------------

Requisito: Ter Docker instalado na máquina.

Requisito: Ter a IDE Eclipse instalada na máquina.

------------------------------------------------Execução------------------------------------------------

Execute os seguintes comandos em seu terminal:
docker run -d --hostname rabbitmq --name rabbitmq-management -p 15672:15672 -p 5671:5671 -p 5672:5672 rabbitmq:management
docker run -p 27017:27017 --name mongodb -d mongo

Caso tudo dê certo, ao acessar http://localhost:15672/ deverá ser exibido uma tela solicitando as credenciais do RabbitMQ, sendo elas guest e guest.

Clone o repositório e abra a pasta do projeto na IDE Eclipse.
No packaje com.javaee.willwv.TrabalhoFinalJava, clicke com o botão direito sobre a classe TrabalhoFinalJavaApplication e selecione a opção
Run As > Java Application.

Caso tudo dê certo, ao acessar http://localhost:8080/swagger-ui.html#/ deverá ser exibido todos os controllers do projeto.

-----------------------------------------------Considerações-----------------------------------------------

1) Este projeto faz a venda de uma Ação que pertence a uma Epresa para um Cliente;
1.1)Empresa, Cliente e Ação devem ser cadastrados antes da venda, caso contrário um erro será lançado.


2) A venda de uma ação é feita de maneira assíncrona, utilizando o RabbitMQ para isso;
2.1) Um e-mail é enviado após a ação ser salva no MongoDB;
2.2) Cadastro e Listagem de Empresa, Ação e Cliente são feitos de maneira síncrona.
