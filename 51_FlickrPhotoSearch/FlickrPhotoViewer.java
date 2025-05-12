import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.regex.*;

public class FlickrPhotoViewer extends JFrame {
    private JTextField searchField;
    private JPanel imagePanel;

    public FlickrPhotoViewer() {
        setTitle("Flickr Photo Search");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        searchField = new JTextField(30);
        JButton searchButton = new JButton("Search");

        topPanel.add(new JLabel("Photos about"));
        topPanel.add(searchField);
        topPanel.add(searchButton);
        add(topPanel, BorderLayout.NORTH);

        imagePanel = new JPanel(new FlowLayout());
        JScrollPane scrollPane = new JScrollPane(imagePanel);
        add(scrollPane, BorderLayout.CENTER);

        searchButton.addActionListener(e -> fetchPhotos(searchField.getText().trim()));
    }

    private void fetchPhotos(String query) {
        imagePanel.removeAll();
        if (query.isEmpty()) return;

        try {
            String encodedQuery = URLEncoder.encode(query, "UTF-8");
            String apiUrl = "https://www.flickr.com/services/feeds/photos_public.gne?format=json&nojsoncallback=1&tags=" + encodedQuery;

            URL url = URI.create(apiUrl).toURL();
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null)
                json.append(line);
            reader.close();

            Pattern pattern = Pattern.compile("\"media\":\\{\"m\":\"(.*?)\"}");
            Matcher matcher = pattern.matcher(json.toString());

            while (matcher.find()) {
                String imageUrl = matcher.group(1);
                ImageIcon imageIcon = new ImageIcon(URI.create(imageUrl).toURL());
                JLabel label = new JLabel(new ImageIcon(imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
                imagePanel.add(label);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error fetching photos: " + ex.getMessage());
        }

        imagePanel.revalidate();
        imagePanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FlickrPhotoViewer().setVisible(true));
    }
}
