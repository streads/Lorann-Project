package view;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.EUserOrder;
import controller.IController;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Hugo Peterhansel
 * @version 1.0
 */

public class ViewFacade implements IView   {
	
	private int tileRow, tileColumn;
	private int elementSize = 32;
	
	private List<Tile> tiles = new ArrayList<Tile>(); 
	private Frame window = null;
	private JLabel[][] jlabels = new JLabel[100][100];
	private String score, level;
    /**
     * Access point to the controller
     */
	private IController controller;
	
    /**
     * Instantiates a new view facade.
     */
    public ViewFacade() {
        super();
        loadTile();

        
    }
    
    public void loadTile() {
        // we should use a loop in folder path to add automatically image
        
        //load bone sprites
        tiles.add(new Tile("black"));
        tiles.add(new Tile("bone_0"));
        tiles.add(new Tile("bone_1"));
        tiles.add(new Tile("bone_2"));   
        tiles.add(new Tile("kyracj_0")); // load monster sprites
        tiles.add(new Tile("cargyv_0"));
        tiles.add(new Tile("arrbarr_0"));
        tiles.add(new Tile("maarcg_0"));
        tiles.add(new Tile("fireball_0")); // load power sprites
        tiles.add(new Tile("fireball_1"));
        tiles.add(new Tile("fireball_2"));
        tiles.add(new Tile("fireball_3"));
        tiles.add(new Tile("fireball_4"));
        tiles.add(new Tile("lorann_0")); // load lorann sprites
        tiles.add(new Tile("lorann_1"));
        tiles.add(new Tile("lorann_2"));
        tiles.add(new Tile("lorann_3"));
        tiles.add(new Tile("lorann_4"));
        tiles.add(new Tile("lorann_5"));
        tiles.add(new Tile("lorann_6"));
        tiles.add(new Tile("lorann_7"));
        tiles.add(new Tile("crystalBall_0")); // load the others sprites
        tiles.add(new Tile("door_0"));
        tiles.add(new Tile("door_1"));
        tiles.add(new Tile("purse_0"));

        
        try {
        for (Tile tile : tiles) {
        	tile.loadImage();
			
		}
        }catch(Exception ex) {
        	System.err.println("Can't load images");
        }
    }
    
    public Dimension getDimension() {
    	return new Dimension(tileRow, tileColumn);
    }
    /**
     * Set the value of the controller inside the View
     */
    @Override
	public void setController(IController controller)
	{
		this.controller = controller;
	}

    /*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
    
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }

	@Override
	public void createUI(int tileColumn, int tileRow) {
		window = new Frame("Lorann", controller);
		window.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (controller != null) {
					switch (e.getKeyCode())
				    {
				    	case KeyEvent.VK_UP:
				    		
				    		controller.orderPerformer(EUserOrder.TOP);
				    		break;
				    	case KeyEvent.VK_DOWN:
				    		controller.orderPerformer(EUserOrder.BOTTOM);
				            break;
				    	case KeyEvent.VK_LEFT:
				    		controller.orderPerformer(EUserOrder.LEFT);
				            break;
				    	case KeyEvent.VK_RIGHT:
				    		controller.orderPerformer(EUserOrder.RIGHT);
				            break;
				    	case KeyEvent.VK_SPACE:
				    		controller.orderPerformer(EUserOrder.SPELLCAST);
				            break;
				    	default:
				    		controller.orderPerformer(EUserOrder.NOP);
				    		break;
				    }
				}
				
			}
		});
		window.setSize(new Dimension( (tileColumn) * elementSize + 20, (tileRow) * elementSize + 50));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int i = 0;
		int j = 0;
		for (i = 0; i < tileColumn; i++) {
			for (j = 0; j < tileRow; j++) {
				
				JLabel label = new JLabel("?");
				label.setVisible(true);
				label.setSize(new Dimension(elementSize,elementSize));
				label.setLocation(new Point(i * elementSize, j * elementSize));
				window.add(label);
				jlabels[i][j] = label;
			}
		}
		
		JLabel label = new JLabel("?");
		label.setVisible(true);
		label.setSize(new Dimension(elementSize,elementSize));
		label.setLocation(new Point(i * elementSize, j * elementSize));
		window.add(label);
		
		window.setVisible(true);
		window.repaint();
		
			
		
	}

	@Override
	public void setScore(int score) {
		// TODO Auto-generated method stub
		this.score = Integer.toString(score);
	}

	@Override
	public void setLevelName(String name) {
		// TODO Auto-generated method stub
		this.level = name;
	}
	
	/* (non-Javadoc)
	 * @see view.IView#refreshModelData(java.util.List)
	 */
	@Override
	public void refreshModelData(String[][] elementsTags) {
		window.setTitle("Lorann [" + this.level + "] score: " + this.score);
		for (int x = 0; x < 20; x++) {
			for (int y = 0; y < 12 ; y++) {
				if(elementsTags[x][y] == null) {
					jlabels[x][y].setIcon(new ImageIcon(tiles.get(0).getImage()));
					
				}else {
					for (Tile tile : tiles) {
						if(tile.getImageName().contentEquals(elementsTags[x][y])) {
							jlabels[x][y].setIcon(new ImageIcon(tile.getImage()));
						}
					}
					
				}
			}
		}
		

		

		window.repaint();
	}
	
	public Frame getFrame() {
		return null;
	}
}

