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
        frame = new JFrame("Цвет настроения");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setOpaque(false);


        moodLabel = new JLabel("Выберите цвет настроения", SwingConstants.CENTER);
        moodLabel.setFont(new Font("Arial", Font.BOLD, 16));
        moodLabel.setOpaque(true);
        moodLabel.setBackground(Color.LIGHT_GRAY);
        moodLabel.setPreferredSize(new Dimension(400, 50));


        JButton redButton = createColorButton("Красный", Color.RED);
        JButton blueButton = createColorButton("Синий", Color.BLUE);
        JButton greenButton = createColorButton("Зелёный", Color.GREEN);

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

        // 1
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

        // 2
        ActionListener consoleListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Кнопка \"" + colorName + "\" была нажата");
            }
        };


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