package com.example.provatofoli;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

// O Data Access Object é o componente que serve para persistência de dados.
// Serve para definir as operações que podem ser feitas no banco de dados com relação à entidade Product
@Dao
public interface ProductDao {

    // Método para inserir um produto na tabela do BD
    // A anotação @Insert informa à Room que este método deve ser usado para inserir dado
    @Insert
    void insert(Product product);

    // Método para buscar todos os produtos cadastrados no BD
    // A anotação @Query permite definir uma consulta SQL personalizada
    @Query("SELECT * FROM products")
    List<Product> getAllProducts();
}