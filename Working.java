import java.awt.*;
import java.awt.event.*;

class InitVariable {
    char alphabet[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' ', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    int index = 0;
    String message;
    String result = "";

    void encrypt(char mess, char alphabet[]) {
        int j;
        for (j = 0; j < alphabet.length; j++) {
            if (mess == alphabet[j]) {
                index = j;
                switch (alphabet[j]) {
                    case 'z':
                        index = 2;
                        break;
                    case 'y':
                        index = 1;
                        break;
                    case 'x':
                        index = 0;
                        break;
                    case ' ':
                        index = 26;
                        break;
                    case '0':
                        index = 29;
                        break;
                    case '9':
                        index = 28;
                        break;
                    case '8':
                        index = 27;
                        break;
                    case 'Z':
                        index = 39;
                        break;
                    case 'Y':
                        index = 38;
                        break;
                    case 'X':
                        index = 37;
                        break;
                    default:
                        index += 3;
                }
            }
        }
    }

    void decrypt(char mess, char alphabet[]) {
        int j;
        for (j = 0; j < alphabet.length; j++) {
            if (mess == alphabet[j]) {
                index = j;
                switch (alphabet[j]) {
                    case 'c':
                        index = 25;
                        break;
                    case 'b':
                        index = 24;
                        break;
                    case 'a':
                        index = 23;
                        break;
                    case ' ':
                        index = 26;
                        break;
                    case '3':
                        index = 36;
                        break;
                    case '2':
                        index = 35;
                        break;
                    case '1':
                        index = 34;
                        break;
                    case 'C':
                        index = 62;
                        break;
                    case 'B':
                        index = 61;
                        break;
                    case 'A':
                        index = 60;
                        break;
                    default:
                        index -= 3;
                }
            }
        }
    }
}

class Working extends Frame implements WindowListener {
    TextField tfip;
    TextField tfop;
    Button btn;
    Button btn1;

    public Working() {
        setTitle("Application");
        setLayout(new BorderLayout());

        tfip = new TextField();
        tfop = new TextField();
        tfop.setEditable(false);

        Panel inputPanel = new Panel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(new Label("Enter text - "), BorderLayout.WEST);
        inputPanel.add(tfip, BorderLayout.CENTER);

        Panel outputPanel = new Panel();
        outputPanel.setLayout(new BorderLayout());
        outputPanel.add(new Label("Processed text - "), BorderLayout.WEST);
        outputPanel.add(tfop, BorderLayout.CENTER);

        add(inputPanel, BorderLayout.NORTH);
        add(outputPanel, BorderLayout.CENTER);

        Panel buttonPanel = new Panel();
        btn = new Button("Encrypt");
        btn1 = new Button("Decrypt");
        buttonPanel.add(btn);
        buttonPanel.add(btn1);

        add(buttonPanel, BorderLayout.SOUTH);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                InitVariable iv = new InitVariable();
                iv.message = tfip.getText();
                iv.result = "";
                int i;
                for (i = 0; i < iv.message.length(); i++) {
                    iv.encrypt(iv.message.charAt(i), iv.alphabet);
                    iv.result += iv.alphabet[iv.index];
                }
                tfop.setText(iv.result);
                tfip.setText("");
            }
        });

        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                InitVariable iv = new InitVariable();
                iv.message = tfip.getText();
                iv.result = "";
                int i;
                for (i = 0; i < iv.message.length(); i++) {
                    iv.decrypt(iv.message.charAt(i), iv.alphabet);
                    iv.result += iv.alphabet[iv.index];
                }
                tfop.setText(iv.result);
                tfip.setText("");
            }
        });

        addWindowListener(this);
        setSize(400, 400);
        setVisible(true);
    }

    public static void main(String args[]) {
        Working working = new Working();
    }

    // Implement the WindowListener methods
    public void windowOpened(WindowEvent evt) {
    }

    public void windowClosing(WindowEvent evt) {
        System.exit(0);
    }

    public void windowClosed(WindowEvent evt) {
    }

    public void windowIconified(WindowEvent evt) {
    }

    public void windowDeiconified(WindowEvent evt) {
    }

    public void windowActivated(WindowEvent evt) {
    }

    public void windowDeactivated(WindowEvent evt) {
    }
}
