package Notepad_TestBased_GUI;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class NotepadMain extends JFrame implements ActionListener {
    JFrame frame;
    JTextArea TArea;
    NotepadAbout about;


    NotepadMain() {
        frame = new JFrame("Notepad"); //Instantiating Jframe
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        //Setting Icon of Notepad Application
        ImageIcon NotepadIcon = new ImageIcon(ClassLoader.getSystemResource("resources/NotepadIcon/note.png"));
        frame.setIconImage(NotepadIcon.getImage());

        //Instantiating Notepad menu
        JMenuBar menu = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu Edit = new JMenu("Edit");
        menu.add(file);
        menu.add(Edit);
        frame.setJMenuBar(menu);
        menu.setBackground(Color.white);
        //Creating MenuItems for File Menu
        file.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        JMenuItem New = new JMenuItem("New");
        New.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        New.addActionListener(this);
        New.setActionCommand("New");
        New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));

        JMenuItem Open = new JMenuItem("Open");
        Open.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        Open.addActionListener(this);
        Open.setActionCommand("Open");
        Open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));

        JMenuItem Save = new JMenuItem("Save");
        Save.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        Save.addActionListener(this);
        Save.setActionCommand("Save");
        Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

        JMenuItem Print = new JMenuItem("Print");
        Print.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        Print.addActionListener(this);
        Print.setActionCommand("Print");
        Print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        JMenuItem Exit = new JMenuItem("Exit");
        Exit.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        Exit.addActionListener(this);
        Exit.setActionCommand("Exit");
        Exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));

        //Adding MenuItems to File Menu
        file.add(New);
        file.add(Open);
        file.add(Save);
        file.add(Print);
        file.add(Exit);

        //Creating MenuItems for Edit Menu
        Edit.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        JMenuItem Cut = new JMenuItem("Cut");
        Cut.addActionListener(this);
        Cut.setActionCommand("Cut");
        Cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

        JMenuItem Copy = new JMenuItem("Copy");
        Copy.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        Copy.addActionListener(this);
        Copy.setActionCommand("Copy");
        Copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));

        JMenuItem Paste = new JMenuItem("Save");
        Paste.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        Paste.addActionListener(this);
        Paste.setActionCommand("Paste");
        Paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));

        JMenuItem SelectAll = new JMenuItem("Select All");
        SelectAll.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        SelectAll.addActionListener(this);
        SelectAll.setActionCommand("Selectall");
        SelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));

        //Adding MenuItems to Edit Menu
        Edit.add(Cut);
        Edit.add(Copy);
        Edit.add(Paste);
        Edit.add(SelectAll);

        //Instantiating The Help Menu
        JMenu Help = new JMenu("Help");
        Help.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        JMenuItem About = new JMenuItem("About Notepad");
        About.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        About.addActionListener(this);
        About.setActionCommand("About");
        Help.add(About);
        menu.add(Help);

        //Creating TextArea
        TArea = new JTextArea();
        TArea.setFont(new Font("Ariel", Font.PLAIN, 14));

        TArea.setBackground(Color.white);
        TArea.setForeground(Color.black);
        TArea.setLineWrap(true);
        TArea.setWrapStyleWord(true);

        //Adding ScrollPane to TextArea
        JScrollPane scroll = new JScrollPane(TArea);
        scroll.setBorder(BorderFactory.createEmptyBorder()); //This removes the Border of ScrollPane

        //Adding ScrollPane to Frame
        frame.add(scroll/*It has JTextArea in it*/);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(MAXIMIZED_BOTH);
        frame.setVisible(true);
    }


    public boolean OpenFile(NotepadMain m) {
        JFileChooser fc = new JFileChooser();
        fc.setAcceptAllFileFilterUsed(false);
        fc.addChoosableFileFilter(new FileNameExtensionFilter("Only Txt Files", "txt"));
        int i = fc.showOpenDialog(null);
        if (i != JFileChooser.APPROVE_OPTION)
            return false;
        File file = fc.getSelectedFile();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String s1 = "", s2 = " ";
            while ((s1 = br.readLine()) != null) {
                s2 += s1 + "\n";
            }
            this.TArea.setText(s2);
            br.close();
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            throw new RuntimeException("FIle Not Found");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public boolean NewFile(NotepadMain m) {
        if (m != null) {
            m.TArea.setText("");
            return true;
        }
        return false;
    }

    public boolean SaveFile(NotepadMain m) {
        JFileChooser save = new JFileChooser();
        save.setApproveButtonText("Save");
        save.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter TextFilter = new FileNameExtensionFilter("Only .txt files", "txt");
        save.addChoosableFileFilter(TextFilter);
        int i = save.showSaveDialog(null);
        if (i != save.APPROVE_OPTION) {
            return false;
        }
        if (i == JFileChooser.APPROVE_OPTION) {
            File file = new File(save.getSelectedFile() + ".txt");
            try {
                java.io.FileWriter fw = new java.io.FileWriter(file);
                fw.write(TArea.getText());
                fw.close();
            } catch (Exception ex) {
                ex.printStackTrace();

            }

        }
        return true;
    }

    public static void main(String[] args) {
        new NotepadMain();
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
      String command = e.getActionCommand();
      switch (command)
      {
          case "New":
              NewFile(this);
              break;
              case "Open":
              OpenFile(this);
              break;
              case "Save":
              SaveFile(this);
              break;
              case "Print":
                  printfile(this);
                  break;
                  case "Exit":
                      exit();
                      break;
                      case "Cut":
                          cut(this);
                          break;
                          case "Copy":
                              copy(this);
                              break;
          case "Paste":
              paste(this);
              break;
                              case "Selectall":
                                  selectall(this);
                                  break;
                                  case "About":
                                      about();
                                      break;
                                      default:
                                          break;
      }
    }

    public boolean printfile(NotepadMain m) {
        try {
            m.TArea.print();
            return true;
        } catch (PrinterException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean cut(NotepadMain m) {
        if (m != null)
        {
            try{

                m.TArea.cut();
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    public boolean copy(NotepadMain m)
    {
        if (m != null)
        {
            try{

                m.TArea.copy();
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return false;
    }

    public boolean paste(NotepadMain m)
    {
        if (m != null)
        {
            try{

                m.TArea.paste();
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return false;
    }

    public boolean selectall(NotepadMain m)
    {
        if (m != null)
        {
            try{

                m.TArea.selectAll();
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return false;
    }

    public NotepadAbout about()
    {
         about = new NotepadAbout();
        return about;
    }

    public boolean exit()
    {
        System.exit(0);
        return true;
    }
}

