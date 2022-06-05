package asciPanel;


import javax.swing.JTable;
import java.awt.Color;
import java.awt.Component;

class HucreBoyama extends javax.swing.table.DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if ("gelen".equals(table.getName())) {
            cellComponent.setBackground(Color.decode("#60d277").brighter());
        } else {
            cellComponent.setBackground(Color.decode("#e34360").brighter());
        }
        return cellComponent;
    }
}
