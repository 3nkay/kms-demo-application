# kms-demo-application
kms-demo-application


curl -d '{"uuid":"2d28c56b-a343-4bc0-9812-2d89aed47660", "name":"Effective Java"}' -H "Content-Type: application/json" -X POST http://localhost:8080/products
curl -d '{"uuid":"e8f0033c-59ee-4d3a-85e1-3e2db405fc0c", "name":"Designing Data Intensive Applications"}' -H "Content-Type: application/json" -X POST http://localhost:8080/products


curl -X DELETE http://localhost:8080/e8f0033c-59ee-4d3a-85e1-3e2db405fc0c