package com.company.dao;

import com.company.model.Disciplina;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DisciplinaDao {
    //	conectando
    Connection con	=	new	ConnectionFactory().getConnection();

    public void inserirDado(Disciplina disciplina) throws SQLException {
        //Preparando o Statement
        String	sql	=	"insert	into disciplina"	+
                "	(nome, tipodisciplina)"	+
                "	values	(?,?)";
        PreparedStatement stmt	=	con.prepareStatement(sql);

        //preenche valores
        stmt.setString(1, disciplina.getNome());
        stmt.setString(2, disciplina.getTipo().toString());


        //executa
        stmt.execute();
        stmt.close();

    }
}
