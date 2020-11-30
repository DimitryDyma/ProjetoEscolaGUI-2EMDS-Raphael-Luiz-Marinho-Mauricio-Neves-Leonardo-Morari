package com.company.view;

import com.company.dao.AlunoDao;
import com.company.dao.DisciplinaDao;
import com.company.model.Disciplina;
import com.company.model.TipoDisciplina;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class formDisciplina {
    private JTextField txtNome;
    private JLabel label1;
    private JComboBox comboTipo;
    private JButton btnGravar;
    private JButton btnSair;
    private JPanel DisciplinaPanel;


    public formDisciplina() {
        btnGravar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Disciplina disciplina = new Disciplina();
                disciplina.setNome(txtNome.getText());
                TipoDisciplina tipoDisciplina = TipoDisciplina.exatas;
                switch (comboTipo.getSelectedIndex()){
                    case 0:
                        tipoDisciplina = TipoDisciplina.exatas;
                        break;
                    case 1:
                        tipoDisciplina = TipoDisciplina.biologicas;
                        break;
                    case 2:
                        tipoDisciplina = TipoDisciplina.humanas;
                        break;
                    case 3:
                        tipoDisciplina = TipoDisciplina.linguas;
                        break;
                }
                disciplina.setTipo(tipoDisciplina);

                DisciplinaDao dao = new DisciplinaDao();
                try {
                    dao.inserirDado(disciplina);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Erro \n" + ex.toString(),
                            "Erro ao Cadastrar Disciplina",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }

                JOptionPane.showMessageDialog(
                        null,
                        "Dados da disciplina cadastrada \n" + disciplina.toString(),
                        "Cadastro da disciplina efetuado com sucesso",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });
        btnSair.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                sairDoCadastro();
            }
        });
    }
    private void limparTela() {
        txtNome.setText("");
        comboTipo.setSelectedIndex(0);
    }

    private void sairDoCadastro() {

        formMenu.telaDisciplina.dispose();
    }
    public JPanel getDisciplinaPanel()
    {
        return DisciplinaPanel;
    }

}
