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

		GL11.glBegin(GL11.GL_QUADS);
		{
			for(float theta = -pi; theta<pi;theta=theta+inctheta){
				for(float phi = -(pi/2);phi<pi/2;phi=phi+incphi){
					/*
					* Basic Idea:
					* 	x=r*cos(phi)*cod(theta)
					* 	y=r*cos(phi)*sin(theta)
					* 	z=r*sin(phi)
					* */

					//Draw the first point
					float x= (float) (radius*Math.cos(phi)*Math.cos(theta));
					float y=(float) (radius*Math.cos(phi)*Math.sin(theta));
					float z= (float) (radius*Math.sin(phi));
					GL11.glNormal3f(x,y,z);
					GL11.glVertex3f(x,y,z);

					//Draw the second point
					float x_step_phi=(float) (radius*Math.cos(phi+incphi)*Math.cos(theta));
					float y_step_phi=(float) (radius*Math.cos(phi+incphi)*Math.sin(theta));
					float z_step_phi=(float) (radius*Math.sin(phi+incphi));
					GL11.glNormal3f(x_step_phi,y_step_phi,z_step_phi);
					GL11.glVertex3f(x_step_phi,y_step_phi,z_step_phi);

					//Draw the third point
					float x_step_theta_phi=(float) (radius*Math.cos(phi+incphi)*Math.cos(theta+inctheta));
					float y_step_theta_phi=(float) (radius*Math.cos(phi+incphi)*Math.sin(theta+inctheta));
					float z_step_theta_phi=(float) (radius*Math.sin(phi+incphi));
					GL11.glNormal3f(x_step_theta_phi,y_step_theta_phi,z_step_theta_phi);
					GL11.glVertex3f(x_step_theta_phi,y_step_theta_phi,z_step_theta_phi);

					//Draw the forth point
					float x_step_theta=(float) (radius*Math.cos(phi)*Math.cos(theta+inctheta));
					float y_step_theta=(float) (radius*Math.cos(phi)*Math.sin(theta+inctheta));
					float z_step_theta=(float) (radius*Math.sin(phi));
					GL11.glNormal3f(x_step_theta,y_step_theta,z_step_theta);
					GL11.glVertex3f(x_step_theta,y_step_theta,z_step_theta);
				}
			}

		}
		//Finish Drawing
		GL11.glEnd();

	}



}

 