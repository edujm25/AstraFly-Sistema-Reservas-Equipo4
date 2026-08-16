package swing;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import raven.fbr.FancyBorderRadius;

/**
 *
 * @author RAVEN
 */
public class Button extends JButton {

    private Shape shape;
    private final RippleEffect rippleEffect;
    private int arc = 30;

    public Button() {
        rippleEffect = new RippleEffect(this);
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(8, 5, 8, 5));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBackground(new Color(4, 103, 232)); // color por defecto, cambialo con setBackground() en cada boton
    }

    /**
     * Que tan redondeadas son las esquinas del boton (en pixeles).
     * 0 = esquinas cuadradas. Numeros mas grandes = mas redondeado.
     */
    public int getArc() {
        return arc;
    }

    public void setArc(int arc) {
        this.arc = arc;
        setBounds(getX(), getY(), getWidth(), getHeight()); // recalcula la forma con el nuevo arc
        repaint();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground()); // usa el color (y transparencia) que le pusiste a ESTE boton
        g2.fill(shape);
        rippleEffect.reder(g2, shape);
        g2.dispose();
        super.paintComponent(grphcs);
    }

    @Override
    public void setBounds(int i, int i1, int i2, int i3) {
        super.setBounds(i, i1, i2, i3);
        shape = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arc, arc);
    }

}