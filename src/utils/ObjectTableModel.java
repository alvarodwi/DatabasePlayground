/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

//based from https://www.logicbig.com/tutorials/java-swing/generate-jtable-model-with-annotation.html Table Model
public abstract class ObjectTableModel<T> extends AbstractTableModel {

    private List<T> objectRows = new ArrayList<>();

    public List<T> getObjectRows() {
        return objectRows;
    }

    public void setObjectRows(List<T> objectRows) {
        this.objectRows = objectRows;
    }

    @Override
    public abstract String getColumnName(int column);

    public abstract String getFieldName(int column);

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        T t = objectRows.get(rowIndex);
        return getValueAt(t, columnIndex);
    }

    public abstract Object getValueAt(T t, int columnIndex);

    @Override
    public int getRowCount() {
        return objectRows.size();
    }
}
