/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panel;

import java.text.ChoiceFormat;
import java.text.Format;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ATH
 */
public class FormatRenderer extends DefaultTableCellRenderer {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3667096937148497529L;
	private Format formatter = null;
    public FormatRenderer(Format format){
        this.formatter = format;
    }

    FormatRenderer(ChoiceFormat choiceFormat) {
        this.formatter = choiceFormat;
    }

    @Override
    public void setValue(Object value){
        try {
            if(value != null){
                value = formatter.format(value);
            }
        } catch (Exception e) {
        }
        super.setValue(value);
    }
    
}
