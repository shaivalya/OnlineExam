import javax.swing.*;
import java.awt.*;

public class ResultPage extends JFrame {

    public ResultPage(int score, int total) {
        setTitle("Exam Result");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));
        setLocationRelativeTo(null);

        JLabel resultLabel = new JLabel("Your Score: " + score + "/" + total, SwingConstants.CENTER);
        JLabel messageLabel;

        if (score >= (total + 1) / 2) {
            messageLabel = new JLabel("✅ You Passed!", SwingConstants.CENTER);
        } else {
            messageLabel = new JLabel("❌ You Failed!", SwingConstants.CENTER);
        }

        add(resultLabel);
        add(messageLabel);

        setVisible(true);
    }
}
