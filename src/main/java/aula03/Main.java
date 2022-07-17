package aula03;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        CursoDAO cursoDAO = new CursoDAO();

        // =========================== 1 - Consulta =================================================
        List<Curso> cursos = cursoDAO.list();

        cursos.stream().forEach(System.out::println);


        // ======================= 1.1 - Consulta com filtro ========================================
        Curso cursoParaConsulta = cursoDAO.getById(1);

        //System.out.println(cursoParaConsulta);


        // =========================== 2 - Inserção =================================================
        Curso cursoParaInsercao = new Curso(
                "Banco de Dados MYSQL",
                180
        );

        // cursoDAO.create(cursoParaInsercao);


        // =========================== 3 - Delete ===================================================
        // cursoDAO.delete(6);


        // =========================== 4 - Atualizar ================================================
        Curso cursoParaAtualizar = cursoDAO.getById(1);
        cursoParaAtualizar.setNome("Programacao Orientada a Objetos");
        cursoParaAtualizar.setDuracaoHoras(1600);

        cursoDAO.update(cursoParaAtualizar);
    }

}
