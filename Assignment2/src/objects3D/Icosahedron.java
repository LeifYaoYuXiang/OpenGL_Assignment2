package objects3D;

import org.lwjgl.opengl.GL11;

import GraphicsObjects.Point4f;
import GraphicsObjects.Vector4f;

public class Icosahedron {
	/*
	 * author: Yao Yuxiang(Leif)
	 * UCD NO.17205995
	 * Date:2019/10/07
	 * */

	public Icosahedron() {
	}

	public void DrawIcosahedron() {
		final float X=0.525731112119133606f;
		final float Z=0.850650808352039932f;

		//vertices information
		Point4f[] vertices={
			new Point4f(-X, 0.0f, Z, 0.0f),//0
			new Point4f(X, 0.0f, Z, 0.0f ),//1
			new Point4f(-X, 0.0f, -Z, 0.0f),//2
			new Point4f(X, 0.0f, -Z, 0.0f),//3
			new Point4f(0.0f, Z, X, 0.0f),//4
			new Point4f(0.0f, Z, -X, 0.0f),//5
			new Point4f(0.0f, -Z, X, 0.0f),//6
			new Point4f(0.0f, -Z, -X, 0.0f),//7
			new Point4f(Z, X, 0.0f, 0.0f),//8
			new Point4f(-Z, X, 0.0f, 0.0f ),//9
			new Point4f(Z, -X, 0.0f, 0.0f ),//10
			new Point4f(-Z, -X, 0.0f, 0.0f),//11
		};

		//faces information
		int faces[][]={
			{ 0, 4, 1 },
			{ 0, 9, 4 },
			{ 9, 5, 4 },
			{ 4, 5, 8 },
			{ 4, 8, 1 },
			{ 8, 10, 1 },
			{ 8, 3, 10 },
			{ 5, 3, 8 },
			{ 5, 2, 3 },
			{ 2, 7, 3 },
			{ 7, 10, 3 },
			{ 7, 6, 10 },
			{ 7, 11, 6 },
			{ 11, 0, 6 },
			{ 0, 1, 6 },
			{ 6, 1, 10 },
			{ 9, 0, 11 },
			{ 9, 11, 2 },
			{ 9, 2, 5 },
			{ 7, 2, 11 }
		};

		GL11.glBegin(GL11.GL_TRIANGLES);
		//Begin to draw triangles
		{
			for(int face=0;face<faces.length;face++){
				Vector4f v = vertices[faces[face][1]].MinusPoint(vertices[faces[face][0]]);
				Vector4f w = vertices[faces[face][2]].MinusPoint(vertices[faces[face][0]]);
				Vector4f normal = v.cross(w).Normal();
				//calculate the normal vector
				GL11.glNormal3f(normal.x, normal.y, normal.z);
				//use the normal vector to determine the shade effect

				//draw the 3 vertex of one triangle
				GL11.glVertex3f(vertices[faces[face][0]].x, vertices[faces[face][0]].y, vertices[faces[face][0]].z);
				GL11.glVertex3f(vertices[faces[face][1]].x, vertices[faces[face][1]].y, vertices[faces[face][1]].z);
				GL11.glVertex3f(vertices[faces[face][2]].x, vertices[faces[face][2]].y, vertices[faces[face][2]].z);

			}
		}
		GL11.glEnd();
	 
	}
}
 