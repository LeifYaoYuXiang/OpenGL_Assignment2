package objects3D;

import GraphicsObjects.Point4f;
import GraphicsObjects.Vector4f;
import org.lwjgl.opengl.GL11;

public class Sphere {

	
	public Sphere() {

	}
	// Implement using notes and examine Tetrahedron to aid in the coding  look at lecture  7 , 7b and 8 
	// 7b should be your primary source, we will cover more about circles in later lectures to understand why the code works 
	public void DrawSphere(float radius,float nSlices,float nSegments) {

		final float pi=(float) Math.PI;
		float inctheta= (2.0f*pi/nSlices);
		float incphi=(pi/nSegments);

		GL11.glBegin(GL11.GL_POINTS);
		for (float theta = -pi; theta<pi;theta=theta+inctheta ){
			for(float phi = -(pi/2);phi<pi/2;phi=phi+incphi){
				float x= (float) (radius*Math.cos(phi)*Math.cos(theta));
				float y=(float) (radius*Math.cos(phi)*Math.sin(theta));
				float z= (float) (radius*Math.sin(phi));
				GL11.glNormal3f(x,y,z);

				GL11.glVertex3f(x,y,z);
			}
		}
		GL11.glEnd();

	}



}

 