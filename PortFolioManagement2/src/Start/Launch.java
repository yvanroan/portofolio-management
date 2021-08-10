package Start;

import View.TheLayout;

import javax.swing.*;
/**
*	 @author: Yvanroan
 */
public class Test {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new TheLayout();
			}
		});
	}
}

