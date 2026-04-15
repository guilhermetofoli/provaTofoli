package com.example.provatofoli;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

// Classe para a tela que lista os produtos cadastrados
public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list); // Define o layout da lista

        // Ligando os componentes do XML ao Java
        TextView tvProductList = findViewById(R.id.tvProductList);
        Button btnBack = findViewById(R.id.btnBack);

        // Mensagem no Log para saber que a tela abriu
        Log.d("ListActivity", "Tela de listagem aberta!");

        // Inicializa o banco de dados (Padrão Singleton do professor)
        AppDatabase db = AppDatabase.getInstance(this);

        // Busca todos os produtos salvos no banco
        List<Product> products = db.productDao().getAllProducts();

        // Verifica se existem produtos para mostrar
        if (products != null && !products.isEmpty()) {
            StringBuilder sb = new StringBuilder();

            // Percorre a lista de produtos e monta o texto
            for (Product p : products) {
                sb.append("Produto: ").append(p.getName()).append("\n")
                        .append("Código: ").append(p.getCode()).append("\n")
                        .append("Preço: R$ ").append(String.format("%.2f", p.getPrice())).append("\n")
                        .append("Quantidade: ").append(p.getQuantity()).append("\n")
                        .append("-----------------------------\n\n");
            }

            // Exibe o texto montado na tela
            tvProductList.setText(sb.toString());
            Log.d("ListActivity", "Produtos carregados com sucesso.");
        } else {
            tvProductList.setText("Nenhum produto cadastrado no momento.");
            Log.d("ListActivity", "O banco de dados está vazio.");
        }

        // Botão para voltar para a tela anterior
        btnBack.setOnClickListener(v -> {
            Log.d("ListActivity", "Voltando para a tela de cadastro.");
            finish();
        });
    }
}