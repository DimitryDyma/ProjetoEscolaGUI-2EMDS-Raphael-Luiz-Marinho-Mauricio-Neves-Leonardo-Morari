package com.company.dao;

import com.company.model.Professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProfessorDao {
    //	conectando
    Connection con	=	new	ConnectionFactory().getConnection();

    public void inserirDado(Professor professor) throws SQLException {
        //Preparando o Statement
        String	sql	=	"insert	into professor"	+
                "	(cpf, nome, email, telefone, endereco)"	+
                "	values	(?,?,?,?,?)";
        PreparedStatement stmt	=	con.prepareStatement(sql);

        //preenche valores
        stmt.setString(1, professor.getCpf());
        stmt.setString(2, professor.getNome());
        stmt.setString(3, professor.getEmail());
        stmt.setString(4, professor.getTelefone());
        stmt.setString(5, professor.getEndereco());


        //executa
        stmt.execute();
        stmt.close();

    }
}
