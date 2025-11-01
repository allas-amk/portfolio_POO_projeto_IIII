package br.com.engenheirodesoftwarenoespaco.projetoswingfaculdade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoMySQL {

    // REQUISITO 3: Configuração dos parâmetros de conexão
    private static final String URL = "jdbc:mysql://localhost:3306/meu_projeto_db";
    private static final String USUARIO = "root"; // Altere conforme seu usuário
    private static final String SENHA = "sua_senha"; // Altere conforme sua senha

    public static void main(String[] args) {

        Connection conexao = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // REQUISITO 5: Estabelecer a conexão (DriverManager faz o trabalho)
            System.out.println("1. Tentando conectar ao banco de dados MySQL...");
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("✅ Conexão bem-sucedida com o banco de dados MySQL!");

            // REQUISITO 6: Preparar e executar a consulta SQL
            stmt = conexao.createStatement();
            String sql = "SELECT ID, Nome, Email FROM Usuarios";
            System.out.println("\n2. Executando a consulta: " + sql);
            rs = stmt.executeQuery(sql);

            // REQUISITO 7: Processar o resultado retornado
            System.out.println("\n--- Resultados da Consulta ---");

            while (rs.next()) {
                // Captura os dados de cada linha
                int id = rs.getInt("ID");
                String nome = rs.getString("Nome");
                String email = rs.getString("Email");

                // Exibe no console
                System.out.printf("ID: %d, Nome: %s, Email: %s%n", id, nome, email);
            }

        } catch (SQLException e) {
            // Bloco para capturar e reportar erros de conexão ou SQL
            System.err.println("❌ Ocorreu um erro de SQL: " + e.getMessage());
            e.printStackTrace();

        } finally {
            // Bloco essencial para garantir que os recursos sejam FECHADOS,
            // mesmo que ocorra um erro (evita vazamento de memória).
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
                System.out.println("\n3. Conexão e recursos fechados com sucesso.");
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }
}
