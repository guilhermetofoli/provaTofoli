# Sistema de Controle de Estoque - Prova MAPA

## Descrição do Projeto
Este projeto consiste em uma aplicação Android realizada para a prova  O objetivo principal é o gerenciamento de produtos, permitindo o cadastro de itens com validações específicas e a persistência dos dados em um banco de dados local.

## Funcionalidades
- **Cadastro de Produtos:** Registro de nome, código alfanumérico, preço e quantidade em estoque.
- **Validações de Entrada:**
    - Impedimento de campos vazios.
    - Restrição de preço para apenas valores positivos com até duas casas decimais.
    - Restrição de quantidade para números inteiros positivos.
- **Persistência de Dados:** Utilização da biblioteca Room para armazenamento persistente no SQLite.
- **Listagem de Itens:** Tela dedicada para visualização de todos os produtos cadastrados no banco de dados.

## Tecnologias Utilizadas
- **Linguagem:** Java
- **SDK Android:** API 27 (Android 8.1 Oreo)
- **Banco de Dados:** Room Persistence Library
- **Device Utilizado:** Pixel 2
- **IDE:** Android Studio

## Estrutura do Projeto
- `MainActivity.java`: Responsável pela interface de entrada e lógica de validação/inserção.
- `ListActivity.java`: Responsável pela recuperação e exibição dos dados persistidos.
- `Product.java`: Entidade que define a tabela de produtos no banco de dados.
- `ProductDao.java`: Interface que define os métodos de acesso aos dados (Insert/Query).
- `AppDatabase.java`: Classe de configuração do banco de dados (Singleton).

## Como Executar
1. Realize o clone do repositório.
2. Abra o projeto no Android Studio.
3. Certifique-se de que o SDK da API 27 ou superior esteja instalado.
4. Execute a aplicação em um emulador (conforme previamente especificado) ou dispositivo físico.