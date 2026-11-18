package assignment;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Locale;
public class ProductApp extends JFrame {
    private final JTextField customer = new JTextField(22);
    private final JComboBox<String> product = new JComboBox<>(new String[]{"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"});
    private final JTextField price = new JTextField(22);
    public ProductApp() {
        super("Product App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel form = new JPanel(new GridLayout(4, 2, 10, 12));
        form.setBorder(BorderFactory.createEmptyBorder(25, 20, 25, 20));
        form.add(new JLabel("Customer Name:")); form.add(customer);
        form.add(new JLabel("Select Product:")); form.add(product);
        form.add(new JLabel("Enter Price:")); form.add(price);
        JButton process = new JButton("PROCESS");
        form.add(new JLabel("")); form.add(process);
        process.addActionListener(e -> processSale());
        JMenuBar bar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(e -> dispose()); file.add(exit);
        JMenu tools = new JMenu("Tools");
        JMenuItem run = new JMenuItem("Process");
        run.addActionListener(e -> processSale());
        JMenuItem clear = new JMenuItem("Clear");
        clear.addActionListener(e -> { customer.setText(""); price.setText(""); product.setSelectedIndex(0); });
        tools.add(run); tools.add(clear);
        bar.add(file); bar.add(tools); setJMenuBar(bar);
        add(form); pack(); setLocationRelativeTo(null);
    }
    private void processSale() {
        String name = customer.getText().trim();
        if (name.isEmpty()) { JOptionPane.showMessageDialog(this, "Please enter a customer name."); return; }
        try {
            double amount = Double.parseDouble(price.getText().trim());
            ProductCalculations calc = new ProductCalculations(amount);
            String selected = (String) product.getSelectedItem();
            String report = String.format(Locale.US,
                "Customer Name: %s%nProduct: %s%nVAT: R %.2f%nCOMMISSION: R %.2f%nTOTAL: R %.2f",
                name, selected, calc.GetVat(), calc.GetCommission(), calc.GetTotal());
            Path path = Path.of("data.txt");
            // Add each new sale to the file instead of deleting the old sales.
            try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
                writer.write("DATA LOG\n********************************************\n");
                writer.write(report);
                writer.write("\n********************************************\n\n");
            }
            JOptionPane.showMessageDialog(this, report, "Message", JOptionPane.INFORMATION_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid price of zero or more.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Could not save data.txt: " + ex.getMessage());
        }
    }
    public static void main(String[] args) { SwingUtilities.invokeLater(() -> new ProductApp().setVisible(true)); }
}
