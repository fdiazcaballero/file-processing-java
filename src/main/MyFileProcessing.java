/*
 * Copyright (C) 2016 fernando.caballero
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package main;

import consumer.FileConsumer;
import injector.FileServiceInjector;
import injector.ServiceInjector;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernando.caballero
 */
public class MyFileProcessing {
    
    /**
     * Main method. It asks for the name of a file that needs to be entered through
     * the standard input and then press enter.
     * 
     * The location of the file needs to be the Sage folder.
     * 
     * @param args 
     */
    public static void main(String[] args) {
        
        try {            
            
            Scanner in = new Scanner(System.in);
            System.out.println("Enter the name of a file (the file must be in the Sage folder):");
            String fileName = in.nextLine();            
            
            ServiceInjector injector =  new FileServiceInjector();
            FileConsumer app = injector.getConsumer();
            
            FileReader fileReader = new FileReader(fileName);
            app.processFile(fileReader);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MyFileProcessing.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Caught Exception: " +  ex.getMessage());
        }
    }
    
}
