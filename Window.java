import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Window extends JFrame implements ActionListener {
    JTextField textField;
    JLabel welcome, site;
    JButton supernatural, youtube, vk, open;
    public String entered_url;
    private String imgVk = "src/vk.png", yt="src/yt.jpeg";
    private boolean res = false;
    Window(){
        this.setTitle("WEBSITE OPENER");
        this.setSize(400,340);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setResizable(res);
        welcome = new JLabel();
        welcome.setText("Hello this is a site opener!\n please enter ONLY website name :)");
        welcome.setFont(new Font(Font.DIALOG, Font.BOLD, 10));
        welcome.setOpaque(true);
        welcome.setBackground(Color.GRAY);
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(350, 50));
        textField.setFont(new Font(Font.SERIF, Font.ITALIC, 30));
        open = new JButton();
        open.setText("OPEN");
        open.setOpaque(true);
        open.setBackground(Color.PINK);
        open.addActionListener(this);
        open.setFont(new Font("Verdana", Font.PLAIN, 20));
        site = new JLabel();
        vk = new JButton("VK");
        ImageIcon i = new ImageIcon(imgVk);
        vk.setIcon(i);
        vk.setPreferredSize(new Dimension(300,80));
        vk.addActionListener(this);
        youtube = new JButton("YOUTUBE");
        youtube.setPreferredSize(new Dimension(300,80));
        youtube.addActionListener(this);
        ImageIcon yi = new ImageIcon(yt);
        youtube.setIcon(yi);
        this.add(welcome);
        this.add(textField);
        this.add(open);
        this.add(site);
        this.add(youtube);
        this.add(vk);
        this.setVisible(true);
    }
    private static void play(URI someUri){

        if(Desktop.isDesktopSupported()){
            try{
                Desktop.getDesktop().browse(someUri);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private static void openVk() throws URISyntaxException {
        URI vk = new URI("https://vk.com");
        play(vk);
    }

    private static void openYt() throws URISyntaxException {
        URI yt = new URI("https://youtube.com");
        play(yt);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == open){
            entered_url = "https://" + textField.getText() + ".com";
            textField.setText("");
            try {
                URI uri = new URI(entered_url);
                site.setText(textField.getText());
                site.setFont(new Font("verdana", Font.BOLD, 20));
                play(uri);
            } catch (URISyntaxException ex) {
                throw new RuntimeException(ex);
            }
        }

        if(e.getSource() == vk) {
            try {
                openVk();
            } catch (URISyntaxException ex) {
                throw new RuntimeException(ex);
            }
        }

        if(e.getSource() == youtube){
            try{
                openYt();
            }catch (URISyntaxException ex){
                throw new RuntimeException(ex);
            }
        }
    }
}
