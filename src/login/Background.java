package login;

import com.twelvemonkeys.image.ImageUtil;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import raven.fbr.FancyBorderRadius;
import shadow.ShadowRenderer;

/**
 *
 * @author RAVEN
 */
public class Background extends JComponent {

    public java.util.List<Component> getBlur() {
        return blurTargets;
    }

    public void setBlur(Component blur) {
        if (blur != null && !blurTargets.contains(blur)) {
            blurTargets.add(blur);
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createImage();
                repaint();
            }
        });
    }

    public void clearBlur() {
        blurTargets.clear();
        createImage();
        repaint();
    }

    private Icon image;
    private BufferedImage bufferedImage;
    private final java.util.List<Component> blurTargets = new java.util.ArrayList<>();

    private double getScaleFactor() {
        java.awt.GraphicsConfiguration gc = getGraphicsConfiguration();
        if (gc != null) {
            return gc.getDefaultTransform().getScaleX();
        }
        return 1.0;
    }

    public Background() {
        image = new ImageIcon(getClass().getResource("/vista/imagenes/AFImgLogin.png"));
    }

    public void setImage(String path) {
        image = new ImageIcon(getClass().getResource(path));
        createImage();
        repaint();
    }

    private void createImage() {
        if (image != null) {
            int width = getWidth();
            int height = getHeight();
            if (width > 0 && height > 0) {
                double scale = getScaleFactor();
                int realWidth = (int) Math.ceil(width * scale);
                int realHeight = (int) Math.ceil(height * scale);
                bufferedImage = new BufferedImage(realWidth, realHeight, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2 = bufferedImage.createGraphics();
                g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
                g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                Rectangle rec = getAutoSize(image, realWidth, realHeight);
                g2.drawImage(((ImageIcon) image).getImage(), rec.x, rec.y, rec.width, rec.height, null);
                if (!blurTargets.isEmpty()) {
                    for (Component blur : blurTargets) {
                        createBlurImage(g2, scale, blur);
                    }
                }
                g2.dispose();
            }
        }
    }

    private void createBlurImage(Graphics2D g, double scale, Component blur) {
        int x = (int) (blur.getX() * scale);
        int y = (int) (blur.getY() * scale);
        int width = (int) (blur.getWidth() * scale);
        int height = (int) (blur.getHeight() * scale);
        int shadow = (int) (8 * scale);
        if (width > 0 && height > 0) {
            BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = img.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Shape shape = new RoundRectangle2D.Double(0, 0, width, height, 30, 30);;
            g2.fill(shape);
            g2.setComposite(AlphaComposite.SrcIn);
            g2.drawImage(ImageUtil.blur(bufferedImage.getSubimage(x, y, width, height), 30f), 0, 0, null);
            g2.setComposite(AlphaComposite.SrcOver);
            g2.setColor(new Color(0, 0, 0, 180));
            g2.fill(shape);
            g2.dispose();
            g.drawImage(new ShadowRenderer(shadow, 0.3f, new Color(0, 0, 0)).createShadow(img), (int) (x - shadow * 0.8f), (int) (y - shadow * 0.8f), null);
            g.drawImage(img, x, y, null);
        }
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        if (bufferedImage != null) {
            int bw = bufferedImage.getWidth();
            int bh = bufferedImage.getHeight();
            BufferedImage img = new BufferedImage(bw, bh, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = img.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            double scale = getScaleFactor();
            g2.fill(new RoundRectangle2D.Double(0, 0, bw, bh, 20 * scale, 20 * scale));
            g2.setComposite(AlphaComposite.SrcIn);
            g2.drawImage(bufferedImage, 0, 0, null);
            g2.dispose();
            Graphics2D g2d = (Graphics2D) grphcs;
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            g2d.drawImage(img, 0, 0, getWidth(), getHeight(), null);
        }
        super.paintComponent(grphcs);
    }

    @Override
    public void setBounds(int i, int i1, int i2, int i3) {
        super.setBounds(i, i1, i2, i3);
        SwingUtilities.invokeLater(new Runnable() {
            @Override 
            public void run() {
                createImage();
                repaint();
            }
        });
    }

    private Rectangle getAutoSize(Icon image, int w, int h) {
        int iw = image.getIconWidth();
        int ih = image.getIconHeight();
        double xScale = (double) w / iw;
        double yScale = (double) h / ih;
        double scale = Math.max(xScale, yScale);
        int width = (int) (scale * iw);
        int height = (int) (scale * ih);
        if (width < 1) {
            width = 1;
        }
        if (height < 1) {
            height = 1;
        }
        int x = (w - width) / 2;
        int y = (h - height) / 2;
        return new Rectangle(new Point(x, y), new Dimension(width, height));
    }
}