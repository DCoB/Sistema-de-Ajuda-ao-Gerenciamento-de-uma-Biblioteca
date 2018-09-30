package biblioteca.repositorios;

import java.io.IOException;
import java.time.LocalDateTime;

import biblioteca.dados.*;
import biblioteca.repositorios.interfaces.IRepositorioAuxiliar;

/**
 * Classe Responsável por Fazer as Alterações no ArquivoAuxiliar.ser no Banco de Logs
 * @version 2.0
 *
 */
public class RepositorioAuxiliar extends Banco implements IRepositorioAuxiliar{
	private static final long serialVersionUID = 1L;
	private LocalDateTime HoraData;
	private long UltimoIdAluno;
	private long UltimoIdFuncionario;
	private long UltimoIdGerente;
	private long UltimoIdLivro;
	private long UltimoIdLog;
	private String loginSalvo;
	private String senhaSalvo;
	
	/**
	 * Construtor Usado Somente para a Criação de Objetos para a Chamada de Métodos
	 */
	public RepositorioAuxiliar() {
		super(0);
		setBanco("Banco_Logs\\");
		setArquivo("ArquivoAuxiliar");
		loginSalvo = "SisAlun";
		senhaSalvo = "root123";
		
	}
	
	//Getters e Setters
	public LocalDateTime getHoraData() {
		return HoraData;
	}
	public void setHoraData(LocalDateTime horaData) {
		HoraData = horaData;
	}
	public long getUltimoIdAluno() throws IOException {		
		return this.UltimoIdAluno;
	}
	public long getUltimoIdAlunoAdd() throws IOException {
		this.UltimoIdAluno += 1;
		criarArquivo(this, 0);
		
		return UltimoIdAluno;
	}
	public void setUltimoIdAluno(long ultimoIdAluno) {
		UltimoIdAluno = ultimoIdAluno;
	}
	public long getUltimoIdFuncionarioAdd() throws IOException {
		this.UltimoIdFuncionario += 1;
		criarArquivo(this,0);
		
		return UltimoIdFuncionario;
	}
	public long getUltimoIdFuncionario() throws IOException {
		return UltimoIdFuncionario;
	}
	public void setUltimoIdFuncionario(long ultimoIdFuncionario) {
		UltimoIdFuncionario = ultimoIdFuncionario;
	}
	public long getUltimoIdGerenteAdd() throws IOException {
		this.UltimoIdGerente +=1;
		criarArquivo(this,0);
		
		return UltimoIdGerente;
	}
	public long getUltimoIdGerente() throws IOException {
		return UltimoIdGerente;
	}
	public void setUltimoIdGerente(long ultimoIdGerente) {
		UltimoIdGerente = ultimoIdGerente;
	}
	public long getUltimoIdLivro() throws IOException {
		return UltimoIdLivro;
	}
	public long getUltimoIdLivroAdd() throws IOException {
		this.UltimoIdLivro += 1;
		criarArquivo(this,0);
		
		return UltimoIdLivro;
	}
	public void setUltimoIdLivro(long ultimoIdLivro) {
		UltimoIdLivro = ultimoIdLivro;
	}
	public long getUltimoIdLog() throws IOException {
		return UltimoIdLog;
	}
	public long getUltimoIdLogAdd() throws IOException {
		this.UltimoIdLog += 1;
		criarArquivo(this,0);
		
		return UltimoIdLog;
	}
	public void setUltimoIdLog(long ultimoIdLog) {
		UltimoIdLog = ultimoIdLog;
	}
	public String getLoginSalvo() {
		return loginSalvo;
	}
	public void setLoginSalvo(String loginSalvo) {
		this.loginSalvo = loginSalvo;
	}
	public String getSenhaSalvo() {
		return senhaSalvo;
	}
	public void setSenhaSalvo(String senhaSalvo) {
		this.senhaSalvo = senhaSalvo;
	}
	

	public void iniciarArquivoAuxiliar() throws IOException
	{	
		this.setIdArquivo(0);
		this.UltimoIdAluno = 0;
		this.UltimoIdFuncionario = 0;
		this.UltimoIdGerente = 0;
		this.UltimoIdLivro = 0;
		this.UltimoIdLog = 0;
		this.HoraData = LocalDateTime.now();
			
		criarArquivo(this,getIdArquivo());
	}
	

	public RepositorioAuxiliar buscarArquivoAuxiliar() throws IOException
	{		
		return (RepositorioAuxiliar)buscarArquivoPorId(0);	
	}
	

	public void atualizarArquivoAuxiliar(RepositorioAuxiliar auxiliar) throws IOException
	{
		criarArquivo(auxiliar, 0);
	}
	

	public int diferencaDiasDatas() throws IOException
	{
		RepositorioAuxiliar Aux1 =  new RepositorioAuxiliar();
		int diferenca;
		
		Aux1 = buscarArquivoAuxiliar();
		LocalDateTime dataAtual = LocalDateTime.now();
		
		if(dataAtual.getYear() == Aux1.HoraData.getYear())
		{
			diferenca = dataAtual.getDayOfYear() - Aux1.HoraData.getDayOfYear();
		}
		else
		{
			diferenca = 365*(dataAtual.getYear() - Aux1.HoraData.getYear()) + (dataAtual.getDayOfYear() - Aux1.HoraData.getDayOfYear());
		}
		
		return diferenca;
	}
	
	

}
