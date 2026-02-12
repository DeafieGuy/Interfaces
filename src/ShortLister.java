// ShortLister.java
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShortLister {

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Select a text file");
        int result = chooser.showOpenDialog(null);

        if (result != JFileChooser.APPROVE_OPTION) {
            System.out.println("No file selected. Exiting.");
            return;
        }

        File file = chooser.getSelectedFile();
        Filter filter = new ShortWordFilter();

        StringBuilder out = new StringBuilder();
        int count = 0;

        try (Scanner scanner = new Scanner(file)) {
            // Use non-word characters as delimiters so punctuation is removed
            scanner.useDelimiter("\\W+");
            while (scanner.hasNext()) {
                String token = scanner.next();
                if (filter.accept(token)) {
                    out.append(token).append(System.lineSeparator());
                    count++;
                }
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File not found: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (count == 0) {
            JOptionPane.showMessageDialog(null, "No short words (length < 5) found in the file.",
                    "Results", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("No short words found.");
            return;
        }

        // Show results in a scrollable text area and also print to console
        JTextArea textArea = new JTextArea(out.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(500, 400));

        JOptionPane.showMessageDialog(null, scrollPane,
                "Short words found (" + count + ")", JOptionPane.INFORMATION_MESSAGE);

        System.out.println("Short words found (" + count + "):");
        System.out.println(out.toString());
    }
}
