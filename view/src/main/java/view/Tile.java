package view;

import java.awt.Image;
import java.io.IOException;

import showboard.ISquare;
import javax.imageio.ImageIO;



/**
 * <h1>The Class Square.</h1>
 *
 * @author Anne-Emilie DIET
 * @version 1.0
 */
public class Tile implements ISquare {

    /** The image. */
    private Image  image;

    /** The image name. */
    private String imageName;

    /**
     * Instantiates a new square.
     *
     * @param imageName the image name
     */
    public Tile(final String imageName) {
        this.setImageName(imageName);
    }

    /**
     * Gets the image.
     *
     * @return the image
     */
    /*
     * (non-Javadoc)
     * @see fr.exia.showboard.ISquare#getImage()
     */
    @Override
    public final Image getImage() {
        return this.image;
    }

    /**
     * Load image.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public final void loadImage() throws IOException {
        this.setImage(ImageIO.read(this.getClass().getResource("/sprites/" + this.getImageName() + ".png")));
    }

    /**
     * Sets the image.
     *
     * @param image the new image
     */
    private void setImage(final Image image) {
        this.image = image;
    }

    /**
     * Gets the image name.
     *
     * @return the image name
     */
    public String getImageName() {
        return this.imageName;
    }

    /**
     * Sets the image name.
     *
     * @param imageName the imageName to set
     */
    private void setImageName(final String imageName) {
        this.imageName = imageName;
    }

}
