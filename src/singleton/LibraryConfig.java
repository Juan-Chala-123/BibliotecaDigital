/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singleton;

/**
 *
 * @author jhuan
 */
public class LibraryConfig {

    private static LibraryConfig instance;

    private String libraryName;
    private int maxLoans;
    private double baseFine;
    private String schedule;

    private LibraryConfig() {
        libraryName = "Biblioteca Digital";
        maxLoans = 3;
        baseFine = 200;
        schedule = "8AM - 4PM";
    }

    public static LibraryConfig getInstance() {
        if (instance == null) {
            instance = new LibraryConfig();
        }

        return instance;
    }

    public int getMaxLoans() {
        return maxLoans;
    }

    public String getLibraryName() {
        return libraryName;
    }
    
    public double getBaseFine() {
        return baseFine;
    }
}
