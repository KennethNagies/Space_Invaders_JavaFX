
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class Hitbox
{
	private Rectangle boundaries;
	private Sprite sprite;
	private Pane pane;

	Hitbox(double width,double height, Sprite sprite, Pane pane)
	{
		// Create a default hitbox with given dimensions at 0,0
		// Hitbox location will be bound in specific sprite class
		boundaries = new Rectangle(0, 0, width, height);
		this.sprite = sprite;
	}

	protected void checkCollision(Sprite sprite)
	{
		// Checks to see if any point within the given sprite's hitbox is within this hitbox
		if (boundaries.intersects(sprite.getHitbox().getBoundaries().getBoundsInLocal()))
		{
			// Calls the onCollide methods in both sprites
			this.sprite.onCollide(sprite);
			sprite.onCollide(this.sprite);
		}
	}

	protected Rectangle getBoundaries()
	{
		return boundaries;
	}

	protected Pane getPane()
	{
		return pane;
	}

	protected void setBoundaries(Rectangle boundaries)
	{
		this.boundaries = boundaries;
	}
}
