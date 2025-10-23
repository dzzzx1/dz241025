import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class dz3 {
    private JFrame frame;
    private JDialog popup;

    public dz3() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        // Создаем главное окно
        frame = new JFrame("Реакция на события мыши");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        // Создаем кнопку
        JButton button = new JButton("Наведи на меня");
        button.setPreferredSize(new Dimension(150, 50));

        // ActionListener для нажатия кнопки
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Кнопка была нажата");
            }
        });

        // MouseListener для наведения мыши
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Создаем и показываем всплывающее окно
                showPopup();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Скрываем всплывающее окно
                hidePopup();
            }
        });

        // Создаем всплывающее окно (изначально невидимое)
        createPopup();

        frame.add(button);
        frame.setVisible(true);
    }

    private void createPopup() {
        popup = new JDialog(frame, "Внимание!", false);
        popup.setLayout(new FlowLayout());
        popup.add(new JLabel("Ты навёл курсор на кнопку!"));
        popup.setSize(250, 100);
        popup.setResizable(false);
    }

    private void showPopup() {
        if (popup != null) {
            // Позиционируем окно рядом с кнопкой
            Point buttonLocation = frame.getLocation();
            popup.setLocation(buttonLocation.x + 150, buttonLocation.y + 100);
            popup.setVisible(true);
        }
    }

    private void hidePopup() {
        if (popup != null) {
            popup.setVisible(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new dz3();
            }
        });
    }
}