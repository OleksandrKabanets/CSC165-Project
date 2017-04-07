package csc165_lab3;

/* This class allows movement of the View camera around its V axis, 
 * the same as the Left/Right arrow keys.
 */

import sage.input.action.AbstractInputAction;
import sage.scene.SceneNode;
import graphicslib3D.Matrix3D;
import graphicslib3D.Point3D;
import graphicslib3D.Vector3D;
import net.java.games.input.Event;
import sage.camera.ICamera;

public class MoveZAxis extends AbstractInputAction {
	private float speed;
	private SceneNode avatar;

	public MoveZAxis(SceneNode avatar, float spd) {
		this.avatar = avatar;
		speed = spd;
	}

	@Override
	public void performAction(float time, Event event) {
		Matrix3D rot = avatar.getLocalRotation();
		Vector3D dir = new Vector3D(0, 0, 1);
		dir = dir.mult(rot);

		if (event.getValue() < -0.2) {
			dir.scale(speed * time * -1);
			avatar.translate((float) dir.getX(), (float) dir.getY(), (float) dir.getZ());
		} else {
			if (event.getValue() > 0.2) {
				dir.scale(speed * time);
				avatar.translate((float) dir.getX(), (float) dir.getY(), (float) dir.getZ());
			}
		}
	}
}