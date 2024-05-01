# backend-challenge


## Para contruir a imagem
```bash
docker build -t backend-challenge .
```

## Para executar o container
```bash
docker run -d -p 8080:8080 backend-challenge
```
## Para listar os imagens
```bash
docker images backend-challenge
```

## Para listar os containers
```bash
docker ps
```

## Para para o container
```bash
docker stop 9275ecfde46c #<image_id>
```
```bash
docker rm 9275ecfde46c #<image_id>
```

## Para contruir a infra kubernets
```bash
kubectl apply -f deploy/deployment.yml
```
```bash
kubectl apply -f deploy/service.yml
```

## Para apagar a infra kubernets
```bash
kubectl delete svc backend-challenge-service
```
```bash
kubectl delete deployment backend-challenge-deployment
```

## Para consultar pods, services e deployments
```bash
kubectl get deployments 
kubectl get pods
kubectl get svc
```

## Curl

```bash
curl --location 'http://localhost:80/decodeToken' --header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiTWVtYmVyIiwiT3JnIjoiQlIiLCJTZWVkIjoiMTQ2MjciLCJOYW1lIjoiVmFsZGlyIEFyYW5oYSJ9.cmrXV_Flm5mfdpfNUVopY_I2zeJUy4EZ4i3Fea98zvY' --header 'Cookie: JSESSIONID=801E01A05EDC87D93DBD455D61F3922F'
```

