/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panel;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.SwingConstants;

/**
 *
 * @author ATH
 */
public class NumberRenderer extends FormatRenderer {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5303003577910368212L;
	public static NumberRenderer get_Pourcentage_render() {
        return new NumberRenderer(new DecimalFormat("#0%"));
    }
    
    public NumberRenderer(NumberFormat format) {
        super(format);
        setHorizontalAlignment(SwingConstants.LEFT);
    }
    public static NumberRenderer get_FCFA_render(){
        return new NumberRenderer(new DecimalFormat("#,##0 FCFA"));
    }
    
}
