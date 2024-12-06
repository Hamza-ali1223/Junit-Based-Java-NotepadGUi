package Notepad_TestBased_GUI;

import javax.swing.*;
import java.awt.*;

public class NotepadAbout extends JFrame {
    NotepadAbout() {
        setTitle("About Notepad");
        setBounds(350, 150, 700, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon NotepadIcon = new ImageIcon(ClassLoader.getSystemResource("resources/NotepadIcon/note.png"));
        setIconImage(NotepadIcon.getImage());
        //Setting Win 11 Logo
        ImageIcon MainIcon = new ImageIcon(ClassLoader.getSystemResource("resources/NotepadIcon/hehe.png"));
        Image img = MainIcon.getImage().getScaledInstance(300, 80, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(img);
        JLabel HeaderIcon = new JLabel(i3);

        //Setting Notepad Logo
        ImageIcon NotepadLogo = new ImageIcon(ClassLoader.getSystemResource("resources/NotepadIcon/note.png"));
        Image img1 = NotepadLogo.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i4 = new ImageIcon(img1);
        JLabel NotepadPic = new JLabel(i4);
        NotepadPic.setBounds(50, 180, 70, 70);

        //Setting Text
        JLabel Text = new JLabel("<html><br><br>Notepad is a simple text editor for Microsoft Windows and a basic text-editing program which enables computer users to create documents. It was first released as a mouse-based MS-DOS program in 1983, and has been included in all versions of Microsoft Windows since Windows 1.0 in 1985.<br><br>Notepad is a common text-only (plain text) editor. The resulting files—typically saved with the .txt extension—have no format tags or styles, making the program suitable for editing system files that are to be used in a DOS environment and occasionally source code for later compilation or execution, usually through a command prompt.<br><br>Notepad supports both left-to-right and right-to-left based languages, and is available on all Windows versions.<br> Hehe, Made By Hamza The Genius in Two Days \uD83D\uDE0E</html>");
        Text.setBounds(150, 100, 500, 315);
        Text.setFont(new Font("Georgia", Font.PLAIN, 16));
        HeaderIcon.setBounds(70, 40, 400, 80);

        //Adding Okay Button
        JButton Okay = new JButton("Ok");
        Okay.setBounds(300, 450, 100, 30);


        add(Okay);
        add(Text);
        add(HeaderIcon);
        add(NotepadPic);


        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}