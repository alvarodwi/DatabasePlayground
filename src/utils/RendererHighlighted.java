/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

//based from https://www.logicbig.com/tutorials/java-swing/jtable-row-filter-highlighting.html ROW-FILTER
public class RendererHighlighted extends DefaultTableCellRenderer {
    private JTextField searchField;

    public RendererHighlighted(JTextField searchField) {
        this.searchField = searchField;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean selected, boolean hasFocus,
                                                   int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value,
                selected, hasFocus, row, column);
        JLabel original = (JLabel) c;
        LabelHighlighted label = new LabelHighlighted();
        label.setFont(original.getFont());
        label.setText(original.getText());
        label.setBackground(original.getBackground());
        label.setForeground(original.getForeground());
        label.setHorizontalTextPosition(original.getHorizontalTextPosition());
        label.highlightText(searchField.getText());
        return label;
    }
}
