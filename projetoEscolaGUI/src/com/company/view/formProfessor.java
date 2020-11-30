package com.company.view;

import com.company.dao.DisciplinaDao;
import com.company.dao.ProfessorDao;
import com.company.model.Professor;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class formProfessor {
    private JTextField txtCPF;
    private JTextField txtNome;
    private JTextField txtEmail;
    private JTextField txtTelefone;
    private JTextField txtEndereco;
    private JButton btnGravar;
    private JButton btnSair;
    private JPanel professorPanel;


    public formProfessor() {

        btnGravar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Professor professor = new Professor();
                professor.setCpf(txtCPF.getText());
                professor.setNome(txtNome.getText());
                professor.setEmail(txtEmail.getText());
                professor.setEndereco(txtEndereco.getText());
                professor.setTelefone(txtTelefone.getText());

                ProfessorDao dao = new ProfessorDao();
                try {
                    dao.inserirDado(professor);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Erro \n" + ex.toString(),
                            "Erro ao Cadastrar Professor",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }

                JOptionPane.showMessageDialog(
                        null,
                        "dados do professor cadastrado \n " + professor.toString(),
                        "cadastro do professor efetuado com sucesso",
                        JOptionPane.INFORMATION_MESSAGE
                );
                limparTela();

            }
        });
        btnSair.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                sairDoCadastro();
            }
        });
    }

    private void sairDoCadastro() {
        formMenu.telaProfessor.dispose();
    }


    private void limparTela() {
        txtCPF.setText("");
        txtEmail.setText("");
        txtEndereco.setText("");
        txtNome.setText("");
        txtTelefone.setText("");

    }
 public JPanel getProfessorPanel(){
        return professorPanel;
 }
}
