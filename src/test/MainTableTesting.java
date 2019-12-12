/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.Kehadiran;
import model.Matpel;
import model.Rekapan;
import model.Siswa;
import repository.AbsensiRepository;
import utils.ButtonColumn;
import utils.DisplayableObjectTableModel;
import utils.ObjectTableModel;
import utils.RendererHighlighted;
import utils.RowFilterUtil;

/**
 *
 * @author AlvaroDwi
 */
public class MainTableTesting {

    public static void main(String[] args) {
        JFrame frame = createFrame();

        AbsensiRepository repo = new AbsensiRepository();

        ObjectTableModel<Rekapan> tableModel = new DisplayableObjectTableModel<>(Rekapan.class);
        tableModel.setObjectRows(repo.rekapanDao.getAllRekapan());
        JTable table = new JTable(tableModel);

        JTextField filterField = RowFilterUtil.createRowFilter(table);
        RendererHighlighted renderer = new RendererHighlighted(filterField);
        table.setDefaultRenderer(Object.class, renderer);
        JPanel jp = new JPanel();
        jp.add(filterField);
        frame.add(jp, BorderLayout.NORTH);

        //cek tabel kehadiran
//        Action printLogDetail = new AbstractAction() {
//            public void actionPerformed(ActionEvent e)
//            {
//                System.out.println("CLICKED");
//            }
//        };
//        
//        ButtonColumn btnPrintLog = new ButtonColumn(table,printLogDetail,5);

        JScrollPane pane = new JScrollPane(table);
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        frame.add(pane);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JFrame createFrame() {
        JFrame frame = new JFrame("JTable example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(600, 450));
        return frame;
    }
}
