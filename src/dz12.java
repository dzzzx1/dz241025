import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class dz12 {
    private JFrame frame;
    private JLabel moodLabel;

    public dz12() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        // Создаем главное окно
        frame = new JFrame("Цвет настроения");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Создаем панель для кнопок и делаем ее прозрачной
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setOpaque(false); // Важно: делаем панель прозрачной

        // Создаем метку для отображения настроения
        moodLabel = new JLabel("Выберите цвет настроения", SwingConstants.CENTER);
        moodLabel.setFont(new Font("Arial", Font.BOLD, 16));
        moodLabel.setOpaque(true);
        moodLabel.setBackground(Color.LIGHT_GRAY);
        moodLabel.setPreferredSize(new Dimension(400, 50));

        // Создаем кнопки
        JButton redButton = createColorButton("Красный", Color.RED);
        JButton blueButton = createColorButton("Синий", Color.BLUE);
        JButton greenButton = createColorButton("Зелёный", Color.GREEN);

        // Добавляем компоненты
        buttonPanel.add(redButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(greenButton);

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(moodLabel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private JButton createColorButton(String colorName, Color color) {
        JButton button = new JButton(colorName);
        button.setPreferredSize(new Dimension(100, 40));

        // ЗАДАНИЕ 1: Первый слушатель - меняет цвет фона окна и текст
        ActionListener colorChangeListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Меняем фон contentPane
                frame.getContentPane().setBackground(color);
                moodLabel.setText("Ваш цвет настроения: " + colorName);
                // Принудительно перерисовываем
                frame.repaint();
            }
        };

        // ЗАДАНИЕ 2: Второй слушатель - выводит в консоль
        ActionListener consoleListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Кнопка \"" + colorName + "\" была нажата");
            }
        };

        // Добавляем оба слушателя к кнопке
        button.addActionListener(colorChangeListener);
        button.addActionListener(consoleListener);

        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new dz12();
            }
        });
    }
}