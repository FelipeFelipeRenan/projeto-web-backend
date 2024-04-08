# Projeto ___Backend___

Esse projeto tem como intuito pôr em prática o que foi ensinado na disciplina de Desenvolvimento Web, desta vez, focado para o _backend_.

Foi desenvolvida uma _API_(_Application Programming interface_) _RESTful_ que faz conexão com um _frontend_, localizado no repositório <https://github.com/FelipeFelipeRenan/projeto-web-frontend>,
servindo dados e também consumindo dados enviado pela aplicação.

## Estrutura

Foi escolhido como ferramente principal, o _framework_ _Quarkus_, um _framework_ para desenvolvimento _web_ construído  com a  linguagem de programação _Java_, linguagem essa bastante difundida
em ambientes de desenvolvimento onde de necessita de aplicações robustas e com regras de negócio complexas.

A aplicação possui 4 partes principais, que são relacionada com seus respectivos modelos, sendo uma para lidar com participantes, uma para lidar com _squads_, uma para lidar com _sprints_ e uma para lidar com tarefas, 
sendo, a princípio, pensando para atender uma arquitetura de microsserviço, com cada parte dessa aplicação sendo facilmente escalável, porém, devido à débito técnico e falta de um conhecimento maior de alguns integrantes da equipe acerta
de tal arquitetura, foi decidido, por hora, manter uma arquitetura mais simples de monólito.

Como banco de dados, foi escolhido o _Postgres_, pois. devido ao relacionamento que as entidades possuem, seria mais intuitivo utilizar um banco do tipo _SQL_ para o armazenamento, e o _Postgres_ também é bastante utilizado pela induútria.

Foi feita uma arquitetura _MVC_(_Model View Controller_), sendo a View, a própria aplicação _frontend_ que se comunica com a _API_, foi feito o começo de uma arquitetura limpa, criando-se _DTOs_(_Data Transfer Object_) para comunicação entre as camadas do _software_, porém, devido à simplicidade das regras de negócio, a arquitetura foi simplificada.


## Deploy da aplicação

Para rodar a aplicação, será necessário obter:
   * _Java_ versão 17+
   * _Maven_ 3.9,5
   * _Docker_

Estando com o _Docker_ instalado(_Linux_) ou Docker Desktop executando(_Windows_), basta, na raiz do projeto, executar o comando:
```bash
  mvn quarkus:dev
```

Após executado e sem erros no _log_, tecle d no terminal para abrir automaticamente a interface web do _Quarkus_, logo após, clique na opção lateral "_Endpoints_" e clique no _endpoint_ "/q/swagger-ui"
ou pode ser feito o acesso de forma direta pela _URL_: <http://localhost:8080/q/swagger-ui>.

Acessando esse endereço, será encontrado a interface web de documentação de de _APIs_, mais conhecida como _Swagger_, nela, estará disponível, de forma simplificada, todos os _endpoints_ da aplicação, seus métodos e suas formas de acesso, assim como seus retornos e códigos de informação

