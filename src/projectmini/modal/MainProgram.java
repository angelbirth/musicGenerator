package projectmini.modal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class MainProgram {
    
    private String artist;
    private String album;
    private String genre;
    private String year;
    private String comment;

    private String yearRegex = "[0-9]{4}";
    
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    public void simpan() {
        File output = new File(getArtist()+" - " + getAlbum() + ".txt");
        //FileOutputStream outputStream = new FileOutputStream(output);
        
        try {
            //File file = new File(getArtist()+" - " + getAlbum() + ".txt");
            FileWriter fileWriter = new FileWriter(output, true);//file, true);
            fileWriter.write(getArtist() + " - " + getAlbum() + "\nArtist : " 
                    + getArtist() + "\nAlbum : " + getAlbum() + "\nYear : " 
                    + getYear() + "\nComment : " + getComment());
            fileWriter.close();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan dengan nama " + output.getName());
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

}
