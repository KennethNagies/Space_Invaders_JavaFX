/*
 * LIKE ALIEN, BUT IT CAN ONLY MOVE ONE DIRECTION
 */
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Shot extends Sprite
{
	private int direction;
	private Sprite parent;

	public Shot(Sprite sprite, int direction, Pane pane)
	{
		// Creates the images and hitbox for the shot
		super(2, 8, new Image("/Sprites/PlayerShot.png", 2, 8, false, false), new Image("/Sprites/PlayerShot.png", 2, 8, false, false), pane);
		body = new ImageView(image1);
		offsetY = -36 * direction;
		// Binds the x property to the center of the sprite that shot it
		body.xProperty().bind(pane.widthProperty().divide(2).add(sprite.getOffsetX()).add(sprite.getHitbox().getBoundaries().getWidth()/2));
		// Binds the y Property to either 36 pixels above or below the center of the sprite (depending on direction fired)
		body.yProperty().bind(sprite.body.yProperty().add(sprite.hitbox.getBoundaries().getHeight()/2).add(offsetY));
		// Same as sprite, but for hitbox
		hitbox.getBoundaries().xProperty().bind(pane.widthProperty().divide(2).add(sprite.getOffsetX()).add(sprite.getHitbox().getBoundaries().getWidth()/2));
		hitbox.getBoundaries().yProperty().bind(sprite.body.yProperty().add(sprite.hitbox.getBoundaries().getHeight()/2).add(offsetY));
		// Adds the hitbox and the sprite to the pane's children
		pane.getChildren().add(hitbox.getBoundaries());
		pane.getChildren().add(body);
		parent = sprite;
		this.direction = direction;
	}


	protected void onCollide(Sprite sprite)
	{
		// if it hits any sprite, destroy the shot
		kill();
	}

	public void kill()
	{
		// remove the hitbox and the sprite from the pane's children
		pane.getChildren().remove(hitbox.getBoundaries());
		pane.getChildren().remove(body);
		// moves the hitbox off screen to avoid collision
		hitbox.getBoundaries().xProperty().bind(pane.widthProperty().subtract(pane.widthProperty()).add(100));
		alive = false;
	}

	public void move()
	{
		// moves the sprite and hitbox up or down depending on direction
		int speed = 8;
		offsetY -= (direction * speed);
		body.yProperty().bind(parent.body.yProperty().add(parent.hitbox.getBoundaries().getHeight() / 2).add(offsetY));
		hitbox.getBoundaries().yProperty().bind(parent.body.yProperty().add(parent.hitbox.getBoundaries().getHeight() / 2).add(offsetY));
	}

	public int getDirection()
	{
		return direction;
	}

	public void addOffset(int x, int y)
	{
		offsetX += x;
		offsetY += y;

		body.xProperty().bind(pane.widthProperty().divide(2).add(parent.getOffsetX()).add(parent.getHitbox().getBoundaries().getWidth()/2));
		// Binds the y Property to either 36 pixels above or below the center of the sprite (depending on direction fired)
		body.yProperty().bind(parent.body.yProperty().add(parent.hitbox.getBoundaries().getHeight()/2).add(offsetY));
		// Same as sprite, but for hitbox
		hitbox.getBoundaries().xProperty().bind(pane.widthProperty().divide(2).add(parent.getOffsetX()).add(parent.getHitbox().getBoundaries().getWidth()/2));
		hitbox.getBoundaries().yProperty().bind(parent.body.yProperty().add(parent.hitbox.getBoundaries().getHeight()/2).add(offsetY));
	}
}
