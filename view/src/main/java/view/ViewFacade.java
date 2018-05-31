package view;

import java.util.List;

import javax.swing.JOptionPane;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade implements IView {

    /**
     * Instantiates a new view facade.
     */
    public ViewFacade() {
        super();
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
	public void createUI(int height, int width) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setScore(int score) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLevelName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refreshModelData(List<List<String>> sprites) {
		// TODO Auto-generated method stub
		
	}

}
