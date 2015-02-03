package projectmini.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.FileReader;
import javax.swing.*;

public class MainFrame extends JFrame {

	private JLabel headerLabel, artistLabel, titleLabel, composerLabel,
			yearLabel, genreLabel, commentLabel, albumLabel;
	private JTextField artistText, titleText, composerText, yearText,
			albumText, genreText, commentText;
	private JButton generateButton, exitButton, aboutUsButton;

	private Font textField = new Font("Trebuchet MS", Font.PLAIN, 12);
	private Font header = new Font("Trebuchet MS", Font.BOLD, 16);

	public MainFrame() {

		headerLabel = new JLabel("VMuliadi Music Album Generator");
		headerLabel.setBounds(25, 25, 425, 25);
		headerLabel.setFont(header);
		add(headerLabel);

		artistLabel = new JLabel("Artist");
		artistLabel.setBounds(25, 60, 75, 25);
		artistLabel.setFont(textField);
		add(artistLabel);

		artistText = new JTextField();
		artistText.setFont(textField);
		artistText.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		artistText.setBounds(100, 60, 370, 25);
		add(artistText);

		albumLabel = new JLabel("Album Title");
		albumLabel.setBounds(25, 95, 75, 25);
		albumLabel.setFont(textField);
		add(albumLabel);

		albumText = new JTextField();
		albumText.setFont(textField);
		albumText.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		albumText.setBounds(100, 95, 370, 25);
		add(albumText);

		genreLabel = new JLabel("Genre");
		genreLabel.setBounds(25, 130, 75, 25);
		genreLabel.setFont(textField);
		add(genreLabel);

		genreText = new JTextField();
		genreText.setFont(textField);
		genreText.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		genreText.setBounds(100, 130, 370, 25);
		add(genreText);

		yearLabel = new JLabel("Year");
		yearLabel.setBounds(25, 165, 75, 25);
		yearLabel.setFont(textField);
		add(yearLabel);

		yearText = new JTextField();
		yearText.setFont(textField);
		yearText.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		yearText.setBounds(100, 165, 370, 25);
		add(yearText);

		commentLabel = new JLabel("Comment");
		commentLabel.setFont(textField);
		commentLabel.setBounds(25, 200, 75, 25);
		add(commentLabel);

		commentText = new JTextField();
		commentText.setFont(textField);
		commentText.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		commentText.setBounds(100, 200, 370, 25);
		add(commentText);

		generateButton = new JButton("GENERATE");
		// generateButton.addActionListener(this);
		generateButton.setBounds(25, 235, 445, 50);
		generateButton.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		add(generateButton);

		exitButton = new JButton("EXIT");
		// exitButton.addActionListener(this);
		exitButton.setBounds(25, 295, 445, 50);
		exitButton.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		add(exitButton);

		aboutUsButton = new JButton("ABOUT ME");
		// aboutUsButton.addActionListener(this);
		aboutUsButton.setBounds(25, 355, 445, 50);
		aboutUsButton.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		add(aboutUsButton);

		setLayout(null);
		// statement below is not a good practice, commenting out. use a Main
		// class instead.
		// setVisible(true);
		setSize(500, 465);
		setTitle("Album Detail Generator");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// ** EVENT LISTENERS
		{
			generateButton.addActionListener(generateButton_actionListener);
			aboutUsButton.addActionListener(aboutUsButton_actionListener);
			exitButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		// END EVENT LISTENERS **/
	}

	// commenting this one, sorry. use "1 component<=>1 listener" model

	/*
	 * @Override public void actionPerformed(ActionEvent e) {
	 * 
	 * if (e.getSource() == generateButton) { String artist =
	 * artistText.getText(); String album = albumText.getText(); String genre =
	 * genreText.getText(); String year = yearText.getText(); String comment =
	 * commentText.getText();
	 * 
	 * File output = new File(artist + " - " + album + ".txt"); if
	 * (!output.exists()) { try { output.createNewFile(); } catch (Exception ex)
	 * { ex.printStackTrace(); } }
	 * 
	 * try { File file = new File(artist + " - " + album + ".txt"); FileWriter
	 * fileWriter = new FileWriter(file, true); fileWriter.write(artist + " - "
	 * + album + "\nCreated by VMuliadi" +
	 * " Album Generator\n\nAlbum Description" +
	 * "\n================\nArtist\t: " + artist + "\nAlbum\t: " + album +
	 * "\nGenre\t: " + genre + "\nYear\t: " + year + "\nComment : " + comment +
	 * "\n\nFeature\n=======" + "\nBit Rate : 320 Kbps" + "\nFull Cover Art" +
	 * "\n\nContact\n=======\nadmin@max-metal.us"); fileWriter.close();
	 * JOptionPane.showMessageDialog(null, "File saved. Filename : " + artist +
	 * " - " + album + ".txt"); } catch (Exception ex) { ex.printStackTrace(); }
	 * }
	 * 
	 * if (e.getSource() == aboutUsButton) { JOptionPane.showMessageDialog(null,
	 * "https://github.com/MaX121"); JOptionPane.showMessageDialog(null,
	 * "Created by Vinsen Muliadi"); }
	 * 
	 * if (e.getSource() == exitButton) { System.exit(0); }
	 * 
	 * }
	 */
	private final ActionListener generateButton_actionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String artist = artistText.getText();
			String album = albumText.getText();
			String genre = genreText.getText();
			String year = yearText.getText();
			String comment = commentText.getText();

			File output = new File(artist + " - " + album + ".txt");
			if (!output.exists()) { // is this block necessary? do you have to
									// check if it exists and create it if it
									// doesn't?
				try {
					output.createNewFile();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

			try {
				File file = new File(artist + " - " + album + ".txt");
				FileWriter fileWriter = new FileWriter(file, true);
				fileWriter.write(artist + " - " + album
						+ "\nCreated by VMuliadi"
						+ " Album Generator\n\nAlbum Description"
						+ "\n================\nArtist\t: " + artist
						+ "\nAlbum\t: " + album + "\nGenre\t: " + genre
						+ "\nYear\t: " + year + "\nComment : " + comment
						+ "\n\nFeature\n=======" + "\nBit Rate : 320 Kbps"
						+ "\nFull Cover Art"
						+ "\n\nContact\n=======\nadmin@max-metal.us");
				fileWriter.close();
				JOptionPane.showMessageDialog(null, "File saved. Filename : "
						+ artist + " - " + album + ".txt");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	};

	private final ActionListener aboutUsButton_actionListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "https://github.com/MaX121");
			JOptionPane.showMessageDialog(null, "Created by Vinsen Muliadi");
		}
	};
}
