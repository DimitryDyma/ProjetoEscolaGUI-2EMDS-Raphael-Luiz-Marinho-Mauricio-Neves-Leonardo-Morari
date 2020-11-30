package com.company.view;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class formMenu {
    private JButton alunoButton;
    private JButton sairButton;
    private JButton disciplinasButton;
    private JButton professorButton;
    private JPanel menuPanel;
    public static JFrame telaAluno;
    public static JFrame telaProfessor;
    public static JFrame telaDisciplina;

    public JPanel getMenuPanel() {
        return menuPanel;
    }

    public formMenu() {
        alunoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                telaAluno = new JFrame("Cadastro de Alunos");
                telaAluno.setContentPane(new formAluno().getAlunoPanel());
                telaAluno.setSize(500,500);
                telaAluno.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
                telaAluno.setVisible(true);

            }
        });
        sairButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0);
            }
        });
        professorButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                telaProfessor = new JFrame("Cadastro De Professores");
                telaProfessor.setContentPane(new formProfessor().getProfessorPanel());
                telaProfessor.setSize(500,500);
                telaProfessor.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
                telaProfessor.setVisible(true);

            }
        });

        disciplinasButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                telaDisciplina = new JFrame("Cadastro de Disciplinas");
                telaDisciplina.setContentPane(new formDisciplina().getDisciplinaPanel());
                telaDisciplina.setSize(500,500);
                telaDisciplina.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
                telaDisciplina.setVisible(true);
            }
        });
    }
}
