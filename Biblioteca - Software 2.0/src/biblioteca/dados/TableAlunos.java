package biblioteca.dados;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Classe Responsável por Fazer o Estilo da Tabela de Alunos que é Exibido na View de Lista de Alunos
 */
public class TableAlunos extends DefaultTableCellRenderer{

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
		setForeground(new Color(51, 51, 51));
		
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
			if(column == 5)
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
		if(column == 5)
		{
			setHorizontalAlignment(JLabel.CENTER);
		}
		if(column == 5)
		{
			if(Double.parseDouble(Valor) == 0.0)
			{
				setForeground(Color.WHITE);
			}
			else if(Double.parseDouble(Valor) < 0.0)
			{
				setForeground(Color.RED);
			}
			else if(Double.parseDouble(Valor) > 0.0)
			{
				setForeground(Color.GREEN);
			}
		}

		table.getColumnModel().getColumn(0).setHeaderValue("");
		
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(1).setMaxWidth(400);
		table.getColumnModel().getColumn(2).setMaxWidth(200);
		table.getColumnModel().getColumn(3).setMaxWidth(150);
		table.getColumnModel().getColumn(4).setMaxWidth(220);
		table.getColumnModel().getColumn(5).setMaxWidth(100);	
	
		return this;
	}
}