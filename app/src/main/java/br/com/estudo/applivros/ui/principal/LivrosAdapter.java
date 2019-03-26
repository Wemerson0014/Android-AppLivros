package br.com.estudo.applivros.ui.principal;
import br.com.estudo.applivros.R;
import br.com.estudo.applivros.model.Livro;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class LivrosAdapter extends RecyclerView.Adapter<LivrosAdapter.MeuViewHolder> {

    private List<Livro> livros;
    private OnClickListener listener;

    LivrosAdapter(List<Livro> livros, OnClickListener onClickListener) {
        this.livros = livros;
        this.listener = onClickListener;
    }

    @NonNull
    @Override
    public MeuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View itemLivro = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_livros, parent, false);
        return new MeuViewHolder(itemLivro);
    }

    @Override
    public void onBindViewHolder(@NonNull MeuViewHolder meuViewHolder, int position) {

        Livro livro = this.livros.get(position);
        meuViewHolder.configuraView(livro, listener);

     }

    @Override
    public int getItemCount() {
        return livros.size();
    }

     class MeuViewHolder extends RecyclerView.ViewHolder {

        TextView nome;
        TextView autor;
        TextView ano;
        ImageView url_imagem;

        private MeuViewHolder(@NonNull View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.text_nome);
            autor = itemView.findViewById(R.id.text_autor);
            ano = itemView.findViewById(R.id.text_ano);
            url_imagem = itemView.findViewById(R.id.imagem_capa);
        }

        private void configuraView(final Livro livro, final OnClickListener onClickListener){
            nome.setText(livro.getNome());
            autor.setText(itemView.getContext().getString(R.string.text_autor, livro.getAutor()));
            ano.setText(livro.getAno());
            url_imagem.setImageResource(livro.getUrlImagem());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.itemClicado(livro);
                }
            });
        }
     }
}