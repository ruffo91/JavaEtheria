package herramientas;

import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CargadorRecursos {
	public static BufferedImage cargarImagenCompatible(final String ruta)
	{
		Image imagen = null;
		
		try
		{
			imagen = ImageIO.read(ClassLoader.class.getResource(ruta));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
		
		BufferedImage imagenAcelerada = gc.createCompatibleImage(imagen.getWidth(null), imagen.getHeight(null));
		
		Graphics g = imagenAcelerada.getGraphics();
		g.drawImage(imagen, 0, 0, null);
		g.dispose();
		
		return imagenAcelerada;
	}
}
