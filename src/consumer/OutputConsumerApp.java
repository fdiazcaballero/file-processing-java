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
package consumer;

import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.FileProcessingData;
import service.FileService;

/**
 *
 * @author fernando.caballero
 */
public class OutputConsumerApp implements FileConsumer{
    
    private FileService service;
    
    public OutputConsumerApp(FileService service){
        this.service=service;
    }    
    
    /**
     * 
     * @param inputStream
     */
    @Override
    public FileProcessingData processFile(Reader inputStream) {                  
        try {
            return this.service.processFile(inputStream);
        } catch (IOException ex) {
            Logger.getLogger(OutputConsumerApp.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }    
}
