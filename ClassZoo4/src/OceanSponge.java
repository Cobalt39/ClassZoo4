import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class OceanSponge extends Applet implements KeyListener  {
	Polygon RArm= new Polygon();
	Polygon LArm= new Polygon();
	Polygon RLeg= new Polygon();
	Polygon LLeg= new Polygon();
	Polygon LShoulder =new Polygon();
	Polygon RShoulder =new Polygon();
	Polygon LSock = new Polygon();
	Polygon RSock =new Polygon();
	Polygon LRStripe = new Polygon();
	Polygon RRStripe = new Polygon();
	Polygon LBStripe = new Polygon();
	Polygon RBStripe = new Polygon();
	Polygon RShoe = new Polygon();
	Polygon LShoe = new Polygon();
	 Graphics Spongebob;
	 String Dir;
	public void init(){
		addKeyListener( this );
	}
	
	
	public void paint(Graphics g){
		drawHabitat(g);
		drawAnimal(g, 'N');
		getWidth();
		getHeight();
		
	}
	
	public void keyPressed(KeyEvent arg0) {
		Character key=arg0.getKeyChar();
		if(key=='A' || key=='a'||key=='d'||key=='D'||key=='W'||key=='w'||key=='s'||key=='S'){
			//System.out.println(key);
			drawAnimal(Spongebob ,key);
		}
				
		
	}
	 int x=0;
	 int y=0;
	 int width=0;
	 int height=0;
	 
	private void drawAnimal(Graphics g,Character key)
	{
		Spongebob=g.create();
		Spongebob.setColor(new Color(155,155,255));
		Spongebob.fillPolygon(RArm);
		Spongebob.fillPolygon(LArm);
		Spongebob.fillPolygon(RLeg);
		Spongebob.fillPolygon(LLeg);
		Spongebob.fillPolygon(LShoulder);
		Spongebob.fillPolygon(RShoulder);
		Spongebob.fillPolygon(LShoe);
		Spongebob.fillPolygon(RShoe);
		Spongebob.fillRect(x-width, y-height, width, height);
		if(key=='N'){
		  width=getWidth()/5;
		  height=getHeight()/5;
		  x=getWidth();
		  y=getHeight()-((int)(height*.25));
		  Dir="";
		}else if(key=='A'||key=='a'){
		x-=5;
		Dir="Left";
		}else if(key=='D'||key=='d'){
			x+=5;
			Dir="Right";
		}else if(key=='w'||key=='W'){
			y-=5;
			Dir="Up";
		}else if(key=='s'||key=='S'){
			y+=5;
			Dir="Down";
		}
		
		if(x<=0-width){
			 x=(int)getWidth()-5;
		}else if(x>=(int)getWidth()+width){
			x=0+5;
		}else if(y<=0-height){
			 y=(int)getHeight();;
		}else if(y>=(int)getHeight()+height){
			 y=height;
		}
		Spongebob.setColor(Color.yellow);
		Spongebob.fillRect(x-width, y-height, width, height);
		draw_Inside();
	}
	//			Spongebob.fillOval((x-width)+(int)Math.random()*10, (y-height)+(int)Math.random()*10, 10, 10);
	private void drawHabitat(Graphics g)
	{
		g.setColor(new Color(155,155,255));
		g.fillRect(0,0,getWidth(),getHeight());
	}
	public void draw_Inside()
	{

		Spongebob.setColor(new Color(204,204,0));
		for(int i=0;i<=50;i++){
		int size=(int)(Math.random()*(width/10));
		Spongebob.fillOval((x-width)+(int)(Math.random()*(width-size)), (y-height)+(int)(Math.random()*(height-size)), size, size);
		}
		Spongebob.setColor(new Color(255,255,255));
		Spongebob.fillOval((x-width)+width/5, (y-height)+width/5, width/5, height/5);
		Spongebob.fillOval((x-width)+width/2, (y-height)+width/5, width/5, height/5);
		Spongebob.setColor(Color.blue);
		if(Dir=="Right"){
		Spongebob.fillOval((x-width)+width/5+(width/10), (y-height)+(int)(width*0.25), width/10, height/10);
		Spongebob.fillOval((x-width)+width/2+(width/10), (y-height)+(int)(width*0.25), width/10, height/10);
		Spongebob.setColor(new Color(0,200,0));
		Spongebob.drawOval((x-width)+width/5+(width/10), (y-height)+(int)(width*0.25), width/10, height/10);
		Spongebob.drawOval((x-width)+width/2+(width/10), (y-height)+(int)(width*0.25), width/10, height/10);
		}else if(Dir=="Left"){
		Spongebob.fillOval((x-width)+width/5+(width/150), (y-height)+(int)(width*0.25), width/10, height/10);
		Spongebob.fillOval((x-width)+width/2+(width/150), (y-height)+(int)(width*0.25), width/10, height/10);
		Spongebob.setColor(new Color(0,200,0));
		Spongebob.drawOval((x-width)+width/5+(width/150), (y-height)+(int)(width*0.25), width/10, height/10);
		Spongebob.drawOval((x-width)+width/2+(width/150), (y-height)+(int)(width*0.25), width/10, height/10);
		}else if(Dir=="Up"){
		Spongebob.fillOval((x-width)+(int)(width*.45)+(width/10), (y-height)+(int)(width*0.2), width/10, height/10);
		Spongebob.fillOval((x-width)+(int)(width*.15)+(width/10), (y-height)+(int)(width*0.2), width/10, height/10);
		Spongebob.setColor(new Color(0,200,0));
		Spongebob.drawOval((x-width)+(int)(width*.45)+(width/10), (y-height)+(int)(width*0.2), width/10, height/10);
		Spongebob.drawOval((x-width)+(int)(width*.15)+(width/10), (y-height)+(int)(width*0.2), width/10, height/10);
		}else if(Dir=="Down"){
		Spongebob.fillOval((x-width)+(int)(width*.45)+(width/10), (y-height)+(int)(width*0.3), width/10, height/10);
		Spongebob.fillOval((x-width)+(int)(width*.15)+(width/10), (y-height)+(int)(width*0.3), width/10, height/10);
		Spongebob.setColor(new Color(0,200,0));
		Spongebob.drawOval((x-width)+(int)(width*.45)+(width/10), (y-height)+(int)(width*0.3), width/10, height/10);
		Spongebob.drawOval((x-width)+(int)(width*.15)+(width/10), (y-height)+(int)(width*0.3), width/10, height/10);
		}else{
			Spongebob.fillOval((x-width)+(int)(width*.45)+(width/10), (y-height)+(int)(width*0.25), width/10, height/10);
			Spongebob.fillOval((x-width)+(int)(width*.15)+(width/10), (y-height)+(int)(width*0.25), width/10, height/10);
			Spongebob.setColor(new Color(0,200,0));
			Spongebob.drawOval((x-width)+(int)(width*.45)+(width/10), (y-height)+(int)(width*0.25), width/10, height/10);
			Spongebob.drawOval((x-width)+(int)(width*.15)+(width/10), (y-height)+(int)(width*0.25), width/10, height/10);
		}
		//Spongebob.fillOval(x-width, y-height+(height/5), 10, 10);
		LArm.reset();
		LArm.addPoint(x-(int)(width*1.5), y-(int)(height/2)+(width/10));
		LArm.addPoint(x-(int)(width/1.25), y-(int)(height/1.25)+(height/10));
		LArm.addPoint(x-(int)(width/1.25), y-(int)(height/1.25));
		LArm.addPoint(x-(int)(width*1.5), y-(int)(height/2));
		LShoulder.reset();
		double YRocoSh=0.45;
		LShoulder.addPoint(x-width, y-(int)(height*YRocoSh));
		LShoulder.addPoint(x-width-(int)(width*.15), y-(int)(height*YRocoSh));
		LShoulder.addPoint(x-width-(int)(width*.15),y-(int)(height*(YRocoSh-0.1)));
		LShoulder.addPoint(x-width, y-(int)(height*(YRocoSh-0.1)));
		////////////////////////////////////////////////////
		double YLocoSh=0.45;
		RShoulder.reset();
		RShoulder.addPoint(x, y-(int)(height*YLocoSh));
		RShoulder.addPoint(x+(int)(width*.15), y-(int)(height*YLocoSh));
		RShoulder.addPoint(x+(int)(width*.15),y-(int)(height*(YLocoSh-0.1)));
		RShoulder.addPoint(x, y-(int)(height*(YLocoSh-0.1)));
		///////////////////Legs/////////////////////////////
		LLeg.reset();
		LLeg.addPoint(x-((int)(width*.2)), y);
		LLeg.addPoint(x-((int)(width*.2)), y+((int)(width*.4)));
		LLeg.addPoint(x-((int)(width*.3)), y+((int)(width*.4)));
		LLeg.addPoint(x-((int)(width*.3)), y);
		RLeg.reset();
		
		RLeg.addPoint(x-((int)(width*.7)), y);
		RLeg.addPoint(x-((int)(width*.7)), y+((int)(width*.4)));
		RLeg.addPoint(x-((int)(width*.8)), y+((int)(width*.4)));
		RLeg.addPoint(x-((int)(width*.8)), y);
		RSock.reset();
		
		RSock.addPoint(x-((int)(width*.7)), y+((int)(width*.1)));
		RSock.addPoint(x-((int)(width*.7)), y+((int)(width*.4)));
		RSock.addPoint(x-((int)(width*.8)), y+((int)(width*.4)));
		RSock.addPoint(x-((int)(width*.8)), y+((int)(width*.1)));
		LSock.reset();
		
		LSock.addPoint(x-((int)(width*.2)), y+((int)(width*.1)));
		LSock.addPoint(x-((int)(width*.2)), y+((int)(width*.4)));
		LSock.addPoint(x-((int)(width*.3)), y+((int)(width*.4)));
		LSock.addPoint(x-((int)(width*.3)), y+((int)(width*.1)));
		LRStripe.reset();
		
		LRStripe.addPoint(x-((int)(width*.2)), y+((int)(width*.25)));
		LRStripe.addPoint(x-((int)(width*.2)), y+((int)(width*.3)));
		LRStripe.addPoint(x-((int)(width*.3)), y+((int)(width*.3)));
		LRStripe.addPoint(x-((int)(width*.3)), y+((int)(width*.25)));
		RRStripe.reset();
		
		RRStripe.addPoint(x-((int)(width*.7)), y+((int)(width*.25)));
		RRStripe.addPoint(x-((int)(width*.7)), y+((int)(width*.3)));
		RRStripe.addPoint(x-((int)(width*.8)), y+((int)(width*.3)));
		RRStripe.addPoint(x-((int)(width*.8)), y+((int)(width*.25)));
		RBStripe.reset();
		
		RBStripe.addPoint(x-((int)(width*.7)), y+((int)(width*.15)));
		RBStripe.addPoint(x-((int)(width*.7)), y+((int)(width*.2)));
		RBStripe.addPoint(x-((int)(width*.8)), y+((int)(width*.2)));
		RBStripe.addPoint(x-((int)(width*.8)), y+((int)(width*.15)));
		LBStripe.reset();
		
		LBStripe.addPoint(x-((int)(width*.2)), y+((int)(width*.15)));
		LBStripe.addPoint(x-((int)(width*.2)), y+((int)(width*.2)));
		LBStripe.addPoint(x-((int)(width*.3)), y+((int)(width*.2)));
		LBStripe.addPoint(x-((int)(width*.3)), y+((int)(width*.15)));
		LShoe.reset();
		if(Dir=="Left"){
		LShoe.addPoint(x-((int)(width*0.15)), y+((int)(width*.45)));
		LShoe.addPoint(x-((int)(width*0.15)), y+((int)(width*.35)));
		LShoe.addPoint(x-((int)(width*.35)), y+((int)(width*.35)));
		LShoe.addPoint(x-((int)(width*.45)), y+((int)(width*.45)));
		}else{
			LShoe.addPoint(x-((int)(width*0.05)), y+((int)(width*.45)));
			LShoe.addPoint(x-((int)(width*0.15)), y+((int)(width*.35)));
			LShoe.addPoint(x-((int)(width*.35)), y+((int)(width*.35)));
			LShoe.addPoint(x-((int)(width*.35)), y+((int)(width*.45)));
		}
		RShoe.reset();
		
		if(Dir=="Left"){
		LShoe.addPoint(x-((int)(width*0.65)), y+((int)(width*.45)));
		LShoe.addPoint(x-((int)(width*0.65)), y+((int)(width*.35)));
		LShoe.addPoint(x-((int)(width*.85)), y+((int)(width*.35)));
		LShoe.addPoint(x-((int)(width*.95)), y+((int)(width*.45)));
		}else{
			LShoe.addPoint(x-((int)(width*0.55)), y+((int)(width*.45)));
			LShoe.addPoint(x-((int)(width*0.65)), y+((int)(width*.35)));
			LShoe.addPoint(x-((int)(width*.85)), y+((int)(width*.35)));
			LShoe.addPoint(x-((int)(width*.85)), y+((int)(width*.45)));
		}
		/////////////////////////////////////////////////////
		Spongebob.setColor(Color.yellow);
		Spongebob.fillPolygon(LArm);
		Spongebob.fillPolygon(LLeg);
		Spongebob.fillPolygon(RLeg);
		Spongebob.setColor(Color.white);
		Spongebob.fillPolygon(LShoulder);
		Spongebob.fillPolygon(RShoulder);
		Spongebob.fillPolygon(LSock);
		Spongebob.fillPolygon(RSock);
		Spongebob.setColor(Color.red);
		Spongebob.fillPolygon(LShoe);
		Spongebob.fillPolygon(LRStripe);
		Spongebob.fillPolygon(RRStripe);
		Spongebob.setColor(Color.blue);
		Spongebob.fillPolygon(LBStripe);
		Spongebob.fillPolygon(RBStripe);
		Spongebob.setColor(Color.black);
		Spongebob.fillPolygon(LShoe);
		Spongebob.fillPolygon(RShoe);
	}
	public void keyReleased(KeyEvent e) {
		//System.out.println(e.getKeyChar());
		
	}
	
	public void keyTyped(KeyEvent e) {
		
		
	}


}
