/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yoursites;

import java.io.Serializable;
import java.net.*;


public class Website implements Serializable{
    private String name;
    private URL address;
    private String category = "Misc.";
    private static final long serialVersionUID = 6529685098267757690L;
    
    public Website(String inOwner, String inAddress) throws MalformedURLException {
        this.name = inOwner;
        this.address = new URL(inAddress);
    }
    
    public Website(String inOwner, String inAddress, String inCategory) 
                throws MalformedURLException {
        this(inOwner, inAddress);
        category = inCategory;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getCatagory() {
        return this.category;
    }
    
    public String getAddress() {
        return this.address.toString();
    }
}
