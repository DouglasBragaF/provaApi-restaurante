Bem-vindo à API de Comida Oriental! 🍣
A API permite gerenciar informações de pedidos de comida oriental através do controller com a rota /pedidos.

Estrutura da Classe Pedido 📝
A classe model Pedido possui os seguintes atributos:

(Os atributos serão listados aqui)

Endpoints Disponíveis 🌐
1. Listar Todos os Pedidos
Método HTTP: GET
Endpoint: /pedidos
Descrição: Lista todos os pedidos.
2. Buscar Pedido por ID
Método HTTP: GET
Endpoint: /pedidos/{id}
Descrição: Busca um pedido pelo ID.
Parâmetros: id (path) - ID do pedido.
3. Criar Novo Pedido
Método HTTP: POST
Endpoint: /pedidos
Descrição: Cria um novo pedido.
Corpo da Requisição:
JSON

{
  "nomeCliente": "João Silva",
  "contatoCliente": "joao.silva@example.com",
  "nomePrato": "Sushi de Salmão",
  "valorPrato": 45.90,
  "dataPedido": "2024-06-01T12:30:00"
}
Código gerado por IA. Examine e use com cuidado. Mais informações em perguntas frequentes.
4. Atualizar Pedido por ID
Método HTTP: PUT
Endpoint: /pedidos/{id}
Descrição: Atualiza um pedido existente pelo ID.
Parâmetros: id (path) - ID do pedido.
Corpo da Requisição:
JSON

{
  "nomeCliente": "João Silva",
  "contatoCliente": "joao.silva@example.com",
  "nomePrato": "Sushi de Salmão",
  "valorPrato": 50.00,
  "dataPedido": "2024-06-01T12:30:00"
}
Código gerado por IA. Examine e use com cuidado. Mais informações em perguntas frequentes.
5. Excluir Pedido por ID
Método HTTP: DELETE
Endpoint: /pedidos/{id}
Descrição: Exclui um pedido pelo ID.
Parâmetros: id (path) - ID do pedido.
Exemplo de Uso:
curl -X DELETE http://localhost:8080/pedidos/1

Buscas Específicas 🔍
Buscar Pedidos por Nome do Cliente
Método HTTP: GET
Endpoint: /pedidos/cliente
Descrição: Busca pedidos pelo nome do cliente.
Parâmetros: nomeCliente (query) - Nome do cliente.
Buscar Pedidos por Nome do Prato
Método HTTP: GET
Endpoint: /pedidos/prato
Descrição: Busca pedidos pelo nome do prato.
Parâmetros: nomePrato (query) - Nome do prato.
Buscar Pedidos por Intervalo de Datas
Método HTTP: GET
Endpoint: /pedidos/data
Descrição: Busca pedidos por intervalo de datas.
Parâmetros:
startDate (query) - Data de início no formato ISO 8601.
endDate (query) - Data de fim no formato ISO 8601.
