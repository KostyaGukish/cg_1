import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.colorchooser.AbstractColorChooserPanel;

public class Main {
    public static void main(String[] argv) {
        JColorChooser chooser = new JColorChooser();
        chooser.addChooserPanel(new MyChooserPanel());
    }
}

class MyChooserPanel extends AbstractColorChooserPanel {
    public void buildChooser() {
        setLayout(new GridLayout(0, 3));
        makeAddButton("Red", Color.red);
        makeAddButton("Green", Color.green);
        makeAddButton("Blue", Color.blue);
    }

    public void updateChooser() {
    }

    public String getDisplayName() {
        return "MyChooserPanel";
    }

    public Icon getSmallDisplayIcon() {
        return null;
    }
    public Icon getLargeDisplayIcon() {
        return null;
    }
    private void makeAddButton(String name, Color color) {
        JButton button = new JButton(name);
        button.setBackground(color);
        button.setAction(setColorAction);
        add(button);
    }

    Action setColorAction = new AbstractAction() {
        public void actionPerformed(ActionEvent evt) {
            JButton button = (JButton) evt.getSource();

            getColorSelectionModel().setSelectedColor(button.getBackground());
        }
    };
}