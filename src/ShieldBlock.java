/*
 * 	CREATES A SHIELD BLOCK BASED ON TYPE AND OFFSETS
 */
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Creates the individual blocks that make up the Shield
 * @author Kenneth Nagies
 * @version September 2, 2016
 *
 */
public class ShieldBlock extends Sprite
{


    /**
     * Creates a shield block based on the type and location given
     * @param type gives the type of shield block to draw
     * @param offsetX the offset
     * @param localOffsetX the local offset from the corner of the shield
     * @param localOffsetY the offset in the y from the corner of the shield
     * @param pane the pane to be drawn to
     */
	public ShieldBlock(int type, int offsetX, int localOffsetX, int localOffsetY, Pane pane)
	{
		// initializes a shield block of type 1
		super(8, 8, new Image("/Sprites/ShieldBlock_1.png", 8, 8, false, false), new Image("/Sprites/ShieldBlock_1.png", 8, 8, false, false), pane);

		// change the image to be of a type that is not 1 if necessary
		if(type != 1)
		{
			image1 = new Image("/Sprites/ShieldBlock_" + type + ".png", 8, 8, false, false);
		}

		// set the body to an ImageView of the image
		body = new ImageView(image1);

		this.offsetX = offsetX;

		// binds the sprite to locations based on its global and local offsets
		body.xProperty().bind(pane.widthProperty().subtract(pane.widthProperty()).add(112).add(offsetX).add(localOffsetX));
		body.yProperty().bind(pane.heightProperty().subtract(150).add(localOffsetY));

		// binds the hitbox to the same locations as above
		hitbox.getBoundaries().xProperty().bind(pane.widthProperty().subtract(pane.widthProperty()).add(112).add(offsetX).add(localOffsetX));
		hitbox.getBoundaries().yProperty().bind(pane.heightProperty().subtract(150).add(localOffsetY));

		pane.getChildren().add(hitbox.getBoundaries());
		pane.getChildren().add(body);
	}

	protected void onCollide(Sprite sprite)
	{
		// if hit by any sprite, it is destroyed
		kill();
	}

	/**
	 * Kills the block
	 */
	public void kill()
	{
		// remove the hitbox and the sprite from the pane's children
		pane.getChildren().remove(hitbox.getBoundaries());
		pane.getChildren().remove(body);
		// moves the hitbox off screen to avoid collision
		hitbox.getBoundaries().xProperty().bind(pane.widthProperty().subtract(pane.widthProperty()).add(100));
		alive = false;
	}
}
