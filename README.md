# projeto-web
Projeto para a disciplina de Desenvolvimento Web

Stack ainda será definida (Provavelmente será Java/Quarkus para o backend e React para o frontend)

Será analizada a possibilidade da implementação da arquitetura de microservice para o projeto
com os serviços feitos com o framework Quarkus e algumas partes, como o API Gateway feito em Spring

## Frontend
React como framework para construção de SPA, Styled Components para estilização (ou SASS)
### Seguir os passos para rodar a aplicação
    cd frontend/
    npm install
    npm run dev
## Backend 
Quarkus para construir o backend e possivelmente GraphQL para construção da API, caso não for possivel, será uma API REST
com uma arquitetura baseada em microservices e caso náo seja possivel, será feito um monolito.
Por ser um framework baseado em cloud, será possivel usar o Docker e Kubernetes para o deploy da aplicação e graças à 
feature de geração de aplicação nativa do Quarkus, teremos uma aplicação menor e mais leve que teriamos em um cenario 
onde seria utilizado o Spring.
### Seguir os passos para rodar a aplicação
    cd backend/
    mvn package clean
    mvn quarkus:dev
