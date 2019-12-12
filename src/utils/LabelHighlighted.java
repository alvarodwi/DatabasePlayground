/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;

//based from https://www.logicbig.com/tutorials/java-swing/jtable-row-filter-highlighting.html ROW-FILTER
public class LabelHighlighted extends JLabel {
    private List<Rectangle2D> rectangles = new ArrayList<>();
    private Color colorHighlight = Color.YELLOW;

    public void reset() {
        rectangles.clear();
        repaint();
    }

    public void highlightText(String textToHighlight) {
        if (textToHighlight == null) {
            return;
        }
        reset();

        final String textToMatch = textToHighlight.toLowerCase().trim();
        if (textToMatch.length() == 0) {
            return;
        }
        textToHighlight = textToHighlight.trim();

        final String labelText = getText().toLowerCase();
        if (labelText.contains(textToMatch)) {
            FontMetrics fm = getFontMetrics(getFont());
            float w = -1;
            final float h = fm.getHeight() - 1;
            int i = 0;
            while (true) {
                i = labelText.indexOf(textToMatch, i);
                if (i == -1) {
                    break;
                }
                if (w == -1) {
                    String matchingText = getText().substring(i,
                            i + textToHighlight.length());
                    w = fm.stringWidth(matchingText);
                }
                String preText = getText().substring(0, i);
                float x = fm.stringWidth(preText);
                rectangles.add(new Rectangle2D.Float(x, 1, w, h));
                i = i + textToMatch.length();
            }
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(),getHeight());
        if (rectangles.size() > 0) {
            Graphics2D g2d = (Graphics2D) g;
            Color c = g2d.getColor();
            for (Rectangle2D rectangle : rectangles) {
                g2d.setColor(colorHighlight);
                g2d.fill(rectangle);
                g2d.setColor(Color.LIGHT_GRAY);
                g2d.draw(rectangle);
            }
            g2d.setColor(c);
        }
        super.paintComponent(g);

    }
}
