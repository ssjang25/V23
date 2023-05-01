import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;


public class GUI implements ActionListener {
    private static JPanel window;
    private static JPanel panel;
    private static JFrame frame;
    private static JLabel intro;
    private static JLabel quest;
    private static JLabel date;
    private static JLabel summary;
    private static JLabel t2;
    private static JButton cancel;
    private static JButton cont; 
    private static JLabel question1; 
    private static JLabel question2; 
    private static JLabel question3; 
    private static JTextField answer1; 
    private static JTextField answer2;
    private static JTextField answer3;
    private static JLabel wrong;
    private static Color windowColor;
    private static Border loweredetched;
    private static JComboBox<String> dayList;
    private static JComboBox<String> timeList;
    private static JLabel hyperlink;
    private static JLabel and2;
    private static JLabel hyperlink2;

    public GUI(){
        window = new JPanel(new BorderLayout());
        panel = new JPanel(new BorderLayout());
        frame = new JFrame();
        windowColor = new Color(236,236,236,255);
        loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
    }

    public void startUp(){
        //Cancel and continue buttons 
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        cancel = new JButton(new AbstractAction("Cancel") {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
            }
        });
        
        cont = new JButton(new AbstractAction("Continue") {
            @Override
            public void actionPerformed(ActionEvent e){
                questions();
            }
        });
        buttonPanel.add(cancel);
        buttonPanel.add(cont);
        window.add(buttonPanel,BorderLayout.PAGE_END);

        //Outer panel
        window.setBorder(new EmptyBorder(50, 200, 60, 30));
        window.setBackground(windowColor);

        //Catalog section
        intro = new JLabel("💖 Introduction");
        quest = new JLabel("<html>"+"🤍 Questions <br/> "+"</html>");
        date = new JLabel("🤍 Date");
        summary = new JLabel("🤍 Summary");
        intro.setFont(new Font("SF Pro", Font.BOLD, 13));
        intro.setBounds(50, 50,100,100);
        quest.setFont(new Font("SF Pro", Font.PLAIN, 13));
        quest.setBounds(50, 90,100,100);
        quest.setForeground(Color.gray);
        date.setFont(new Font("SF Pro", Font.PLAIN, 13));
        date.setBounds(50, 130,100,100);
        date.setForeground(Color.gray);
        summary.setFont(new Font("SF Pro", Font.PLAIN, 13));
        summary.setBounds(50, 170,100,100);
        summary.setForeground(Color.gray);
        window.add(intro);
        window.add(quest);
        window.add(date);
        window.add(summary);

        //inner white panel 
        panel.setBackground(Color.white);
        panel.setPreferredSize(new Dimension(420,240));
        panel.setLayout(null);
        panel.setBorder(loweredetched);
        window.add(panel);

        //outside frame 
        frame.add(window);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("💌 Install V-Day Ver. 2023 💌");
        frame.setContentPane(window);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setPreferredSize(new Dimension(420,240));

        //panel title
        String text = "Welcome to the Valentines Day 2023 Installer";
        JLabel label = new JLabel("<html>"+text+"</html>");
        label.setBounds(200, 0, 400, 50);
        window.add(label);
        window.add(panel);

        //introduction text
        frame.getContentPane();
        String text2 = " " + "The Valentines Day desktop client aims to ask Alexis Cayabyab <br/> about his plans for Valentines Day. On Feburary 14th will be the <br/> second Valentines Day we are spending together. Have you had <br/> enough of me yet? <br/> <br/> <br/> <br/> By clicking “Continue”, you agree to my ";
        t2 = new JLabel("<html>"+text2+"</html>");
        t2.setFont(new Font("SF Pro", Font.PLAIN, 13));
        Dimension size = t2.getPreferredSize();
        t2.setBounds(10, 5, size.width, size.height);

        //Hyperlink
        String hyper = "Terms of Service";
        String and = "and";
        String hyper2 = "Privacy Statement.";
        hyperlink = new JLabel(hyper);
        hyperlink.setForeground(Color.BLUE.darker());
        hyperlink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        hyperlink.setFont(new Font("SF Pro", Font.PLAIN, 13));
        Dimension hyperSize = hyperlink.getPreferredSize();
        hyperlink.setBounds(261, 117, hyperSize.width, hyperSize.height);
        hyperlink.addMouseListener(new YourMouseListener(hyperlink, "https://www.youtube.com/shorts/Y5Qx4YFnHsM", hyper));
        and2 = new JLabel(and);
        and2.setFont(new Font("SF Pro", Font.PLAIN, 13));
        Dimension s2 = t2.getPreferredSize();
        and2.setBounds(369, 61, s2.width, s2.height);

