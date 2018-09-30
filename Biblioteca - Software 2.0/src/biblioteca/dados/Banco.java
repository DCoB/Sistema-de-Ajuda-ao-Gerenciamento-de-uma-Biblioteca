package biblioteca.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import biblioteca.servicos.ServicoLog;

/** 
 * Classe que Realiza as Opera��es nos Bancos
 *  @version 3.0
 *  @param Banco = Banco em que as altera��es Ser�o Feitas
 *  @param Arquivo = Arquivo Gen�rico da Classe em que as Altera��es Ser�o Feitas
 *  @param IdArquivo = ID do Arquivo que as Altera��es Ser�o Feitas
 *  @param Excluido = Usu�rio est� ativo (false) ou inativo (true)
 *  @param Caminho = Caminho do Windowns Onde os Banco Est�o Salvos
 */
public class Banco implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String banco;
	private String arquivo;
	private long idArquivo;
	private boolean excluido = false;
	private String caminho;
	
	
	/** 
	 * M�todo Contrutor da Classe Banco
	 *  @param id = "Id" do Arquivo Adicionado
	 */		
	public Banco(long id)
	{
		this.banco = "arquivos";
		this.idArquivo = id;
		this.caminho = "../Biblioteca - Software 2.0/banco/";
	}
	
	//Getters e Setters
	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}
	
	public long getIdArquivo() {
		return this.idArquivo;
	}
	
	public void setIdArquivo(long idArquivo) {
		this.idArquivo = idArquivo;
	}
	
	public String getCaminho() {
		return this.caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	
	public String getArquivo() {
		return this.arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}	
	
	
	/**
	* M�todo que Cria a Pasta Onde Ir�o ficar os Bancos
	*/
	public void criarDiretorio()
	{
		File pasta = new File(this.caminho);//NOVO OBJETO DA CLASSE FILE
		
		if(pasta.exists() == false)//CHECA SE A PASTA J� EXISTE, SE ELA N�O EXISTIR ENTRA NO 'if'
		{
			pasta.mkdir();//CRIA A PASTA
		}
	}
		
	/** 
	 * M�todo Cria Uma Pasta Onde Ser� Armazenado os Arquivos
	 */
	public void criarBanco()
	{
		File pasta = new File(this.caminho + this.banco);//CRIAR UM OBJETO DA CLASSE FILE, COM O CAMINHO DO ARQUIVO DEFINIDO
		
		pasta.mkdir();//CRIA O BANCO(PASTA) ONDE SER�O ARMAZENADOS OS ARQUIVOS
	}
	
	/** 
	 * M�todo Limpa Um Banco(Pasta) Onde os Arquivos Est�o Armazenados
	 */
	public void limparBanco()
	{
		File pasta = new File(this.caminho + this.banco);//CRIAR UM OBJETO DA CLASSE FILE, COM O CAMINHO DO ARQUIVO DEFINIDO
		if(excluirBanco(pasta)!=true)//CHECA SE A EXCLUS�O DO BANCO FOI BEM SUCEDIDA OU N�O ATRAV�S DO M�TODO 'excluirBanco'
 		{}
		criarBanco();//CHAMA O M�TODO PARA CRIAR UM NOVO BANCO
	}
	
	/**
	 * M�todo Exclu� um Banco(Pasta) dos Arquivos
	 * @param pasta = Objeto do Banco(Pasta) que Ir� ser Exclu�do
	 * @return Se a Exclus�o do Banco(Pasta) foi Bem Sucedida ou N�o
	 */
	public boolean excluirBanco(File pasta)
	{
		
		if (pasta.isDirectory()) {//CHECA SE O CAMINHO DESSE BANCO(PASTA) EXISTE
            String[] children = pasta.list();//ARRAY DE STRING QUE CONT�M TODOS OS ARQUIVOS DENTO DO BANCO(PASTA)
            for (int i=0; i<children.length; i++) { //LA�O QUE PERCORRE TODOS OS ARQUIVOS 
               boolean success = excluirBanco(new File(pasta, children[i]));//CHAMADA REPERCURSIVA DA FUN��O
                if (!success) {
                    return false;
                }
            }
        }
		
		return pasta.delete();//RETORNO J� DELETANDO O BANCO(PASTA)
	}
	
	/** 
	 * M�todo Gera Objetos Nulos em um Determinado Banco Para Testes no Mesmo Banco;
	 *  @param num = N�mero de Arquivos Nulos Gerados
	 *  @param modo = (0)Gerar 1 Arquivo com V�rios Objetos, (1)Gerar V�rios Arquivos Cada Arquivo com 1 Objeto
	 *  @deprecated
	 */
	public void gerarObjetosParaTestes(int num,int modo) throws IOException
	{
		if(modo == 0)
		{
			FileOutputStream object = new FileOutputStream(this.caminho + this.banco + this.getArquivo() + ".ser");
			ObjectOutputStream objeto1 = new ObjectOutputStream(object);
			
			Object[] arquivo = new Object[num];
			
			for(long x=0; x < num; x++)
			{	
			
	        	arquivo[(int) x] = new Object();
			
	        	objeto1.writeObject(arquivo[(int) x]);
	        	   	
			}
			
			objeto1.close();
			
		}
		else if(modo == 1)
		{
			
			for(int x = 0;x < num;x++)
			{
				
				FileOutputStream object = new FileOutputStream(this.caminho + this.banco + this.getArquivo() + x + ".ser");
				ObjectOutputStream objeto1 = new ObjectOutputStream(object);
			
				Banco objeto = new Banco(x);
				objeto1.writeObject(objeto);
				
				objeto1.close();
			}
		}
	}
	
	/**
	 * M�todo que Busca um Arquivo no Banco pelo seu 'ID'
	 * @param id = 'ID' do Arquivo a ser Bsucado
	 * @return Arquivo com 'ID' correspondende(Caso Ouver Arquivo com esse id), se n�o, Retorna null
	 * @throws IOException
	 */
	public Object buscarArquivoPorId(long id)throws IOException
	{
		ServicoLog serLog = new ServicoLog();
		
		File file = new File(this.caminho + this.banco + this.getArquivo() + id +".ser");
		if(file.exists())
		{
			FileInputStream object = new FileInputStream(this.caminho + this.banco + this.getArquivo() + id +".ser");
			ObjectInputStream objeto1 = new ObjectInputStream(object);
			
			try
			{
				Object objeto = objeto1.readObject();
				
				objeto1.close();
				return objeto;
			}
			catch(Exception e)//N�O ENCONTROU NENHUM ARQUIVO COM ESSE ID
			{
				serLog.adicionarLogTemporario("N�o Existe Arquivo com Esse ID no Banco Buscado !");
				objeto1.close();			
				return null;			
			}
			
		}
		else//ARQUIVO N�O EXISTE
		{
			//serLog.adicionarLogTemporario("N�o Existe Arquivo com Esse ID no Banco Buscado !");
			return null;
		}
	}	
	
	/**
	 * M�todo que Retorna uma Lista com Todos os Arquivos do Banco
	 * @return Lista com Todos os Arquivos do Banco
	 * @throws IOException
	 */
	public Object[] listaBanco() throws IOException
	{
		int x = 0;
		
		Object[] lista = new Object[tamanhoBanco()];
		
		while(true)
		{
			
			Object objeto = buscarArquivoPorId(x);
			
			if(objeto !=null)
			{
				lista[x] = objeto;
				x++;
			}
			else
			{
				break;
			}
			
		}
		return lista;
	}
	
	/**
	 * M�todo que Retorna uma Lista com Todos os Log do Banco
	 * @return Lista com Todos os Logs do Banco
	 * @throws IOException
	 */
	public Object[] listaBancoLogs() throws IOException
	{
		int x = 1;
		
		Object[] lista = new Object[tamanhoBancoLog()];
		
		while(true)
		{
			
			Object objeto = buscarArquivoPorId(x);
			
			if(objeto !=null)
			{
				lista[x-1] = objeto;
				x++;
			}
			else
			{
				break;
			}
			
		}
		return lista;
	}
		
	/** 
	 * M�todo Cria Um Novo Arquivo do Banco
	 *  @param Arquivo = Arquivo a Ser Adicionado no Banco 
	 *  @param id = "Id" do Arquivo Adicionado
	 *  @return Objeto Criado
	 * @throws IOException 
	 */
	public Object criarArquivo(Object arquivo,long id) throws IOException
	{		
		try 
		{
			FileOutputStream object = new FileOutputStream(this.caminho + this.banco + this.getArquivo() + id + ".ser");
			ObjectOutputStream objeto1 = new ObjectOutputStream(object);
		
			objeto1.writeObject(arquivo);//PREENCHE O ARQUIVO COM OS ATRIBUTOS DO OBJETO		
			objeto1.close();
		}
		catch (Exception e)
		{}	
		
		return arquivo;
	}
	
	/** 
	 * M�todo Muda o Status de Algum Arquivo para Exclu�do
	 *  @param id = "Id" do Arquivo Que Ser� Exclu�do
	 *  @return Arquivo Exclu�do ou NULL(Caso Ocorra Algum Problema na Exclus�o do Objeto)
	 *  @deprecated
	 * @throws IOException 
	 * 
	 */
	public Object excluirArquivo(long id) throws IOException
	{
		ServicoLog serLog = new ServicoLog();
		Object arquivo1 =  new Object();
		Banco arquivo = new Banco(0);
		
		try 
		{
			arquivo1 = buscarArquivoPorId(id);
			arquivo = (Banco)arquivo1;
			
			if(arquivo != null)
			{
				if(arquivo.excluido ==false)
				{
					arquivo.excluido = true;
					
					FileOutputStream object = new FileOutputStream(this.caminho + this.banco + this.getArquivo() + id + ".ser");
					ObjectOutputStream objeto1 = new ObjectOutputStream(object);
			
					objeto1.writeObject(arquivo);
					objeto1.close();
					
				}
				else
				{
					serLog.adicionarLogTemporario("Arquivo J� foi Exclu�do !");
				}

			}
			else
			{
				serLog.adicionarLogTemporario("Arquivo N�o Encontrado !");
			}

		}
		catch(Exception e)
		{
			return null;
		}
		
		return arquivo;
	}
	
	/** 
	 * M�todo Edita Algum Arquivo do Banco
	 *  @param id = "Id" do Arquivo que Ser� Editado
	 *  @param Mensagem = Printar A Mensagem de Sucesso ou N�o
	 *  @return Objeto Editado ou NULL (Caso n�o Exista o Objeto)
	 * @throws IOException 
	 */
	public Object editarArquivo(long id,Object arquivoNovo) throws IOException
	{
		ServicoLog serLog = new ServicoLog();
		Object arquivo = buscarArquivoPorId(id);
		//Banco arquivo = (Banco)arquivo1;
		
		try 
		{
			if(arquivo !=null)
			{
					
				arquivo = arquivoNovo;
				//arquivo.idArquivo = id;
				arquivoNovo = (Object)arquivo;
					
				FileOutputStream object = new FileOutputStream(this.caminho + this.banco + this.getArquivo() + id + ".ser");
				ObjectOutputStream objeto1 = new ObjectOutputStream(object);
					
				objeto1.writeObject(arquivo);
				objeto1.close();


			}
			else
			{
				serLog.adicionarLogTemporario("Arquivo N�o Encontrado !");
			}

		}
		
		catch(Exception e)
		{}
		
		return arquivoNovo;
	}
	
	/** 
	 * M�todo Mostra o Tamanho do Banco
	 *  @return Tamanho do Banco
	 * @throws IOException 
	 */
	public int tamanhoBanco() throws IOException
	{
		int x = 0;
		
		while(true)
		{
			
			Object objeto = buscarArquivoPorId(x);
			if(objeto != null)
			{
				x++;
			}
			else
			{
				break;
			}
			
		}
		
		return x;
	}
	
	/** 
	 * M�todo Mostra o Tamanho do Banco de Logs
	 *  @return Tamanho do Banco de Logs
	 * @throws IOException 
	 */
	public int tamanhoBancoLog() throws IOException
	{
		int x = 1;
		
		while(true)
		{
			
			Object objeto = buscarArquivoPorId(x);
			if(objeto != null)
			{
				x++;
			}
			else
			{
				break;
			}
			
		}
		
		return x-1;
	}

	
		
}
