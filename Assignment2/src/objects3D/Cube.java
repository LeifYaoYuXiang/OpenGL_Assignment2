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
				new Point4f(1.0f,1.0f,1.0f,0.0f),//1
				new Point4f(1.0f,1.0f,-1.0f,0.0f),//2
				new Point4f(1.0f,-1.0f,-1.0f,0.0f),//3
				new Point4f(1.0f,-1.0f,1.0f,0.0f),//4
				new Point4f(-1.0f,1.0f,1.0f,0.0f),//5
				new Point4f(-1.0f,1.0f,-1.0f,0.0f),//6
				new Point4f(-1.0f,-1.0f,-1.0f,0.0f),//7
				new Point4f(-1.0f,-1.0f,1.0f,0.0f),//8
		};

		int[][] faces={
				{},
				{},
				{}};



	}
	
	
	
}
 
	/*
	 
	 
}

	*/
	 