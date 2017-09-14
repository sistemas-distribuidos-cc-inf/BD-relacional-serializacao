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
	
	public List<Pessoa> getLista(){
		
		try {
			
			List<Pessoa> pessoas = new ArrayList<Pessoa>();
			PreparedStatement stmt =  this.connection.prepareStatement("select * from pessoas");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Pessoa pessoa = new Pessoa();
				pessoa.setId(rs.getLong("id"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setIdade(rs.getInt("idade"));
				
				pessoas.add(pessoa);
			}
			
			rs.close();
			stmt.close();
			return pessoas;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void altera(Pessoa pessoa) {
		
		String sql = "update pessoas set nome=?, idade=? where id=?";
		
		try {	
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, pessoa.getNome());
			stmt.setInt(2, pessoa.getIdade());
			stmt.setLong(3, pessoa.getId());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
