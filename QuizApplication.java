import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuizApplication extends JFrame implements ActionListener {

    String[][] questions = {
            {"What is the capital of India?", "Mumbai", "Delhi", "Kolkata", "Chennai"},
            {"Which language is used for Android development?", "Python", "Java", "C++", "PHP"},
            {"Which company developed Java?", "Microsoft", "Google", "Sun Microsystems", "Apple"},
            {"What does JVM stand for?", "Java Virtual Machine", "Java Variable Method", "Joint Virtual Machine", "None"},
            {"Which keyword is used to inherit a class in Java?", "implement", "inherits", "extends", "super"}
    };

    int[] answers = {2, 2, 3, 1, 3};

    JLabel questionLabel;
    JRadioButton option1, option2, option3, option4;
    ButtonGroup bg;
    JButton nextButton;
    int index = 0;
    int score = 0;

    public QuizApplication() {
        setTitle("Quiz Application");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(questionLabel, BorderLayout.NORTH);

        JPanel optionPanel = new JPanel();
        optionPanel.setLayout(new GridLayout(4, 1));

        option1 = new JRadioButton();
        option2 = new JRadioButton();
        option3 = new JRadioButton();
        option4 = new JRadioButton();

        bg = new ButtonGroup();
        bg.add(option1);
        bg.add(option2);
        bg.add(option3);
        bg.add(option4);

        optionPanel.add(option1);
        optionPanel.add(option2);
        optionPanel.add(option3);
        optionPanel.add(option4);

        add(optionPanel, BorderLayout.CENTER);

        nextButton = new JButton("Next");
        nextButton.addActionListener(this);
        add(nextButton, BorderLayout.SOUTH);

        loadQuestion(index);

        setVisible(true);
    }

    public void loadQuestion(int i) {
        questionLabel.setText("Q" + (i + 1) + ": " + questions[i][0]);

        option1.setText(questions[i][1]);
        option2.setText(questions[i][2]);
        option3.setText(questions[i][3]);
        option4.setText(questions[i][4]);

        bg.clearSelection();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int selected = 0;

        if (option1.isSelected()) selected = 1;
        if (option2.isSelected()) selected = 2;
        if (option3.isSelected()) selected = 3;
        if (option4.isSelected()) selected = 4;

        if (selected == answers[index]) {
            score++;
        }

        index++;

        if (index < questions.length) {
            loadQuestion(index);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Quiz Finished!\nYour Score: " + score + "/" + questions.length);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new QuizApplication();
    }
}
