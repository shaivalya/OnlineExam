import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ExamPage extends JFrame implements ActionListener {
    ArrayList<Question> questions;
    JLabel qLabel;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup group;
    JButton nextBtn, submitBtn;
    int index = 0, score = 0;

    public ExamPage() {
        setTitle("Online Exam");
        setSize(500, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 1));
        setLocationRelativeTo(null);

        // 🔹 10 Sample Questions
        questions = new ArrayList<>();
        questions.add(new Question("What is the capital of India?", "Delhi", "Mumbai", "Chennai", "Kolkata", 1));
        questions.add(new Question("Who invented Java?", "James Gosling", "Dennis Ritchie", "Bjarne Stroustrup", "Guido van Rossum", 1));
        questions.add(new Question("Which keyword is used to inherit a class?", "this", "extends", "super", "implements", 2));
        questions.add(new Question("Which company owns Java?", "Google", "Oracle", "Microsoft", "IBM", 2));
        questions.add(new Question("What is the size of int in Java?", "2 bytes", "4 bytes", "8 bytes", "Depends on OS", 2));
        questions.add(new Question("Which method is the entry point of Java programs?", "start()", "init()", "main()", "run()", 3));
        questions.add(new Question("Which of these is not a Java feature?", "Object-Oriented", "Portable", "Use of pointers", "Dynamic", 3));
        questions.add(new Question("Which of the following is not a primitive type?", "int", "float", "boolean", "String", 4));
        questions.add(new Question("Which keyword is used to stop a loop?", "stop", "exit", "break", "return", 3));
        questions.add(new Question("Which package contains the Swing classes?", "java.awt", "javax.swing", "java.io", "java.net", 2));

        // 🔹 UI Components
        qLabel = new JLabel();
        add(qLabel);

        opt1 = new JRadioButton();
        opt2 = new JRadioButton();
        opt3 = new JRadioButton();
        opt4 = new JRadioButton();

        group = new ButtonGroup();
        group.add(opt1);
        group.add(opt2);
        group.add(opt3);
        group.add(opt4);

        add(opt1);
        add(opt2);
        add(opt3);
        add(opt4);

        nextBtn = new JButton("Next");
        submitBtn = new JButton("Submit");

        nextBtn.addActionListener(this);
        submitBtn.addActionListener(this);

        add(nextBtn);
        add(submitBtn);

        loadQuestion(index);
        setVisible(true);
    }

    void loadQuestion(int idx) {
        group.clearSelection();
        Question q = questions.get(idx);
        qLabel.setText("Q" + (idx + 1) + ": " + q.question);
        opt1.setText(q.option1);
        opt2.setText(q.option2);
        opt3.setText(q.option3);
        opt4.setText(q.option4);
    }

    int getSelectedOption() {
        if (opt1.isSelected()) return 1;
        if (opt2.isSelected()) return 2;
        if (opt3.isSelected()) return 3;
        if (opt4.isSelected()) return 4;
        return 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextBtn) {
            int selected = getSelectedOption();
            if (selected == questions.get(index).correctAnswer) score++;

            index++;

            if (index < questions.size()) {
                loadQuestion(index);
            } else {
                nextBtn.setEnabled(false);
                JOptionPane.showMessageDialog(this, "No more questions. Click Submit.");
            }

        } else if (e.getSource() == submitBtn) {
            // ✅ Ensure index is within bounds before checking answer
            if (index < questions.size()) {
                int selected = getSelectedOption();
                if (selected == questions.get(index).correctAnswer) {
                    score++;
                }
            }

            dispose();  // close exam window
            new ResultPage(score, questions.size());  // open result window
        }
    }
}
