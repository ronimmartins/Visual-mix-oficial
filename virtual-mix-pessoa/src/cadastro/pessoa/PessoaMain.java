package cadastro.pessoa;

import java.sql.SQLException;
import java.util.List;

public class PessoaMain {
	public static void main(String[] args) throws SQLException {

		// Estancia a classe para inserir uma pessoa
		Pessoa p = new Pessoa();

		// Incluindo as informações para o inserir
		p.setNome("Rafael dos santos");
		p.setEndereco("rua 1 n 153 ap 5");
		p.setEmail("uol@uol.com");
		p.setRg("3046678530");
		p.setTel("45562389");

		// Estancia a Classe PessoaDao que gerar um novo id para inserir e seta o id na
		// variavel
		PessoaDao pd = new PessoaDao();
		int id = pd.incluir(p);

		// Método de classe para alterar a pessoa
		p.setId_pessoa(id);
		p.setNome("alte");
		p.setEndereco("alte");
		p.setEmail("alt");
		p.setRg("3046678530");
		p.setTel("45562389");

		// Método de classe para alterar
		// pd.alterar(p);

		// Método listar todas pessoa
		/*List<Pessoa> select = pd.selecionarTodos();
		for (Pessoa pessoa : select) {
			System.out.println("Código: " + pessoa.getId_pessoa() + " Nome: " + pessoa.getNome() + " End.: "
					+ pessoa.getEndereco());

		}*/
		
		// Método listar unica pessoa
		Pessoa ps = pd.selecionaId(p);
		System.out.println("Código: " + ps.getId_pessoa() + " Nome: " + ps.getNome() + " End.: "
				+ ps.getEndereco());

		// Método de classe para exclusão
		// pd.deletar(id);

	}
}
