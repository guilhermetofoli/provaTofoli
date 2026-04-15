package com.example.provatofoli;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // Declaração dos campos de entrada de dados
    private EditText etProductName, etProductCode, etProductPrice, etProductQuantity;

    // Objeto para interagir com o banco de dados (DAO)
    private ProductDao productDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Define o layout da tela

        // Inicializa os campos de entrada de dados do layout
        etProductName = findViewById(R.id.etProductName);
        etProductCode = findViewById(R.id.etProductCode);
        etProductPrice = findViewById(R.id.etProductPrice);
        etProductQuantity = findViewById(R.id.etProductQuantity);

        // Inicializa os botões do layout
        Button btnSave = findViewById(R.id.btnSave);
        Button btnGoToList = findViewById(R.id.btnGoToList);

        // Configuração do banco de dados usando o Singleton AppDatabase (conforme o modelo do prof)
        AppDatabase db = AppDatabase.getInstance(this);
        productDao = db.productDao();

        // Configura o botão de salvar produto
        btnSave.setOnClickListener(v -> {
            Log.d("MainActivity", "Botão Cadastrar Produto clicado!");

            // Obtém os valores digitados
            String name = etProductName.getText().toString().trim();
            String code = etProductCode.getText().toString().trim();
            String priceStr = etProductPrice.getText().toString().trim();
            String qtyStr = etProductQuantity.getText().toString().trim();

            // Log para conferência dos valores
            Log.d("MainActivity", "Dados: " + name + ", " + code + ", " + priceStr + ", " + qtyStr);

            // Validação: Nenhum campo pode ser deixado em branco
            if (!name.isEmpty() && !code.isEmpty() && !priceStr.isEmpty() && !qtyStr.isEmpty()) {
                try {
                    double price = Double.parseDouble(priceStr);
                    int quantity = Integer.parseInt(qtyStr);

                    // Validação: Preço e Quantidade devem ser positivos
                    if (price > 0 && quantity > 0) {
                        // Cria o objeto e insere no banco
                        Product product = new Product(name, code, price, quantity);
                        productDao.insert(product);

                        Log.d("MainActivity", "Produto inserido com sucesso!");
                        Toast.makeText(this, "Produto cadastrado!", Toast.LENGTH_SHORT).show();

                        // Limpa os campos após salvar
                        limparCampos();
                    } else {
                        Toast.makeText(this, "Preço e Quantidade devem ser positivos!", Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    Log.e("MainActivity", "Erro na conversão de números", e);
                    Toast.makeText(this, "Insira valores numéricos válidos!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Log.d("MainActivity", "Erro: Campos vazios!");
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            }
        });

        // Configura o botão para navegar para a lista
        btnGoToList.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, ListActivity.class))
        );
    }

    private void limparCampos() {
        etProductName.setText("");
        etProductCode.setText("");
        etProductPrice.setText("");
        etProductQuantity.setText("");
    }
}