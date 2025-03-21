package suka.ok;
import javax.swing.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Path> paths = new ArrayList<>();
    public static void deleteRecursively(Path path) throws IOException {
        if (Files.isDirectory(path)) {
            try (DirectoryStream<Path> entries = Files.newDirectoryStream(path)) {
                for (Path entry : entries) {
                    deleteRecursively(entry);
                }
            }
        }
        Files.delete(path);
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Yazabil");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        JButton button = new JButton("delete yandex");
        button.setBounds(200,300,200,50);
        frame.add(button);
        frame.setVisible(true);

        paths.add(Paths.get("C:/Program Files (x86)/Yandex/YandexBrowser"));
        paths.add(Paths.get("C:/Users/User/AppData/Roaming/Yandex"));
        paths.add(Paths.get("C:/Users/User/AppData/Local/Yandex"));
        button.addActionListener(e -> {
            System.out.println("hello niggas");
            int a=JOptionPane.showConfirmDialog(frame,"Are you sure?");
            if (a==JOptionPane.YES_OPTION){
                for (Path path : paths) {
                    if (Files.exists(path)) {
                        try {
                            deleteRecursively(path);
                            System.out.println("ego net: " + path);
                        } catch (Exception i) {
                            System.out.println("oshibka: " + path);
                            i.printStackTrace();
                        }
                    } else {
                        System.out.println("no way: " + path);
                    }
                }
            }
        });
    }

}
