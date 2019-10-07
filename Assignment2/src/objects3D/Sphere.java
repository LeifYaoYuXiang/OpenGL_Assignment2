package objects3D;

import GraphicsObjects.Point4f;
import GraphicsObjects.Vector4f;
import org.lwjgl.opengl.GL11;

public class Sphere {
	/*
	 * author: Yao Yuxiang(Leif)
	 * UCD NO.17205995
	 * Date:2019/10/07
	 * */
	
	public Sphere() {

	}
	public void DrawSphere(float radius,float nSlices,float nSegments) {

		final float pi=(float) Math.PI;
		//the step of theta
		float inctheta= (2.0f*pi/nSlices);
		//the step of phi
		float incphi=(pi/nSegments);

		//Begin to draw
		GL11.glBegin(GL11.GL_POINTS);
		{
			//this time we draw many points on the surface of a sphere to construct a sphere
			for (float theta = -pi; theta<pi;theta=theta+inctheta ){
				for(float phi = -(pi/2);phi<pi/2;phi=phi+incphi){
					//x=r*cos(phi)*cos(theta)
					float x= (float) (radius*Math.cos(phi)*Math.cos(theta));
					//y=r*cos(phi)*sin(theta)
					float y=(float) (radius*Math.cos(phi)*Math.sin(theta));
					//z=r*sin(phi)
					float z= (float) (radius*Math.sin(phi));

					//determine the shade of each point
					GL11.glNormal3f(x,y,z);
					//draw the point
					GL11.glVertex3f(x,y,z);
				}
			}
		}
		//End to draw
		GL11.glEnd();


	}



}

 