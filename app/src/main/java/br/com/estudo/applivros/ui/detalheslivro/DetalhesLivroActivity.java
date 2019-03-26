package br.com.estudo.applivros.ui.detalheslivro;
import br.com.estudo.applivros.R;
import br.com.estudo.applivros.model.Livro;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalhesLivroActivity extends AppCompatActivity {

    public final static String EXTRA_LIVRO = "extra_livro";

    Livro livro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_livro);

        livro = getIntent().getParcelableExtra(EXTRA_LIVRO);

         configuraLayout();

    }

    private void configuraLayout(){

        TextView autor;
        TextView nome;
        TextView resumo;
        TextView genero;
        TextView reviews;
        TextView avaliacao;
        TextView isbn;
        ImageView imagemCapa;

        autor = findViewById(R.id.text_autor);
        nome = findViewById(R.id.text_nome);
        resumo = findViewById(R.id.text_conteudo_resumo);
        genero = findViewById(R.id.text_genero);
        imagemCapa = findViewById(R.id.imagem_capa);
        reviews = findViewById(R.id.text_reviews);
        avaliacao = findViewById(R.id.text_contador_avaliacao);
        isbn = findViewById(R.id.text_isbn);


        autor.setText(livro.getAutor());
        nome.setText(livro.getNome());
        resumo.setText(livro.getResumo());
        genero.setText(livro.getGenero());
        imagemCapa.setImageResource(livro.getUrlImagem());
        reviews.setText(getString(R.string.text_reviews, livro.getReviews()));
        avaliacao.setText(getString(R.string.text_contador_avaliacao, livro.getAvaliacao()));
        isbn.setText(livro.getIsbn());

    }
}