package aula03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    // 1 - Consulta
    public List<Curso> list() {
        //Preparar lista que irá retornar cusos após consultar o banco de dados;
        List<Curso> cursos = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection()) {
            //Preparar consulta SQL.
            String sql = "SELECT * FROM curso";

            //Preparar statement com os parâmetros recebidos (nesta função não tem parâmetros, pois irá retornar todos os valores da tabela aluno)
            PreparedStatement stmt = conn.prepareStatement(sql);

            //Executa consulta e armazena o retorno da consulta no objeto "rs".
            ResultSet rs = stmt.executeQuery();

            //Criar um objeto curso e guardar na lista de cursos.
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int duracaoHoras = rs.getInt("duracaoHoras");

                cursos.add(new Curso(
                        id,
                        nome,
                        duracaoHoras
                ));
            }
        } catch (SQLException e) {
            System.out.println("Erro na listagem de cursos!");
            e.printStackTrace();
        }

        //Retornar todos os cursos encontrados no banco de dados.
        return cursos;
    }

    // 1.1 - Consulta com filtro
    public Curso getById(int id) {
        //Preparar objeto curso para receber os valores do banco de dados.
        Curso curso = new Curso("Engenharia de Software", 400);

        try (Connection conn = ConnectionFactory.getConnection()) {
            //Preparar consulta SQL
            String sql = "SELECT * FROM curso WHERE id = ?";

            //Preparar statement com os parâmetros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            //Executa consulta e armazena o retorno da consulta no objeto "rs".
            ResultSet rs = stmt.executeQuery();

            //Guardar valores retornados da tabela curso no objeto curso
            if (rs.next()){
                curso.setId(rs.getInt("id"));
                curso.setNome(rs.getString("nome"));
                curso.setDuracaoHoras(rs.getInt("duracaoHoras"));
            }

        } catch (SQLException e) {
            System.out.println("Listagem de cursos FALHOU!");
            e.printStackTrace();
        }

        //Retorna curso encontrado no banco de dados.
        return curso;
    }

    // 2 - Inserção
    public void create(Curso curso) {
        try (Connection conn = ConnectionFactory.getConnection()) {

            //Preparar SQL para inserção de dados do curso.
            String sql = "INSERT INTO curso (nome, duracaoHoras) VALUES(?, ?)";

            //Preparar statement com os parâmetros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso.getNome());
            stmt.setInt(2, curso.getDuracaoHoras());

            //Executa inserção e armazena o numero de linhas afetadas
            int rowsAffected = stmt.executeUpdate();

            System.out.println("curso.getNome(): " + curso.getNome());
            System.out.println("Inserção BEM SUCEDIDA!. Foi adicionada " + rowsAffected + " linha");
        } catch (SQLException e) {
            System.out.println("Inserção FALHOU!");
            e.printStackTrace();
        }
    }

    // 3 - Delete
    public void delete(int id) {
        try (Connection conn = ConnectionFactory.getConnection()) {

            //Preparar SQL para deletar uma linha.
            String sql = "DELETE FROM curso WHERE id = ?";

            //Preparar statement com os parâmetros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1 , id);

            //Executa delete e armazena o numero de linhas afetadas
            int rowsAffected = stmt.executeUpdate();

            System.out.println("Delete BEM SUCEDIDA! Foi deletada " + rowsAffected + " linha");
        } catch (SQLException e) {
            System.out.println("Delete FALHOU!");
            e.printStackTrace();
        }
    }

    // 4 - Atualizar
    public void update(Curso curso) {
        try (Connection conn = ConnectionFactory.getConnection()) {

            //Preparar SQL para atualizar linhas.
            String sql = "UPDATE curso SET nome = ?, duracaoHoras = ? WHERE id = ?";

            //Preparar statement com os parâmetros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso.getNome());
            stmt.setInt(2, curso.getDuracaoHoras());
            stmt.setInt(3, curso.getId());

            //Executa atualização e armazena o numero de linhas afetadas
            int rowsAffected = stmt.executeUpdate();

            System.out.println("Atualização BEM SUCEDIDA! Foi atualizada: " + rowsAffected + " linha");
        } catch (SQLException e) {
            System.out.println("Atualização FALHOU!");
            e.printStackTrace();
        }
    }

}
