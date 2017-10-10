package helpers;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import javax.swing.plaf.metal.MetalScrollBarUI;
import javax.swing.text.DefaultStyledDocument;
import java.awt.*;

public class JScrollPaneDocument extends JScrollPane {
    DefaultStyledDocument styledDocument = new CustomStyledDocument();
    CustomJTextPane textPane;

    public CustomJTextPane getTextPane(){
        return textPane;
    }

    public JScrollPaneDocument(){
        this("");
    }

    public JScrollPaneDocument(String originalState){
        super();
        textPane = new CustomJTextPane(styledDocument, originalState);
        JPanel noWrapPanel = new JPanel( new BorderLayout() );
        noWrapPanel.add( textPane );

        this.setViewportView(noWrapPanel);

        this.getVerticalScrollBar().setUnitIncrement(12);
        this.getVerticalScrollBar().setUI(new MetalScrollBarUI());
        this.getVerticalScrollBar().setBackground(new Color(38,40,49));
        this.getHorizontalScrollBar().setPreferredSize(new Dimension(0,0));
        this.getHorizontalScrollBar().setUnitIncrement(12);

        this.setBorder(BorderFactory.createCompoundBorder( BorderFactory.createMatteBorder(0,0,0,1, Color.black),BorderFactory.createMatteBorder(0,1,1,1, Color.white) ));

        TextLineNumber textLineNumber = new TextLineNumber(textPane);
        this.setRowHeaderView( textLineNumber );

        textPane.setText(originalState);
        textPane.setCaretPosition(0);
    }
}
