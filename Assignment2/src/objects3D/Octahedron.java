package objects3D;


import org.lwjgl.opengl.GL11;
import GraphicsObjects.Point4f;
import GraphicsObjects.Vector4f;

public class Octahedron {
	/*
	 * author: Yao Yuxiang(Leif)
	 * UCD NO.17205995
	 * Date:2019/10/07
	 * */
	
	public Octahedron()
	{
		
	}

	public void DrawOctahedron()
	{
		//vertices information
		Point4f[] vertices={
				new Point4f(-1.0f,0.0f,0.0f,0.0f),//0
				new Point4f(0.0f,1.0f,0.0f,0.0f),//1
				new Point4f(1.0f,0.0f,0.0f,0.0f),//2
				new Point4f(0.0f,0.0f,1.0f,0.0f),//3
				new Point4f(0.0f,0.0f,-1.0f,0.0f),//4
				new Point4f(0.0f,-1.0f,0.0f,0.0f),//5
		};

		//faces information
		int[][] faces = {
				{2,4,5},
				{2,3,5},
				{1,2,3},
				{1,2,4},
				{0,1,3},
				{0,1,4},
				{0,4,5},
				{3,0,5},
		};

		GL11.glBegin(GL11.GL_TRIANGLES);
		{
			for (int face = 0; face < faces.length; face++) { // per face
				Vector4f v = vertices[faces[face][1]].MinusPoint(vertices[faces[face][0]]);
				Vector4f w = vertices[faces[face][2]].MinusPoint(vertices[faces[face][0]]);
				Vector4f normal = v.cross(w).Normal();
				//calculate the normal vector
				GL11.glNormal3f(normal.x, normal.y, normal.z);
				//use the normal vector to determine the shade

				GL11.glVertex3f(vertices[faces[face][0]].x, vertices[faces[face][0]].y, vertices[faces[face][0]].z);
				GL11.glVertex3f(vertices[faces[face][1]].x, vertices[faces[face][1]].y, vertices[faces[face][1]].z);
				GL11.glVertex3f(vertices[faces[face][2]].x, vertices[faces[face][2]].y, vertices[faces[face][2]].z);
			}
		}
		GL11.glEnd();
	}
}
 