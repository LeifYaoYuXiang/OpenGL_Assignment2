package objects3D;

import org.lwjgl.opengl.GL11;
import GraphicsObjects.Point4f;
import GraphicsObjects.Vector4f;

public class Cube {

	
	public Cube() {

	}
	
	// Implement using notes and examine Tetrahedron to aid in the coding  look at lecture  7 , 7b and 8 
	public void DrawCube(){
		Point4f[] vertices={
				new Point4f(1.0f,1.0f,1.0f,0.0f),//0
				new Point4f(1.0f,1.0f,-1.0f,0.0f),//1
				new Point4f(1.0f,-1.0f,1.0f,0.0f),//2
				new Point4f(1.0f,-1.0f,-1.0f,0.0f),//3
				new Point4f(-1.0f,1.0f,1.0f,0.0f),//4
				new Point4f(-1.0f,1.0f,-1.0f,0.0f),//5
				new Point4f(-1.0f,-1.0f,1.0f,0.0f),//6
				new Point4f(-1.0f,-1.0f,-1.0f,0.0f),//7
		};

		int[][] faces={
				{0,4,1},
				{5,4,1},//Left Face
				{2,6,3},
				{7,6,3},//Right Face
				{6,4,2},
				{0,4,2},//Up Face
				{7,5,3},
				{1,5,3},//Bottom Face
				{2,0,3},
				{1,0,3},//Front Face
				{6,4,7},
				{5,4,7},//Back Face
		};

		GL11.glBegin(GL11.GL_TRIANGLES);
		for (int face = 0; face < faces.length; face++) { // per face
			Vector4f v = vertices[faces[face][1]].MinusPoint(vertices[faces[face][0]]);
			Vector4f w = vertices[faces[face][2]].MinusPoint(vertices[faces[face][0]]);
			Vector4f normal = v.cross(w).Normal();

			GL11.glNormal3f(normal.x, normal.y, normal.z);

			GL11.glVertex3f(vertices[faces[face][0]].x, vertices[faces[face][0]].y, vertices[faces[face][0]].z);
			GL11.glVertex3f(vertices[faces[face][1]].x, vertices[faces[face][1]].y, vertices[faces[face][1]].z);
			GL11.glVertex3f(vertices[faces[face][2]].x, vertices[faces[face][2]].y, vertices[faces[face][2]].z);

			face++;

			GL11.glVertex3f(vertices[faces[face][0]].x, vertices[faces[face][0]].y, vertices[faces[face][0]].z);
			GL11.glVertex3f(vertices[faces[face][1]].x, vertices[faces[face][1]].y, vertices[faces[face][1]].z);
			GL11.glVertex3f(vertices[faces[face][2]].x, vertices[faces[face][2]].y, vertices[faces[face][2]].z);

		} // per face
		GL11.glEnd();



	}
	
	
	
}
 
	/*
	 
	 
}

	*/
	 