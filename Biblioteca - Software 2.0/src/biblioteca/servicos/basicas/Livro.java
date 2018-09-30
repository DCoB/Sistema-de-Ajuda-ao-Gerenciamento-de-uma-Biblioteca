package biblioteca.servicos.basicas;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe que Contém Todos os Atributos Básicos de Todos os Livros
 * @version 2.0
 * @param idLivro = 'id' do Livro
 * @param titulo = Título do Livro
 * @param autor = Autor do Livro
 * @param genero = Genero do Livro
 * @param sinopse = Um Breve Resumo Sobre o Que se Trata Livro
 * @param ano = Ano de Lançamento do Livro 
 * @param mediaAvaliacao = Média das Notas de Todos os Alunos Sobre esse Livro
 * @param disponivel = Livro está disponível ou Locado
 * @param diasRestantes = Dias que Faltam para o Tempo de Locação do Livro Acabar
 */
public class Livro implements Serializable{
	private static final long serialVersionUID = 1L;
	private long idLivro;
	private String titulo;
	private String autor;
	private String genero;
	private String sinopse;
	private int ano;
	private double mediaAvaliacao;
	private boolean disponivel;
	private int diasRestantes;
	private boolean excluido;
	private ArrayList<String> criticas;
	
	/**
	 * Construtor com Todos os Atributos da Classe Básica 'Livro' Definidos
	 * @param titulo = Título do Livro
	 * @param autor = Autor do Livro
	 * @param genero = Genero do Livro
	 * @param numero
	 */
	public Livro(String titulo, String autor, String genero,String sinopse,int ano) {
		this.idLivro = 0;
		this.titulo=titulo;
		this.autor=autor;
		this.genero=genero;
		this.sinopse = sinopse;
		this.ano = ano;
		this.disponivel=true;
		this.diasRestantes = 0;
		this.excluido = false;
	}
	
	/**
	 * Construtor Usado Somente para a Criação de Objetos para a Chamada de Métodos
	 */
	public Livro()
	{
		this.idLivro = 0;
		this.diasRestantes = 0;
	}
	
	//Getters e Setters
	public long getIdLivro() {
		return idLivro;
	}
	public void setIdLivro(long idLivro) {
		this.idLivro = idLivro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public double getMediaAvaliacao() {
		return mediaAvaliacao;
	}
	public void setMediaAvaliacao(double mediaAvaliacao) {
		this.mediaAvaliacao = mediaAvaliacao;
	}
	public boolean isDisponivel() {
		return disponivel;
	}
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	public int getDiasRestantes() {
		return diasRestantes;
	}
	public void setDiasRestantes(int diasRestantes) {
		this.diasRestantes = diasRestantes;
	}
	public boolean getExcluido()
	{
		return this.excluido;
	}
	public void setExcluido(boolean excluido)
	{
		this.excluido = excluido;
	}

	public ArrayList<String> getCriticas() {
		return criticas;
	}

	public void setCriticas(ArrayList<String> criticas) {
		this.criticas = criticas;
	}
	
	
}
