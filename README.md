# backend-challenge


### Instruções básicas de como executar o projeto

##### Três modos:
A primeira coisa é executar: 

```bash
mvn clean install
```

Agora escolhe um dos itens abaixo:
- 
- Executar o arquivo BackendChallengeApplication.java
ou
- Pular para a sessão Docker e executar os itens 1, 2 e 3 (necessita ter o docker na máquina)
ou 
- Pular para a sessão Kubernets e executar os itens 1 e 2 (necessita ter o kebernets na máquina)

Para observalidade, siga os menus

### Kubernetes
#### 1) Para contruir a infra kubernets
```bash
kubectl apply -f deploy/deployment.yml
```
```bash
kubectl apply -f deploy/service.yml
```
```bash
kubectl apply -f deploy/observability.yml
```

#### 2) Para consultar pods, services e deployments
```bash
kubectl get svc
kubectl get deployments 
kubectl get pods
```

### Curl

```bash
curl --location 'http://localhost:80/v1/jwt/validate' --header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiTWVtYmVyIiwiT3JnIjoiQlIiLCJTZWVkIjoiMTQ2MjciLCJOYW1lIjoiVmFsZGlyIEFyYW5oYSJ9.cmrXV_Flm5mfdpfNUVopY_I2zeJUy4EZ4i3Fea98zvY' --header 'Cookie: JSESSIONID=801E01A05EDC87D93DBD455D61F3922F'
```


### Docker
#### 1) Para contruir a imagem
```bash
docker build -t backend-challenge .
```

#### 2) Para executar o container
```bash
docker run -d -p 8080:8080 backend-challenge
```

#### 3) Para listar os imagens
```bash
docker images backend-challenge
```

#### 4) Para listar os containers
```bash
docker ps
```

#### 5) Para parar o container
```bash
docker stop 9275ecfde46c #<image_id>
```
```bash
docker rm 9275ecfde46c #<image_id>
```


### Para apagar a infra kubernets
```bash
kubectl delete svc backend-challenge-service
kubectl delete deployment backend-challenge-deployment
```

```bash
kubectl delete svc prometheus-service
kubectl delete deployment prometheus-deployment
kubectl delete cm prometheus-config
```

### Detalhes da descrição dos metodos
#### Endpoints

#### GET /v1/jwt/validate
Retorna verdadeiro ou false, conforme requisito.

Somente existe o endpoint acima responsável por fazer a validação dos itens do payload (Claims).
Não utilizei a biblioteca JWT porque os token fornecidos estavam assinados e eu não foi fornecido a secret para poder fazer o parse,
então foi utilizado o decode base 64 para extrair o payload e validar conforme requisitado.

#### Caso algo não esteja claro e você precisou assumir alguma premissa, quais foram e o que te motivou a tomar essas decisões.
A principio pensei que fosse para fazer toda a parte de autenticação/autorização com jwt, porém relendo os requisitos entendi
que somente a validação do token, utilizando os cenários e dados fornecidos, fossem necessários.

### Tecnologias Utilizadas
- Java 17
- Spring Boot 3.2.5
- Maven


#### Para acessar o prometheus (Observabilidade)
```bash
kubectl port-forward svc/prometheus-service 9090:9090
```

[prometheus] http://localhost:9090