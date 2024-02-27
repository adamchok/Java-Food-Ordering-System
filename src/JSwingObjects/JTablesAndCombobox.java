package JSwingObjects;

import javax.swing.JComboBox;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public interface JTablesAndCombobox {
    
    default void addItemToComboBox(JComboBox<String> comboBox, String data) {
        boolean itemExists = false;

        for (int i = 0; i < comboBox.getItemCount(); i++) {
            if (data.equals(comboBox.getItemAt(i))) {
                itemExists = true;
                break;
            }
        }

        if (!itemExists) {
            comboBox.addItem(data);
        }
    }
    
    default void applyFilters(TableRowSorter<DefaultTableModel> sorter) {
        RowFilter<DefaultTableModel, Object> filter = new RowFilter<DefaultTableModel, Object>() {
            @Override
            public boolean include(RowFilter.Entry<? extends DefaultTableModel, ? extends Object> entry) {
                return comboboxFilterImplementation(entry);
            }
        };
        sorter.setRowFilter(filter);
    }
    
    abstract boolean comboboxFilterImplementation(RowFilter.Entry<? extends DefaultTableModel, ? extends Object> entry);
}
