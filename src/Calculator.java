import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    static JFrame frame;
    static JTextField field;
    String str, str1, str2;
    double memory = 0;

    Color COLOR_BG = new Color(30, 30, 30);          // Dark app background
    Color COLOR_DISPLAY = new Color(45, 45, 45);     // Darker display field
    Color COLOR_NUMBERS = new Color(60, 60, 60);     // Sleek charcoal for digits
    Color COLOR_OPS = new Color(80, 80, 80);         // Mid grey for operators
    Color COLOR_ACCENT = new Color(234, 144, 16);    // Gorgeous orange for clear/equals
    Color COLOR_TEXT = Color.WHITE;

    public Calculator() {
        // FIXED: Corrected initialization assignment
        str = "";
        str1 = "";
        str2 = "";
    }

    public static void main(String[] args) {
        frame = new JFrame("Flood Calculator");
        // FIXED: Ensures the program actually exits when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Calculator c = new Calculator();
        field = new JTextField(16);
        field.setEditable(false);
        field.setFont(new Font("Arial", Font.BOLD, 24));
        field.setHorizontalAlignment(JTextField.RIGHT);
        field.setPreferredSize(new Dimension(300, 50));

        JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, bc, beq,
                bsq, bexp, bfac, blog, bsin, bcos, btan, binv, bMC, bMR, bm1, bm2;
        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");

        beq = new JButton("=");
        ba = new JButton("+");
        bs = new JButton("-");
        bd = new JButton("/");
        bm = new JButton("*");
        bc = new JButton("C");
        be = new JButton(".");
        bsq = new JButton("√");
        binv = new JButton("1/x");
        bfac = new JButton("!");
        blog = new JButton("Log");
        bsin = new JButton("Sin");
        bcos = new JButton("cos");
        btan = new JButton("Tan");
        bexp = new JButton("Exp");

        bMC = new JButton("MC");
        bMR = new JButton("MR");
        bm1 = new JButton("M+");
        bm2 = new JButton("M-");

        Font buttonFont = new Font("Arial", Font.PLAIN, 18);
        b0.setFont(buttonFont);
        b1.setFont(buttonFont);
        b2.setFont(buttonFont);
        b3.setFont(buttonFont);
        b4.setFont(buttonFont);
        b5.setFont(buttonFont);
        b6.setFont(buttonFont);
        b7.setFont(buttonFont);
        b8.setFont(buttonFont);
        b9.setFont(buttonFont);

        beq.setFont(buttonFont);
        ba.setFont(buttonFont);
        bs.setFont(buttonFont);
        bd.setFont(buttonFont);
        bm.setFont(buttonFont);
        bc.setFont(buttonFont);
        be.setFont(buttonFont);
        bfac.setFont(buttonFont);
        bsq.setFont(buttonFont);
        binv.setFont(buttonFont);
        blog.setFont(buttonFont);
        bcos.setFont(buttonFont);
        bsin.setFont(buttonFont);
        btan.setFont(buttonFont);
        bexp.setFont(buttonFont);

        bm1.setFont(buttonFont);
        bm2.setFont(buttonFont);
        bMC.setFont(buttonFont);
        bMR.setFont(buttonFont);

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(7, 4, 5, 5));

        bm.addActionListener(c);
        bd.addActionListener(c);
        bs.addActionListener(c);
        ba.addActionListener(c);

        b9.addActionListener(c);
        b8.addActionListener(c);
        b7.addActionListener(c);
        b6.addActionListener(c);
        b5.addActionListener(c);
        b4.addActionListener(c);
        b3.addActionListener(c);
        b2.addActionListener(c);
        b1.addActionListener(c);
        b0.addActionListener(c);

        bfac.addActionListener(c);
        be.addActionListener(c);
        bc.addActionListener(c);
        beq.addActionListener(c);
        bsq.addActionListener(c);
        binv.addActionListener(c);
        blog.addActionListener(c);
        bsin.addActionListener(c);
        bcos.addActionListener(c);
        btan.addActionListener(c);
        bexp.addActionListener(c);

        bm1.addActionListener(c);
        bm2.addActionListener(c);
        bMC.addActionListener(c);
        bMR.addActionListener(c);

        p.add(bMR); p.add(bMC); p.add(bm1); p.add(bm2);
        p.add(b1); p.add(b2); p.add(b3); p.add(ba);
        p.add(b4); p.add(b5); p.add(b6); p.add(bs);
        p.add(b7); p.add(b8); p.add(b9); p.add(bm);
        p.add(b0); p.add(bsq); p.add(bexp); p.add(bd);
        p.add(bsin); p.add(btan); p.add(bcos); p.add(be);
        p.add(blog); p.add(bfac); p.add(bc); p.add(beq);

        frame.setLayout(new BorderLayout());
        frame.add(field, BorderLayout.NORTH);
        frame.add(p, BorderLayout.CENTER);

        p.setBackground(Color.lightGray);
        frame.setSize(400, 500);
        frame.setVisible(true);
    }

    // FIXED: Explicit @Override to satisfy the interface requirement
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
            if (!str1.equals("")) {
                str2 = str2 + s;
            } else {
                str = str + s;
            }
            field.setText(str + str1 + str2);
        } else if (s.charAt(0) == 'C') {
            str = str1 = str2 = "";
            field.setText("");
        } else if (s.charAt(0) == '=') {
            double te = 0;
            try {
                if (str1.equals("+")) {
                    te = (Double.parseDouble(str) + Double.parseDouble(str2));
                } else if (str1.equals("-")) {
                    te = (Double.parseDouble(str) - Double.parseDouble(str2));
                } else if (str1.equals("/")) {
                    te = (Double.parseDouble(str) / Double.parseDouble(str2));
                } else if (str1.equals("*")) {
                    te = (Double.parseDouble(str) * Double.parseDouble(str2));
                } else if (str1.equals("√")) {
                    te = Math.sqrt(Double.parseDouble(str));
                } else if (str1.equals("1/x")) {
                    te = 1 / Double.parseDouble(str);
                } else if (str1.equals("Log")) {
                    te = Math.log(Double.parseDouble(str));
                } else if (str1.equals("Sin")) {
                    te = Math.sin(Math.toRadians(Double.parseDouble(str)));
                } else if (str1.equals("Tan")) {
                    te = Math.tan(Math.toRadians(Double.parseDouble(str)));
                } else if (str1.equals("Exp")) {
                    te = Math.exp(Double.parseDouble(str));
                } else if (str1.equals("cos")) {
                    te = Math.cos(Math.toRadians(Double.parseDouble(str)));
                } else if (str1.equals("!")) {
                    int value = Integer.parseInt(str);
                    if (value < 0) {
                        field.setText("Error");
                    } else {
                        long fact = factorial(value);
                        field.setText(str + "!" + "=" + fact);
                        str = Long.toString(fact);
                    }
                    str1 = str2 = "";
                    return;
                }
                // FIXED: Adding memory button backend execution handler logic
                else if (str1.equals("M+")) {
                    memory += Double.parseDouble(str);
                    te = Double.parseDouble(str);
                } else if (str1.equals("M-")) {
                    memory -= Double.parseDouble(str);
                    te = Double.parseDouble(str);
                } else if (str1.equals("MC")) {
                    memory = 0;
                    te = Double.parseDouble(str);
                } else if (str1.equals("MR")) {
                    te = memory;
                }
            } catch (Exception ex) {
                field.setText("Error");
                str = str1 = str2 = "";
                return;
            }
            field.setText(str + str1 + str2 + "=" + te);
            str = Double.toString(te);
            str1 = str2 = "";
        } else if (s.equals("√") || s.equals("1/x") || s.equals("Log") ||
                s.equals("Sin") || s.equals("cos") || s.equals("Tan") || s.equals("Exp") ||
                s.equals("MC") || s.equals("MR") || s.equals("M+") || s.equals("M-") || s.equals("!")) {
            str1 = s;
            actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "="));
        } else {
            if (str1.equals("") || str2.equals("")) {
                str1 = s;
            } else {
                double te = 0;
                if (str1.equals("+")) {
                    te = (Double.parseDouble(str) + Double.parseDouble(str2));
                } else if (str1.equals("-")) {
                    te = (Double.parseDouble(str) - Double.parseDouble(str2));
                } else if (str1.equals("/")) {
                    te = (Double.parseDouble(str) / Double.parseDouble(str2));
                } else if (str1.equals("*")) {
                    te = (Double.parseDouble(str) * Double.parseDouble(str2));
                }
                str = Double.toString(te);
                str1 = s;
                str2 = "";
            }
            field.setText(str + str1 + str2);
        }
    }

    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}