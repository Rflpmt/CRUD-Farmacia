
CRUD-Farmacia
Este é um projeto de backend para uma farmácia, desenvolvido em Spring Boot, que permite a manipulação dos dados de produtos e categorias.
CRUD (Create, Read, Update, Delete) de produtos
CRUD de categorias
 Você pode configurar as propriedades do banco de dados no arquivo application.properties.
 Produtos:

POST /api/produtos: Cria um novo produto
GET /api/produtos: Retorna todos os produtos
GET /api/produtos/{id}: Retorna um produto pelo ID
PUT /api/produtos/{id}: Atualiza um produto existente pelo ID
DELETE /api/produtos/{id}: Deleta um produto pelo ID
DELETE /api/produtos: Deleta todos os produtos
Categorias:

POST /api/categorias: Cria uma nova categoria
GET /api/categorias: Retorna todas as categorias
GET /api/categorias/{id}: Retorna uma categoria pelo ID
PUT /api/categorias/{id}: Atualiza uma categoria existente pelo ID
DELETE /api/categorias/{id}: Deleta uma categoria pelo ID
DELETE /api/categorias: Deleta todas as categorias
Certifique-se de ter o JDK e o Maven instalados.
Clone este repositório.
Navegue até o diretório raiz do projeto.
Execute o comando mvn spring-boot:run para iniciar o servidor.
O servidor estará disponível em http://localhost:8080
