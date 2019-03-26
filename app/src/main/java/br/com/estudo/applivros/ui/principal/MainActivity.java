package br.com.estudo.applivros.ui.principal;
import br.com.estudo.applivros.R;
import br.com.estudo.applivros.model.Livro;
import br.com.estudo.applivros.ui.detalheslivro.DetalhesLivroActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.Arrays;
import java.util.List;

import static br.com.estudo.applivros.ui.detalheslivro.DetalhesLivroActivity.EXTRA_LIVRO;


public class MainActivity extends AppCompatActivity {

    private List<Livro> livros = Arrays.asList(
            new Livro("O Código da Vinci", "Dan Brown", "2003", "A trama se inicia com um assassinato no Museu do Louvre, em Paris. A vítima, um importante membro de uma sociedade clandestina que existe desde os tempos de Cristo, deixa algumas pistas na cena do crime que apenas sua neta, uma talentosa criptóloga francesa, e um simbologista de Harvard serão capazes de decifrar. Os dois transformam-se em suspeitos e detetives ao tentar descobrir não apenas a identidade do assassino, mas também o segredo milenar que a vítima tentava proteger", "ISBN: 9788575421130", 5, R.drawable.ic_codigo_vinci, "Romance policial", 1420),
            new Livro("Anjos e Demônios", "Dan Brown", "2000", "Antes de decifrar O Código Da Vinci, Robert Langdon, o famoso professor de simbologia de Harvard, vive sua primeira aventura em Anjos e Demônios, quando tenta impedir que uma antiga sociedade secreta destrua a Cidade do Vaticano. Às vésperas do conclave que vai eleger o novo Papa, Langdon é chamado às pressas para analisar um misterioso símbolo marcado a fogo no peito de um físico assassinado em um grande centro de pesquisas na Suíça.", "ISBN: 9788575421468", 5, R.drawable.ic_anjos_demonios, "Romance policial", 2547),
            new Livro("Percy Jackson e o ladrão de raios", "Rick Riordan", "2005", "Um artefato precioso foi roubado do Monte Olimpo e Percy é o principal suspeito. Para restaurar a paz, ele e seus amigos – jovens heróis modernos – terão de fazer mais do que capturar o verdadeiro ladrão: precisam elucidar uma traição mais ameaçadora que fúria dos deuses", "ISBN: 9788598078878 ", 5, R.drawable.ic_percy_ladrao_raios, "Literatura juvenil e aventura", 1234),
            new Livro("O Guia do Mochileiro das Galáxias", "Douglas Adams", "1979", "Conta as aventuras espaciais do inglês Arthur Dent e do seu amigo Ford Prefect.", "ISBN: 9788599296578", 3, R.drawable.ic_guia_mochileiro_galaxias, "Humor, ficção cômica, ficção humorística", 1005),
            new Livro("Meio Rei", "Joe Abercrombie", "2014", "Filho caçula do rei Uthrik, Yarvi nasceu com a mão deformada e sempre foi considerado fraco pela sua família, e agora precisa empunhar sua espada para vingar-se.", "ISBN: 9788580415612", 4, R.drawable.ic_meio_rei, "Literatura fantástica", 2015),
            new Livro("Magisterium o desafio de ferro", "Black e Clare", "2014", "A maioria dos garotos faria qualquer coisa para passar no Desafio de Ferro. Callum Hunt não é um deles. Ele quer falhar. Assim, ele se esforça ao máximo para fazer o seu pior... mas falha em seu plano de falhar. Agora, o Magisterium espera por ele, um lugar ao mesmo tempo incrível e sinistro, com laços sombrios que unem o passado de Call e um caminho tortuoso até o seu futuro.", "ISBN: 9788581635576", 3, R.drawable.ic_magisterium_desafio_ferro, "Literatura fantástica", 2031)

    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configuraRecyclerView();

    }

    private void configuraRecyclerView(){
        final RecyclerView recyclerView = findViewById(R.id.recycler_livros);

        LivrosAdapter livrosAdapter = new LivrosAdapter(livros, new OnClickListener() {
            @Override
            public void itemClicado(Livro livro) {
                Intent intent = new Intent(getApplicationContext(), DetalhesLivroActivity.class);
                intent.putExtra(EXTRA_LIVRO, livro);
                startActivity(intent);
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(livrosAdapter);

    }

}