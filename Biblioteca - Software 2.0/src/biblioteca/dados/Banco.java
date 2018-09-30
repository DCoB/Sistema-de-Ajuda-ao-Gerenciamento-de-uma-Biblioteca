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
 * Classe que Realiza as Operações nos Bancos
 *  @version 3.0
 *  @param Banco = Banco em que as alterações Serão Feitas
 *  @param Arquivo = Arquivo Genérico da Classe em que as Alterações Serão Feitas
 *  @param IdArquivo = ID do Arquivo que as Alterações Serão Feitas
 *  @param Excluido = Usuário está ativo (false) ou inativo (true)
 *  @param Caminho = Caminho do Windowns Onde os Banco Estão Salvos
 */
public class Banco implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String banco;
	private String arquivo;
	private long idArquivo;
	private boolean excluido = false;
	private String caminho;
	
	
	/** 
	 * Método Contrutor da Classe Banco
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
	* Método que Cria a Pasta Onde Irão ficar os Bancos
	*/
	public void criarDiretorio()
	{
		File pasta = new File(this.caminho);//NOVO OBJETO DA CLASSE FILE
		
		if(pasta.exists() == false)//CHECA SE A PASTA JÁ EXISTE, SE ELA NÃO EXISTIR ENTRA NO 'if'
		{
			pasta.mkdir();//CRIA A PASTA
		}
	}
		
	/** 
	 * Método Cria Uma Pasta Onde Será Armazenado os Arquivos
	 */
	public void criarBanco()
	{
		File pasta = new File(this.caminho + this.banco);//CRIAR UM OBJETO DA CLASSE FILE, COM O CAMINHO DO ARQUIVO DEFINIDO
		
		pasta.mkdir();//CRIA O BANCO(PASTA) ONDE SERÃO ARMAZENADOS OS ARQUIVOS
	}
	
	/** 
	 * Método Limpa Um Banco(Pasta) Onde os Arquivos Estão Armazenados
	 */
	public void limparBanco()
	{
		File pasta = new File(this.caminho + this.banco);//CRIAR UM OBJETO DA CLASSE FILE, COM O CAMINHO DO ARQUIVO DEFINIDO
		if(excluirBanco(pasta)!=true)//CHECA SE A EXCLUSÃO DO BANCO FOI BEM SUCEDIDA OU NÃO ATRAVÉS DO MÉTODO 'excluirBanco'
 		{}
		criarBanco();//CHAMA O MÉTODO PARA CRIAR UM NOVO BANCO
	}
	
	/**
	 * Método Excluí um Banco(Pasta) dos Arquivos
	 * @param pasta = Objeto do Banco(Pasta) que Irá ser Excluído
	 * @return Se a Exclusão do Banco(Pasta) foi Bem Sucedida ou Não
	 */
	public boolean excluirBanco(File pasta)
	{
		
		if (pasta.isDirectory()) {//CHECA SE O CAMINHO DESSE BANCO(PASTA) EXISTE
            String[] children = pasta.list();//ARRAY DE STRING QUE CONTÉM TODOS OS ARQUIVOS DENTO DO BANCO(PASTA)
            for (int i=0; i<children.length; i++) { //LAÇO QUE PERCORRE TODOS OS ARQUIVOS 
               boolean success = excluirBanco(new File(pasta, children[i]));//CHAMADA REPERCURSIVA DA FUNÇÃO
                if (!success) {
                    return false;
                }
            }
        }
		
		return pasta.delete();//RETORNO JÁ DELETANDO O BANCO(PASTA)
	}
	
	/** 
	 * Método Gera Objetos Nulos em um Determinado Banco Para Testes no Mesmo Banco;
	 *  @param num = Número de Arquivos Nulos Gerados
	 *  @param modo = (0)Gerar 1 Arquivo com Vários Objetos, (1)Gerar Vários Arquivos Cada Arquivo com 1 Objeto
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
	 * Método que Busca um Arquivo no Banco pelo seu 'ID'
	 * @param id = 'ID' do Arquivo a ser Bsucado
	 * @return Arquivo com 'ID' correspondende(Caso Ouver Arquivo com esse id), se não, Retorna null
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
			catch(Exception e)//NÃO ENCONTROU NENHUM ARQUIVO COM ESSE ID
			{
				serLog.adicionarLogTemporario("Não Existe Arquivo com Esse ID no Banco Buscado !");
				objeto1.close();			
				return null;			
			}
			
		}
		else//ARQUIVO NÃO EXISTE
		{
			//serLog.adicionarLogTemporario("Não Existe Arquivo com Esse ID no Banco Buscado !");
			return null;
		}
	}	
	
	/**
	 * Método que Retorna uma Lista com Todos os Arquivos do Banco
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
	 * Método que Retorna uma Lista com Todos os Log do Banco
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
	 * Método Cria Um Novo Arquivo do Banco
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
	 * Método Muda o Status de Algum Arquivo para Excluído
	 *  @param id = "Id" do Arquivo Que Será Excluído
	 *  @return Arquivo Excluído ou NULL(Caso Ocorra Algum Problema na Exclusão do Objeto)
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
					serLog.adicionarLogTemporario("Arquivo Já foi Excluído !");
				}

			}
			else
			{
				serLog.adicionarLogTemporario("Arquivo Não Encontrado !");
			}

		}
		catch(Exception e)
		{
			return null;
		}
		
		return arquivo;
	}
	
	/** 
	 * Método Edita Algum Arquivo do Banco
	 *  @param id = "Id" do Arquivo que Será Editado
	 *  @param Mensagem = Printar A Mensagem de Sucesso ou Não
	 *  @return Objeto Editado ou NULL (Caso não Exista o Objeto)
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
				serLog.adicionarLogTemporario("Arquivo Não Encontrado !");
			}

		}
		
		catch(Exception e)
		{}
		
		return arquivoNovo;
	}
	
	/** 
	 * Método Mostra o Tamanho do Banco
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
	 * Método Mostra o Tamanho do Banco de Logs
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
