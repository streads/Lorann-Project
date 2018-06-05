package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import controller.ControllerFacade;
import model.ModelFacade;
import view.ViewFacade;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Thibault Hanna thibault.hanna@viacesi.fr
 * @version 1.0
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
    	int level = 2;
 
        try {
        	File levelSelector = new File(System.getenv("APPDATA") +"\\"+ "lorannLevel.txt");   
        	FileInputStream fis;
			fis = new FileInputStream(levelSelector);
			byte[] data = new byte[(int) levelSelector.length()];
        	fis.read(data);
        	fis.close();
        	String str = new String(data, "UTF-8");
        	level = Integer.parseInt(str);
        } catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}
       
    	ViewFacade view = new ViewFacade();
        final ControllerFacade controller = new ControllerFacade(view, new ModelFacade());
        view.setController(controller);
        controller.setLevel(level);
        controller.start();
    }

}
