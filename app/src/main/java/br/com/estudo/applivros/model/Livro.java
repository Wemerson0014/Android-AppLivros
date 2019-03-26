package br.com.estudo.applivros.model;
import android.os.Parcel;
import android.os.Parcelable;

public class Livro implements Parcelable {

    private final String nome;
    private final String autor;
    private final String ano;
    private final String resumo;
    private final String isbn;
    private final String genero;
    private final int avaliacao;
    private final int urlImagem;
    private final int reviews;

    public Livro(String nome, String autor, String ano, String resumo, String isbn, int avaliacao, int urlImagem, String genero, int reviews) {
        this.nome = nome;
        this.autor = autor;
        this.ano = ano;
        this.resumo = resumo;
        this.isbn = isbn;
        this.avaliacao = avaliacao;
        this.urlImagem = urlImagem;
        this.genero = genero;
        this.reviews = reviews;
    }

    private Livro(Parcel in) {
        nome = in.readString();
        autor = in.readString();
        ano = in.readString();
        resumo = in.readString();
        isbn = in.readString();
        avaliacao = in.readInt();
        urlImagem = in.readInt();
        genero = in.readString();
        reviews = in.readInt();
    }

    public static final Creator<Livro> CREATOR = new Creator<Livro>() {
        @Override
        public Livro createFromParcel(Parcel in) {
            return new Livro(in);
        }

        @Override
        public Livro[] newArray(int size) {
            return new Livro[size];
        }
    };

    public String getNome() {
        return nome;
    }

    public String getAutor() {
        return autor;
    }

    public String getResumo() {
        return resumo;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public int getUrlImagem() {
        return urlImagem;
    }

    public String getAno() {
        return ano;
    }

    public String getGenero() { return  genero;}

    public int getReviews() { return  reviews;}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(autor);
        dest.writeString(ano);
        dest.writeString(resumo);
        dest.writeString(isbn);
        dest.writeInt(avaliacao);
        dest.writeInt(urlImagem);
        dest.writeString(genero);
        dest.writeInt(reviews);

    }
}