        hyperlink2 = new JLabel(hyper2);
        hyperlink2.setFont(new Font("SF Pro", Font.PLAIN, 13));
        hyperlink2.setForeground(Color.BLUE.darker());
        hyperlink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Dimension s = hyperlink2.getPreferredSize();
        hyperlink2.setBounds(10, 134, s.width, s.height);

        hyperlink2.addMouseListener(new YourMouseListener(hyperlink2, "https://www.youtube.com/shorts/Q26EhYwQvMg", hyper2));

        panel.add(t2);
        panel.add(hyperlink);
        panel.add(and2);
        panel.add(hyperlink2);
        frame.revalidate();
        frame.setVisible(true);

    }

    public void questions(){
        //Update Catalog
        intro.setText("🤍 Introduction");
        intro.setFont(new Font("SF Pro", Font.PLAIN, 13));
        intro.setForeground(Color.gray);
        quest.setText("<html>"+"💖 Questions <br/> "+"</html>");
        quest.setFont(new Font("SF Pro", Font.BOLD, 13));
        quest.setForeground(Color.black);


        //Remove text in panel 
        removeComponent(t2);
        removeComponent(hyperlink);
        removeComponent(hyperlink2);
        removeComponent(and2);

        //Question and answer boxes
        frame.getContentPane();
        question1 = new JLabel("<html>"+" Do you like me?"+"</html>");
        question1.setFont(new Font("SF Pro", Font.PLAIN, 13));
        Dimension size = question1.getPreferredSize();
        question1.setBounds(155, 30, size.width, size.height);
        panel.add(question1);
        
        answer1 = new JTextField(10);
        answer1.setFont(new Font("SF Pro", Font.PLAIN, 13));
        Dimension size2 = answer1.getPreferredSize();
        answer1.setBounds(145, 45, size2.width, size2.height);
        panel.add(answer1);

        question2 = new JLabel("<html>"+" Do you love me?"+"</html>");
        question2.setFont(new Font("SF Pro", Font.PLAIN, 13));
        Dimension size3 = question2.getPreferredSize();
        question2.setBounds(155,80, size3.width, size3.height);
        panel.add(question2);

        answer2 = new JTextField(10);
        answer2.setFont(new Font("SF Pro", Font.PLAIN, 13));
        Dimension size4 = answer2.getPreferredSize();
        answer2.setBounds(145, 95, size4.width, size4.height);
        panel.add(answer2);
        frame.revalidate();

        question3 = new JLabel("<html>"+" Will you be my Valentine?"+"</html>");
        question3.setFont(new Font("SF Pro", Font.PLAIN, 13));
        Dimension size5 = question3.getPreferredSize();
        question3.setBounds(155, 130, size5.width, size5.height);
        panel.add(question3);
        
        answer3 = new JTextField(10);
        answer3.setFont(new Font("SF Pro", Font.PLAIN, 13));
        Dimension size6 = answer3.getPreferredSize();
        answer3.setBounds(145, 145, size6.width, size6.height);
        panel.add(answer3);
        frame.revalidate();


        AbstractAction checkAnswer = new AbstractAction("Continue"){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (answer1.getText().equalsIgnoreCase("No") && answer2.getText().equalsIgnoreCase("Yes") && answer3.getText().equalsIgnoreCase("Yes")){
                    //If wrong answer message exists, remove it from panel
                    if (GUI.wrong != null){
                        //wrong.setVisible(false);
                        removeComponent(wrong);
                    }
                    date();
                }
                else{
                    answer1.setText("");
                    answer2.setText("");
                    answer3.setText("");

                    //Wrong answer message
                    wrong = new JLabel("<html>"+" 💢 PABO!! Try again."+"</html>");
                    wrong.setForeground(Color.red);
                    wrong.setFont(new Font("SF Pro", Font.PLAIN, 13));
                    Dimension size = wrong.getPreferredSize();
                    wrong.setBounds(155, 180, size.width, size.height);
                    panel.add(wrong);
                    refreshFrame(panel);
                }
            }
        };
       cont.setAction(checkAnswer);
    }

    public void date(){
        //Update Catalog
        quest.setText("🤍 Questions");
        quest.setFont(new Font("SF Pro", Font.PLAIN, 13));
        quest.setForeground(Color.gray);
        date.setText("<html>"+"💖 Date <br/> "+"</html>");
        date.setFont(new Font("SF Pro", Font.BOLD, 13));
        date.setForeground(Color.black);

        //Remove answer boxes
        removeComponent(answer1);
        removeComponent(answer2);
        removeComponent(question3);
        removeComponent(answer3);

        //Combobox for day aka literally just Feb 14 but for shits n giggles
        question1.setText("<html>"+" Choose a day:"+"</html>");
        question1.setBounds(155,55, question1.getPreferredSize().width, question1.getPreferredSize().height);
        String[] day = {"February 14"};
        dayList = new JComboBox<String>(day);
        Dimension size = dayList.getPreferredSize();
        dayList.setBounds(145, 75, size.width, size.height);
        panel.add(dayList);
        refreshFrame(panel);
        
        //Combobox for time 
        question2.setText("<html>"+" Choose a time:"+"</html>");
        question2.setBounds(155,115, question2.getPreferredSize().width, question2.getPreferredSize().height);
        String[] time = {"5:00PM PST", "5:30PM PST", "6:00PM PST", "6:30PM PST", "6:30PM PST", "7:00PM PST", "7:30PM PST"};
        timeList = new JComboBox<String>(time);
        Dimension size2 = timeList.getPreferredSize();
        timeList.setBounds(145, 135, size2.width, size2.height);
        panel.add(timeList);
        refreshFrame(panel);

        //Store user input
        timeList.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                //Updates the selected item 
                JComboBox timeList = (JComboBox) event.getSource();
            }
        });

        //Update continue button
        AbstractAction checkAnswer = new AbstractAction("Continue"){
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = timeList.getSelectedItem().toString();
                summary(input);
            }
        };
        cont.setAction(checkAnswer);
    }

    public void summary(String time){
        //Update Catalog
        date.setText("🤍 Date");
        date.setFont(new Font("SF Pro", Font.PLAIN, 13));
        date.setForeground(Color.gray);
        summary.setText("<html>"+"💖 Summary <br/> "+"</html>");
        summary.setFont(new Font("SF Pro", Font.BOLD, 13));
        summary.setForeground(Color.black);

        //Change panel color for fun
        Color newColor = new Color(250,218,221);
        panel.setBackground(newColor);

        //Clear panel
        removeComponent(question1);
        removeComponent(question2);
        removeComponent(dayList);
        removeComponent(timeList);
        removeComponent(cancel);

        //Summarization paragraph
        frame.getContentPane();
        String text = "By typing your name, you agree to be my Valentine on <br/> February 14th, 2023 and go on a date with me at <br/> " + time + ". <br/><br/> If you wish to cancel, you can't sorry lol 💗";
        t2 = new JLabel("<html>"+text+"</html>");
        t2.setFont(new Font("SF Pro", Font.PLAIN, 15));
        Dimension size = t2.getPreferredSize();
        t2.setBounds(10, 5, size.width, size.height);
        panel.add(t2);
        frame.revalidate();

        JTextField answer = new JTextField(20);
        answer.setFont(new Font("SF Pro", Font.PLAIN, 15));
        Dimension size2 = answer.getPreferredSize();
        answer.setBounds(10, 180, size2.width, size2.height);
        panel.add(answer);
        frame.revalidate();

        //Update continue button to "Finish" and display a picture
        AbstractAction checkAnswer = new AbstractAction("Finish"){
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon icon = new ImageIcon(GUI.class.getResource("rilly lilly.jpg"));
                BufferedImage img = null;
                try {
                    img = ImageIO.read(GUI.class.getResource("rilly lilly.jpg"));
                } catch (IOException i){
                    i.printStackTrace();
                }
                Image dimg = img.getScaledInstance(200, 200,
                Image.SCALE_SMOOTH);
                ImageIcon imageIcon = new ImageIcon(dimg);
                JLabel image2 = new JLabel(imageIcon);

                frame.add(image2);
                panel.setVisible(false);
                frame.revalidate();
                end();
            }
        };
        cont.setAction(checkAnswer);
        //Once he clicks Finish again, it closes everything
    }

    public void end(){
        AbstractAction checkAnswer2 = new AbstractAction("Finish"){
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        };
        cont.setAction(checkAnswer2);
    }
    
    public void removeComponent(JComponent c){
        Container parent = c.getParent();
        parent.remove(c);
        refreshFrame(panel);
    }

    public void refreshFrame(JPanel p){
        frame.getContentPane().revalidate(); //dont know which one worked so keep all for now 
        frame.getContentPane().repaint();
        panel.revalidate();
        panel.repaint();
    }

    //Run everytime button gets clicked
    @Override
    public void actionPerformed(ActionEvent e) {
    }

}

//For hyperlink
class YourMouseListener extends MouseAdapter {
    JLabel label;
    String URL;
    String text;
    YourMouseListener(JLabel label, String URL, String text) {
        this.label = label;
        this.URL = URL;
        this.text = text;
    }
    public void mouseClicked(MouseEvent e) {
        try {
            Desktop.getDesktop().browse(new URI(URL));
        } catch (IOException | URISyntaxException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        label.setText(text);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        label.setText("<html><a href=''>" + text + "</a></html>");
    }
}