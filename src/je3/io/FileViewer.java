package je3.io;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by IDEA on 28/01/15.
 */
public class FileViewer extends Frame implements ActionListener{

    String directory;
    TextArea textArea;
    private ActionEvent e;

    public FileViewer() {
        this(null, null);
    }

    public FileViewer(String filename) {
        this(null, filename);
    }

    public FileViewer(String directory, String filename) {
        super(); // creates the frame
        addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        textArea = new TextArea("", 24, 80);
        textArea.setFont(new Font("MonoSpaced", Font.PLAIN, 12));
        textArea.setEditable(false);
        this.add(textArea, "Center");

        Panel p = new Panel();
        p.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        this.add(p, "South");

        Font font = new Font("SansSerif", Font.BOLD, 14);
        Button openfile = new Button("Open file");
        Button close = new Button("Close");
        openfile.addActionListener(this);
        openfile.setActionCommand("open");
        openfile.setFont(font);
        close.addActionListener(this);
        close.setActionCommand("close");
        close.setFont(font);
        p.add(openfile);
        p.add(close);
        this.pack();

        if(directory == null) {
            File f;
            if((filename != null) && (f = new File(filename)).isAbsolute()) {
                directory = f.getParent();
                filename = f.getName();
            }
            else directory = System.getProperty("user.dir");
        }
        this.directory = directory;
        setFile(directory, filename);
    }

    private void setFile(String directory, String filename) {
        if((filename == null) || (filename.length() == 0)) {
            return;
        }
        File f;
        FileReader in = null;
        try {
            f = new File(directory, filename);
            in = new FileReader(f);
            char[] buffer = new char[4096];
            int len;
            textArea.setText(""); // clear text area
            while((len = in.read(buffer)) != -1)  {
                String s = new String(buffer, 0, len);
                textArea.append(s);
            }
        } catch (FileNotFoundException e) {
            String s = "File not found: " + filename;
            System.err.println(s);
            this.setTitle(s);
        } catch (IOException e) {
            String s = "Failed to read file: " + filename;
            System.err.println(s);
            this.setTitle(s);
        }
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if(cmd.equals("open")) {
            FileDialog f = new FileDialog(this, "Open file", FileDialog.LOAD);
            f.setDirectory(directory);
            f.setVisible(true);
            directory = f.getDirectory();
            setFile(directory, f.getFile());
            f.dispose();
        }
        else if(cmd.equals("close")) {
            this.dispose();
        }
    }

    public static void main(String[] args) {
        Frame f = new FileViewer((args.length == 1) ? args[0] : null);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setVisible(true);
    }
}
