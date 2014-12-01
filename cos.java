import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import static java.lang.Math.*;

public class cos extends JPanel implements ActionListener{

int length = 120;
Timer t;
Graphics2D graph;
int ii=11;
int theta =5;

public cos(){

	t = new Timer(30,this);
			t.start();
}
public void actionPerformed(ActionEvent e){
	
			if(ii>=400)
			ii=-Math.abs(ii);
			else
			ii++;
}
	public void update(){
		for(int i=0;i<400;i++){
			graph.setColor(SystemColor.orange);
				graph.drawLine(250+(int)(length*cos(PI*i/200)*(1-cos(theta*PI*i/200))),
				250+(int)(length*sin(PI*i/200)*(1-cos(theta*PI*i/200))),
				250+(int)(length*cos(PI*(ii+1)/200)*(1-cos(theta*PI*(i+1)/200))),
				250+(int)(length*sin(PI*(ii+1)/200)*(1-cos(theta*PI*(i+1)/200))));
				}
		
	}
	public void paintComponent(Graphics g){
	super.paintComponent(g);
		graph = (Graphics2D)g;
		// graph.setColor(SystemColor.window);
		this.setDoubleBuffered(false);
		graph.fillRect(0,0,getWidth(),getHeight());
		graph.setComposite(AlphaComposite.getInstance(
AlphaComposite.SRC_OVER, 0.50F)); 
		update();

		// for (int i = 0; i < getSize().width; i += 10)
// graph.draw(new Line2D.Float(i, 0, i,
// getSize().height));
// for (int i = 0; i < getSize().height; i += 10)
// graph.draw(new Line2D.Float(0, i, getSize().width, i));
		repaint();
	}
	public static void main(String []args){
		JFrame f = new JFrame();
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		f.setSize(d.width,d.height);
		f.setUndecorated(true);
		f.setContentPane(new cos());
		f.setBackground(SystemColor.info);
		// f.setOpacity(.6f);
		f.setDefaultCloseOperation(3);
		f.setVisible(true);
	}
}