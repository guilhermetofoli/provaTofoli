package com.example.provatofoli;

// Importa as anotações do Room para definir a estrutura da tabela
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/*
 A anotação @Entity define que esta classe será uma tabela no banco de dados SQLite.
 O parâmetro tableName especifica o nome da tabela como "products".
*/
@Entity(tableName = "products")
public class Product {

    /*
     A anotação @PrimaryKey define o campo 'id' como a chave primária da tabela.
     autoGenerate = true indica que o Room irá incrementar o ID automaticamente a cada novo registro.
    */
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private String code;
    private double price;
    private int quantity;

    // Construtor vazio exigido pelo Room para instanciar objetos ao buscar dados no banco
    public Product() {
    }

    // Construtor utilizado para criar o objeto antes de realizar a inserção no banco de dados
    public Product(String name, String code, double price, int quantity) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.quantity = quantity;
    }

    // Métodos Getter e Setter para permitir que o Room acesse e modifique os campos privados
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}