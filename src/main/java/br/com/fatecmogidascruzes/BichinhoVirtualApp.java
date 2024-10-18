package br.com.fatecmogidascruzes;

import br.com.fatecmogidascruzes.entity.Animal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BichinhoVirtualApp {
    private final Animal animal;
    private final JFrame frame;
    private final JLabel labelCaloria;
    private final JLabel labelForca;
    private final JLabel labelIdade;
    private final JLabel labelVivo;

    public BichinhoVirtualApp() {
        String[] opcoesAnimais = {"Leão", "Elefante", "Águia"};
        String escolha = (String) JOptionPane.showInputDialog(
                null,
                "Escolha um animal para começar:",
                "Seleção de Animal",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoesAnimais,
                opcoesAnimais[0]
        );

        animal = new Animal();
        if (escolha != null) {
            switch (escolha) {
                case "Leão":
                    animal.nascer("Mamífero", "Felidae", "Leão");
                    break;
                case "Elefante":
                    animal.nascer("Mamífero", "Elephantidae", "Elefante");
                    break;
                case "Águia":
                    animal.nascer("Ave", "Accipitridae", "Águia");
                    break;
                default:
                    animal.nascer("Desconhecido", "Desconhecido", "Desconhecido");
            }
        } else {
            animal.nascer("Desconhecido", "Desconhecido", "Desconhecido"); // Caso o usuário cancele a seleção
        }

        frame = new JFrame("Bichinho Virtual");
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel labelClasse = new JLabel("Classe: " + animal.getClasse());
        labelClasse.setBounds(50, 20, 300, 20);

        JLabel labelFamilia = new JLabel("Família: " + animal.getFamilia());
        labelFamilia.setBounds(50, 40, 300, 20);

        JButton botaoComer = new JButton("Comer");
        botaoComer.setBounds(50, 70, 100, 30);
        botaoComer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    animal.comer();
                    atualizarStatus();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton botaoCorrer = new JButton("Correr");
        botaoCorrer.setBounds(150, 70, 100, 30);
        botaoCorrer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    animal.correr();
                    atualizarStatus();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton botaoDormir = new JButton("Dormir");
        botaoDormir.setBounds(250, 70, 100, 30);
        botaoDormir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    animal.dormir();
                    atualizarStatus();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JLabel labelStatus = new JLabel("Status do Animal:");
        labelStatus.setBounds(50, 120, 300, 30);

        labelCaloria = new JLabel("Caloria: " + animal.getCaloria());
        labelCaloria.setBounds(50, 150, 300, 30);

        labelForca = new JLabel("Força: " + animal.getForca());
        labelForca.setBounds(50, 180, 300, 30);

        labelIdade = new JLabel("Idade: " + animal.getIdade());
        labelIdade.setBounds(50, 210, 300, 30);

        labelVivo = new JLabel("Vivo: " + (animal.isVivo() ? "Sim" : "Não"));
        labelVivo.setBounds(50, 240, 300, 30);

        frame.add(labelClasse);
        frame.add(labelFamilia);
        frame.add(botaoComer);
        frame.add(botaoCorrer);
        frame.add(botaoDormir);
        frame.add(labelStatus);
        frame.add(labelCaloria);
        frame.add(labelForca);
        frame.add(labelIdade);
        frame.add(labelVivo);

        frame.setVisible(true);
        atualizarStatus();
    }

    private void atualizarStatus() {
        labelCaloria.setText("Caloria: " + animal.getCaloria());
        labelForca.setText("Força: " + animal.getForca());
        labelIdade.setText("Idade: " + animal.getIdade());
        labelVivo.setText("Vivo: " + (animal.isVivo() ? "Sim" : "Não"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BichinhoVirtualApp();
            }
        });
    }
}
