/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yoursites;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;

public class WebsiteFileOperator {

    
//  Read file and return ArrayList of Website objects    
    public static ArrayList<Website> readFile(Label b)  {
        ArrayList<Website> list = new ArrayList<>();
        try {
            InputStream in = WebsiteFileOperator.class.getResourceAsStream("/website.dat");
            ObjectInputStream input = new ObjectInputStream(in);
           try {
                while(true) {
                    list.add((Website) input.readObject());
                }
           } catch (OptionalDataException e) {
               if (!e.eof) throw e;
           } catch (EOFException eof) {
               // This is expected
           } finally {
               input.close();
           }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WebsiteFileOperator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) { 
            Logger.getLogger(WebsiteFileOperator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WebsiteFileOperator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    } 
//  This method currently creates a file. However, it will be used later when an 
//  add website button feature is added in the future.
    public static void writeFile(Label b) {  
        ObjectOutputStream writer = null;
        try {
            writer = new ObjectOutputStream(new FileOutputStream("website.dat"));
            writer.writeObject(new Website("Yahoo", "https://www.yahoo.com", "News"));
            writer.writeObject(new Website("USNews", "https://www.usnews.com/news", "News"));
            writer.writeObject(new Website("Fox Sports", "http://www.foxsports.com/", "Sports"));
            writer.writeObject(new Website("TechCrunch", "https://techcrunch.com/", "Tech"));
            writer.writeObject(new Website("tutorialspoint", "http://www.tutorialspoint.com/", "Coding"));
            writer.writeObject(new Website("IGN", "http://www.ign.com/", "Misc."));

            writer.close();
            b.setText("Data was saved.");
        } catch (IOException e) {
            b.setText("Could not wrtie to file.");
        } 
    }
}
