package bancodedados;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import dados.Pessoa;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PessoaDAO {
	
	private Connection connection;
	
	public PessoaDAO() {
		
		this.connection = new ConnectionFactory().getConnection();	
	}
	
	public void adiciona(Pessoa pessoa) {
		
			String sql = "insert into pessoas " + "(nome, idade)" + " values (?, ?)";
		
			try {
			
				PreparedStatement stmt =  connection.prepareStatement(sql);
			
				stmt.setString(1, pessoa.getNome());
				stmt.setInt(2, pessoa.getIdade());
				
				stmt.execute();
				stmt.close();
			
			} catch(SQLException e) {
				throw new RuntimeException(e);
			}
	}
}
