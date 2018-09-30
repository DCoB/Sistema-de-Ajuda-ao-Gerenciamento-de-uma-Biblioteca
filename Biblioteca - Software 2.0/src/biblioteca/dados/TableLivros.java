package biblioteca.dados;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *  * Classe Responsável por Fazer o Estilo da Tabela de Livros que é Exibido na View de Lista de Livros
 */
public class TableLivros extends DefaultTableCellRenderer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
	{
		
		super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);  
	
		String Valor = String.valueOf(value);
		table.setRowHeight(70);
		table.getTableHeader().setFont(new Font("Rockwell", Font.BOLD, 18));
		setBorder(new MatteBorder(2, 5, 10, 5, Color.BLACK));
		
		if(Valor.equals("Insdisponível"))
		{
			setBackground(Color.red);
		}
		else if(Valor.equals("Disponível"))
		{		
			setForeground(Color.GREEN);
		}
		else
		{
			setForeground(new Color(51, 51, 51));
		}
	
		
		if(row % 2 == 0 )
		{
			setBackground(new Color(51, 153, 255));			
		}
		else
		{
			setBackground(new Color(102, 153, 255));
		}
		
		
		if(isSelected){
			setBackground(Color.darkGray);
			if(column == 6)
			{
				setForeground(getForeground()); 
			}
			else
			{
				setForeground(Color.WHITE);
			}
		}
	
		if(column == 0)
		{
			setValue("");
		}
		if(column == 6)
		{
			setHorizontalAlignment(JLabel.CENTER);
		}
		if(column == 5)
		{
			if(Double.parseDouble(Valor) == 0.0)
			{
				setForeground(Color.WHITE);
			}
			else if(Double.parseDouble(Valor) > 0.0 && Double.parseDouble(Valor) < 5.0)
			{
				setForeground(Color.RED);
			}
			else if(Double.parseDouble(Valor) == 5.0)
			{
				setForeground(Color.BLUE);
			}
			else if(Double.parseDouble(Valor) > 5.0 && Double.parseDouble(Valor) < 8.0)
			{
				setForeground(Color.GREEN);
			}
			else if(Double.parseDouble(Valor) > 8.0)
			{
				setForeground(Color.YELLOW);
			}
		}

		table.getColumnModel().getColumn(0).setHeaderValue("");
		
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(1).setMaxWidth(400);
		table.getColumnModel().getColumn(2).setMaxWidth(200);
		table.getColumnModel().getColumn(3).setMaxWidth(50);
		table.getColumnModel().getColumn(4).setMaxWidth(100);
		table.getColumnModel().getColumn(5).setMaxWidth(80);
		table.getColumnModel().getColumn(6).setMaxWidth(150);
		
		
		
	
		return this;
	}
}