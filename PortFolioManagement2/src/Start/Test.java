package Start;

import View.TheLayout;

import javax.swing.*;

public class Test {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new TheLayout();
			}
		});
/*
			Home home = new Home();
		MainFrame mf = new MainFrame();
		*/
	}
}

